package com.ss.lb;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancer {
    private final SelectionStrategy selectionStrategy;
    List<Server> servers;
    public LoadBalancer() {
        servers = new ArrayList<>();
        selectionStrategy = new RoundRobinStrategy();
    }

    public LoadBalancer(SelectionStrategy strategy) {
        servers = new ArrayList<>();
        selectionStrategy = strategy;
    }

    public void registerServer(Server server) {
        if (server == null) {
            throw new IllegalArgumentException("server is null");
        }
        if (!servers.contains(server)) {
            servers.add(server);
        }
    }

    public List<Server> server() {
        return servers;
    }

    public void unregisterServer(Server server) {
        servers.remove(server);
    }

    public Server nextServer() {
        int size = servers.size();
        return servers.get(selectionStrategy.next(size));
    }

}
