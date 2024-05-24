package com.charuniverse.springaspectorientedprogramming.i_pointcut_expression_format;

import com.charuniverse.springaspectorientedprogramming.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PointcutExpressionFormatTest {

    @Autowired
    private HelloService helloService;

    @Test
    void testHelloService() {
        Assertions.assertEquals("Hello Andi", helloService.hello("Andi"));
        Assertions.assertEquals("Bye Andi", helloService.bye("Andi"));

        helloService.test();
    }
}
