package com.dubboclub.dk.admin.service;

import com.dubboclub.dk.admin.model.Application;
import com.dubboclub.dk.admin.model.Node;

import java.util.List;

public interface ApplicationService {

    //获取当前注册中心所有应用列表
    List<Application> getApplications();
    
    //获取某个应用部署节点信息
    List<Node> getNodesByApplicationName(String appName);
    
}
