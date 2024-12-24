package com.eacryo.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("repository-service")
public interface RepositoryClient {

    @PostMapping("/repository/reduce")
    String reduce();
}
