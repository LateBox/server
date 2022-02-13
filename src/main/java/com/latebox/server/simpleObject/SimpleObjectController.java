package com.latebox.server.simpleObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SimpleObjectController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/simpleObject")
    public SimpleObject simpleObject(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new SimpleObject(counter.incrementAndGet(), String.format(template, name));
    }
}
