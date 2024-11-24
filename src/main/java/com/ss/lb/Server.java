package com.ss.lb;

import java.util.Objects;

public class Server {
    private final String url;

    public Server(String url) {
        this.url = url;
    }

    public static Server of(String url) {
        return new Server(url);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Server server = (Server) o;
        return Objects.equals(url, server.url);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(url);
    }

    @Override
    public String toString() {
        return "Server{" +
                "url='" + url + '\'' +
                '}';
    }
}
