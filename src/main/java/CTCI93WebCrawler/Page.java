package CTCI93WebCrawler;

import java.util.List;

public record Page(String url, String content, List<String> links) {
}
