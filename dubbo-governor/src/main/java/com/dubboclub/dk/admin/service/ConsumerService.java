package com.dubboclub.dk.admin.service;

import com.dubboclub.dk.admin.model.Consumer;

import java.util.List;

public interface ConsumerService {

    //获取某个应用的消费服务的列表
    List<Consumer> listConsumerByApplication(String appName);

    //获取某个服务的所有消费者信息
    List<Consumer> listConsumerByService(String service);

    //通过多条件来查询符合所有条件的消费者信息
    List<Consumer> listConsumerByConditions(String... conditions);
    
}
