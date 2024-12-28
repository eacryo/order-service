package com.eacryo.orderservice.factory;

import com.eacryo.orderservice.service.ReduceRepositoryService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 让库存系统减少库存量的工厂方法，可能是通过http、feign、或者mq
 */
@Component
public class ReduceRepositoryStrategyProxy {

    public static Map<String, ReduceRepositoryService> factory = new HashMap<>();

    public static void registry(String key,ReduceRepositoryService impl){
        factory.put(key, impl);
    }

    public void doReduce(String key,int number){
        ReduceRepositoryService impl = factory.get(key);
        if(impl != null){
            impl.reduce(number);
        }
        else {
            throw new RuntimeException("No such ReduceRepositoryService");
        }
    }


}
