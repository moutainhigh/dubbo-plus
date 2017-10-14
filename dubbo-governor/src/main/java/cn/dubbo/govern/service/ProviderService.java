package cn.dubbo.govern.service;

import java.util.List;

import cn.dubbo.govern.admin.model.Provider;

public interface ProviderService {

    //加载所有的服务提供者
    List<Provider> listAllProvider();

    //查询某个应用提供的所有服务信息
    List<Provider> listProviderByApplication(String appName);

    //通过服务查询其提供者信息
    List<Provider> listProviderByService(String service);

    //通过多条件查询符合全部条件的提供者信息
    List<Provider> listProviderByConditions(String...conditions);

    //根据服务的唯一表示查找提供者，group/interfaceName:version
    List<Provider> listProviderByServiceKey(String serviceKey);

    //通过ID查询某个提供者
    Provider getProviderById(long id);

    //更新提供者配置信息
    void updateProvider(Provider newProvider);

    //将某个提供者置为无效
    void disable(Long id);
    //将某个提供者置为有效
    void enable(Long id);
    //将某个提供者权重设置为之前的半
    void halfWeight(Long id);
    //将某个提供者的权重设置为之前的两倍
    void doubleWeight(Long id);
    //删除某个服务提供方
    void delete(Long id);
    //基于某个服务提供方复制另一个服务提供方
    void copy(Long id);

}
