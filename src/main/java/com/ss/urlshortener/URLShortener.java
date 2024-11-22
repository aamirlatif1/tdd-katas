package com.ss.urlshortener;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class URLShortener {
    private final String baseURL;
    private final IdentifierGenerator identifierGenerator;
    private final Map<URI, URI> urlMap = new HashMap<>();

    public URLShortener(String baseURL, IdentifierGenerator identifierGenerator) {
        this.baseURL = baseURL;
        this.identifierGenerator = identifierGenerator;
    }

    public URI generate(URI longURL) throws URISyntaxException {
        if (longURL == null) {
            throw new IllegalArgumentException("url should not be null");
        }
        URI shortURI = new URI(baseURL + identifierGenerator.generateIdentifier());
        this.urlMap.put(shortURI, longURL);
        return shortURI;
    }

    public URI longURL(URI shortURL) {
        if (shortURL == null) {
            throw new IllegalArgumentException("short url should not be null");
        }
        if (!urlMap.containsKey(shortURL)) {
            throw new IllegalArgumentException("url does not exist");
        }
        return urlMap.get(shortURL);
    }
}
