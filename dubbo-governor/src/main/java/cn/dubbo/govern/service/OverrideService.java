package cn.dubbo.govern.service;

import java.util.List;

import cn.dubbo.govern.admin.model.Provider;

import com.alibaba.dubbo.common.URL;

public interface OverrideService {

    List<cn.dubbo.govern.admin.model.Override> listByProvider(Provider provider);

    List<cn.dubbo.govern.admin.model.Override> listByServiceKey(String serviceKey);

    void update(cn.dubbo.govern.admin.model.Override override);

    cn.dubbo.govern.admin.model.Override getById(Long id);

    void delete(cn.dubbo.govern.admin.model.Override override);

    void delete(Long id);

    void add(cn.dubbo.govern.admin.model.Override override);

    Provider configProvider(Provider provider);

    URL configProviderURL(Provider provider);
}
