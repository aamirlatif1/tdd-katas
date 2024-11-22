package com.ss.urlshortener;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class URLShortenerTest {

    private URLShortener urlShortener;
    private String baseURL;
    @BeforeEach
    void setUp() {
        baseURL = "http://bit.ly/";
    }

    @Nested
    class SequenceURLShortenerContext {

        @BeforeEach
        void setUp() {
            urlShortener = new URLShortener("http://bit.ly/", new SequenceIdentifierGenerator());

        }

        @Test
        public void generateShortUrl() throws URISyntaxException {
            final var longURL = new URI("https://github.com/aamirlatif1/tdd-katas/tree/main/src/main/java/com/ss");
            assertThat(urlShortener.generate(longURL), isShortURL("1"));
            assertThat(urlShortener.generate(longURL), isShortURL("2"));
        }

        @Test
        public void longURLIsNull_throwException() {
            assertThrowsExactly(IllegalArgumentException.class,
                    () -> urlShortener.generate(null),
                    "url should not be null"
            );
        }

        @Test
        public void getLongURL() throws URISyntaxException {
            final var longURL1 = new URI("https://github.com/aamirlatif1/tdd-katas/tree/main/src/main/java/com/1");
            final var longURL2 = new URI("https://github.com/aamirlatif1/tdd-katas/tree/main/src/main/java/com/2");
            assertThat(urlShortener.generate(longURL1), isShortURL("1"));
            assertThat(urlShortener.generate(longURL2), isShortURL("2"));

            assertThat(urlShortener.longURL(new URI(baseURL+"1")), is(longURL1));
            assertThat(urlShortener.longURL(new URI(baseURL+"2")), is(longURL2));
        }

        @Test
        public void whenShortURLDoesNotExist_throwException() {
            assertThrowsExactly(IllegalArgumentException.class,
                    () -> urlShortener.longURL(new URI(baseURL+"invalid")),
                    "url does not exist"
            );
        }
        @Test
        public void whenShortURLIsNull_throwException() {
            assertThrowsExactly(IllegalArgumentException.class,
                    () -> urlShortener.longURL(null),
                    "short url should not be null"
            );
        }
    }

    @Nested
    class IdentifierPoolURLShortenerContext {

        @BeforeEach
        void setUp() {
            urlShortener = new URLShortener("http://bit.ly/", new PoolIdentifierGenerator(new ArrayList<>(List.of("a1", "a2"))));

        }

        @Test
        public void generateShortUrl() throws URISyntaxException {
            final var longURL = new URI("https://github.com/aamirlatif1/tdd-katas/tree/main/src/main/java/com/ss");
            assertThat(urlShortener.generate(longURL), isShortURL("a1"));
            assertThat(urlShortener.generate(longURL), isShortURL("a2"));
        }

        @Test
        public void whenNoIdentifierIsAvailableInPool_throwException() throws URISyntaxException {
            final var longURL = new URI("https://github.com/aamirlatif1/tdd-katas/tree/main/src/main/java/com/ss");
            urlShortener = new URLShortener("http://bit.ly/", new PoolIdentifierGenerator(new ArrayList<>()));

            assertThrowsExactly(IllegalStateException.class,
                    () -> urlShortener.generate(longURL),
                    "no more identifiers available"
            );
        }

    }


    private Matcher<URI> isShortURL(String identifier) throws URISyntaxException {
        return is(new URI(baseURL + identifier));
    }

}
