package cn.dubbo.govern.service;

import java.util.List;

import cn.dubbo.govern.admin.model.Consumer;

public interface ConsumerService {

    //获取某个应用的消费服务的列表
    List<Consumer> listConsumerByApplication(String appName);

    //获取某个服务的所有消费者信息
    List<Consumer> listConsumerByService(String service);

    //通过多条件来查询符合所有条件的消费者信息
    List<Consumer> listConsumerByConditions(String... conditions);
    
}
