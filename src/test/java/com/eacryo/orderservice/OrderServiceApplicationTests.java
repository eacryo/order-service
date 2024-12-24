package com.eacryo.orderservice;

import com.eacryo.orderservice.client.RepositoryClient;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceApplicationTests {

    @Autowired
    private RepositoryClient repositoryClient;

    @Test
    void contextLoads() {
    }

    @Test
    public void testFeignCall(){
        System.out.println(repositoryClient.reduce());
    }

}
