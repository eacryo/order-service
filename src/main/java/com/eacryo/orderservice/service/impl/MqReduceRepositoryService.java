package com.eacryo.orderservice.service.impl;

import com.eacryo.orderservice.constant.ReduceTypeConstant;
import com.eacryo.orderservice.factory.ReduceRepositoryStrategyProxy;
import com.eacryo.orderservice.service.ReduceRepositoryService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class MqReduceRepositoryService implements ReduceRepositoryService, InitializingBean {
    @Override
    public void reduce(int number) {
        System.out.println("MqReduceRepositoryService");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        ReduceRepositoryStrategyProxy.registry(ReduceTypeConstant.REDUCE_TYPE_MQ, this);
    }
}
