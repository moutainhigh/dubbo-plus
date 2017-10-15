package com.dubboclub.dk.admin.service;

import com.alibaba.dubbo.common.URL;
import com.dubboclub.dk.admin.model.Override;
import com.dubboclub.dk.admin.model.Provider;

import java.util.List;

public interface OverrideService {

    List<Override> listByProvider(Provider provider);

    List<Override> listByServiceKey(String serviceKey);

    void update(Override override);

    Override getById(Long id);

    void delete(Override override);

    void delete(Long id);

    void add(Override override);

    Provider configProvider(Provider provider);

    URL configProviderURL(Provider provider);
}
