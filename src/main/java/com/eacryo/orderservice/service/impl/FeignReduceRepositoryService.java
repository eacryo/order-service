package com.eacryo.orderservice.service.impl;

import com.eacryo.orderservice.factory.ReduceRepositoryStrategyProxy;
import com.eacryo.orderservice.service.ReduceRepositoryService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class FeignReduceRepositoryService implements ReduceRepositoryService, InitializingBean {

    @Override
    public void reduce(int number) {
        System.out.println("FeignReduceRepositoryService");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ReduceRepositoryStrategyProxy.registry("feign", this);
    }
}