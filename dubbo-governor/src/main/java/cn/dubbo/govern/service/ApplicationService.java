package cn.dubbo.govern.service;

import java.util.List;

import cn.dubbo.govern.admin.model.Application;
import cn.dubbo.govern.admin.model.Node;

public interface ApplicationService {

    //获取当前注册中心所有应用列表
    List<Application> getApplications();
    
    //获取某个应用部署节点信息
    List<Node> getNodesByApplicationName(String appName);
    
}
