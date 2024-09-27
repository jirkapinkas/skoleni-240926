package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestRestController {

    @GetMapping("/test1")
    public String test1() {
        log.info("called test1");
        return "Hello, World 1!";
    }

    @GetMapping("/test2")
    public String test2() {
        log.info("called test2");
        return "Hello, World 2!";
    }

}
