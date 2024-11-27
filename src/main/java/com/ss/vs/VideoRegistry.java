package com.ss.vs;

import java.util.HashMap;
import java.util.Map;

public class VideoRegistry {
    private static final Map<String, VideoType> videoRegistry = new HashMap<>();

    enum VideoType {REGULAR, CHILDERNS}

    public VideoRegistry() {
    }

    static void addMovie(String title, VideoType type) {
        videoRegistry.put(title, type);
    }

    static VideoType getType(String type) {
        return videoRegistry.get(type);
    }

    public static Movie getMovie(String title) {
        return switch (videoRegistry.get(title)) {
            case REGULAR -> new RegularMovie(title);
            case CHILDERNS -> new ChildrenMovie(title);
        };
    }
}