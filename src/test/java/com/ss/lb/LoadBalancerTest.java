package com.ss.lb;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoadBalancerTest {

    private LoadBalancer loadBalancer;

    private void registerServers(String... urls) {
        for (String url : urls) {
            loadBalancer.registerServer(Server.of(url));
        }
    }

    private Matcher<List<Server>> isListOf(String... urls) {
        List<Server> servers = new ArrayList<>();
        for (String url : urls) {
            servers.add(Server.of(url));
        }
        return is(servers);
    }

    @Nested
    class RoundRobinLoadBalancerContext {

        @BeforeEach
        void setUp() {
            loadBalancer = new LoadBalancer();
        }


        @Test
        public void registerServer() {
            registerServers("server1", "server2");

            assertThat(loadBalancer.server(), isListOf("server1", "server2"));
        }

        @Test
        public void serverDoesNotRegisterWhenAlreadyExit() {
            registerServers("server1", "server1");

            assertThat(loadBalancer.server(), isListOf("server1"));
        }

        @Test
        public void whenServerIsNull_throwException() {
            Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                    () -> {
                        loadBalancer.registerServer(null);
                    });
            assertThat(exception.getMessage(), is("server is null"));
        }

        @Test
        public void unregisterServer() {
            registerServers("server1", "server2");

            loadBalancer.unregisterServer(Server.of("server1"));

            assertThat(loadBalancer.server(), isListOf("server2"));
        }

        @Test
        public void getServerByDefaultStrategy_roundRobin() {
            registerServers("server1", "server2", "server3");
            List<Server> servers = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                servers.add(loadBalancer.nextServer());
            }

            assertThat(servers, isListOf("server1", "server2", "server3", "server1"));
        }
    }

    @Nested
    class RandomStrategyLoadBalancerContext {

        @BeforeEach
        void setUp() {
            SelectionStrategy strategy = new RandomStrategy(new Random(65321L));
            loadBalancer = new LoadBalancer(strategy);
        }

        @Test
        public void getServerByRandomStrategy() {
            registerServers("server1", "server2", "server3", "server4");
            List<Server> servers = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                servers.add(loadBalancer.nextServer());
            }

            assertThat(servers, isListOf("server1", "server3", "server4", "server4", "server1"));
        }

    }

}
