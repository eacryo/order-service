package com.eacryo.orderservice.service.impl;

import com.eacryo.orderservice.constant.ReduceTypeConstant;
import com.eacryo.orderservice.client.RepositoryClient;
import com.eacryo.orderservice.factory.ReduceRepositoryStrategyProxy;
import com.eacryo.orderservice.service.ReduceRepositoryService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeignReduceRepositoryService implements ReduceRepositoryService, InitializingBean {

    @Autowired
    private RepositoryClient repositoryClient;

    @Override
    public void reduce(int number) {
        String msg = repositoryClient.reduceWithAmount(number);
        System.out.println(msg);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ReduceRepositoryStrategyProxy.registry(ReduceTypeConstant.REDUCE_TYPE_FEIGN, this);
    }
}
