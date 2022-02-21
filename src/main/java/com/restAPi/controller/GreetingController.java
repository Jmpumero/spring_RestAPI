package com.restAPi.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.restAPi.service.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //@RequestMapping(method=GET) otra forma
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World :o") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}