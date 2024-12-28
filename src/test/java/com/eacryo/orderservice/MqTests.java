package com.eacryo.orderservice;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class MqTests {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Test
    public void testSend() {
        rabbitTemplate.convertAndSend("hello", "this is a message");
    }

    @Test
    public void setObject(){
        Set<String> set = Stream.of("A1", "B", "C").collect(Collectors.toSet());
        rabbitTemplate.convertAndSend("hello", set);
    }

}
