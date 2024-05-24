package com.charuniverse.springaspectorientedprogramming.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloService {

    public String hello(String name) {
        log.info("Called HelloService.hello()");
        return "Hello " + name;
    }

    public String hello(String firstName, String lastName) {
        log.info("Called HelloService.hello()");
        return "Hello " + firstName + " " + lastName;
    }

    public String bye(String name) {
        log.info("Called HelloService.bye()");
        return "Bye " + name;
    }

    public void test() {
        log.info("Called HelloService.test()");
    }

}
