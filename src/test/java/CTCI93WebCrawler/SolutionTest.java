package CTCI93WebCrawler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Timeout(5)
class SolutionTest {

    private final Solution solution = new Solution();

    /** Web falsa: busca pela URL exata (já normalizada). */
    private static WebFetcher web(Map<String, Page> pages) {
        return pages::get;
    }

    private static Page page(String url, String content, String... links) {
        return new Page(url, content, List.of(links));
    }

    @Test
    void normalize() {
        assertEquals("http://example.com/a/b", solution.normalize("HTTP://Example.com/a/b/#top"));
        assertEquals("http://example.com", solution.normalize("http://example.com/"));
        assertEquals("http://example.com/x?id=1", solution.normalize("http://EXAMPLE.com/x/?id=1#frag"));
        assertEquals("http://example.com/CaseSensitivePath", solution.normalize("http://example.com/CaseSensitivePath"));
    }

    @Test
    void cyclesDoNotCauseInfiniteLoops() {
        Map<String, Page> pages = new HashMap<>();
        pages.put("http://a.com", page("http://a.com", "home", "http://a.com/x", "http://a.com/y"));
        pages.put("http://a.com/x", page("http://a.com/x", "x", "http://a.com/", "http://a.com/y#section"));
        pages.put("http://a.com/y", page("http://a.com/y", "y", "http://A.com/x/", "http://a.com"));
        assertEquals(List.of("http://a.com", "http://a.com/x", "http://a.com/y"),
                solution.crawl("http://a.com/", web(pages), 100));
    }

    @Test
    void duplicateContentIsSkipped() {
        Map<String, Page> pages = new HashMap<>();
        pages.put("http://a.com", page("http://a.com", "home", "http://a.com/p?session=1", "http://a.com/p?session=2"));
        pages.put("http://a.com/p?session=1", page("http://a.com/p?session=1", "product", "http://a.com/p?session=3"));
        pages.put("http://a.com/p?session=2", page("http://a.com/p?session=2", "product", "http://a.com/secret"));
        pages.put("http://a.com/p?session=3", page("http://a.com/p?session=3", "product"));
        pages.put("http://a.com/secret", page("http://a.com/secret", "secret"));
        assertEquals(List.of("http://a.com", "http://a.com/p?session=1"),
                solution.crawl("http://a.com", web(pages), 100));
    }

    @Test
    void respectsMaxPagesAndMissingPages() {
        Map<String, Page> pages = new HashMap<>();
        pages.put("http://a.com", page("http://a.com", "0", "http://a.com/404", "http://a.com/1", "http://a.com/2"));
        pages.put("http://a.com/1", page("http://a.com/1", "1"));
        pages.put("http://a.com/2", page("http://a.com/2", "2"));
        assertEquals(List.of("http://a.com", "http://a.com/1"), solution.crawl("http://a.com", web(pages), 2));
    }

    @Test
    void infiniteGeneratedSite() {
        // Cada página aponta para a próxima (/1 -> /2 -> ...): sem limite seria infinito
        WebFetcher infinite = url -> {
            String n = url.substring(url.lastIndexOf('/') + 1);
            int i = n.matches("\\d+") ? Integer.parseInt(n) : 0;
            return new Page(url, "page " + i, List.of("http://inf.com/" + (i + 1)));
        };
        assertEquals(50, solution.crawl("http://inf.com/0", infinite, 50).size());
    }
}
