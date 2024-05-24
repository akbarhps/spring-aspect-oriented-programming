package com.charuniverse.springaspectorientedprogramming.k_passing_parameter;

import com.charuniverse.springaspectorientedprogramming.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PassingParameterTest {

    @Autowired
    private HelloService helloService;

    @Test
    void testHelloService() {
        Assertions.assertEquals("Hello Andi", helloService.hello("Andi"));
        Assertions.assertEquals("Hello Andi Gemink", helloService.hello("Andi", "Gemink"));
        Assertions.assertEquals("Bye Andi", helloService.bye("Andi"));

        helloService.test();
    }
}
