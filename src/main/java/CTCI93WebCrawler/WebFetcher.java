package CTCI93WebCrawler;

public interface WebFetcher {
    /** Baixa a página; retorna null se não existir. */
    Page fetch(String url);
}
