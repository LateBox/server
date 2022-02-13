package com.latebox.server.simpleObject;

public class SimpleObject {

    private final long id;
    private final String content;

    public SimpleObject(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
