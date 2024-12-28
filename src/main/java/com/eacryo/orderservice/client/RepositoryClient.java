package com.eacryo.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("repository-service")
public interface RepositoryClient {

    @PostMapping("/repository/reduce")
    String reduce();

    @PostMapping("/repository/reduceWithAmount")
    String reduceWithAmount(@RequestParam int amount);
}
