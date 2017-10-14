package cn.dubbo.govern.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.dubbo.govern.admin.model.Consumer;
import cn.dubbo.govern.admin.sync.Pair;
import cn.dubbo.govern.admin.sync.SyncUtils;
import cn.dubbo.govern.service.AbstractService;
import cn.dubbo.govern.service.ConsumerService;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;

@Service
public class ConsumerServiceImpl extends AbstractService implements ConsumerService {

    @Override
    public List<Consumer> listConsumerByApplication(String appName) {
        return filterCategoryData(new ConvertURL2Entity<Consumer>() {
            @Override
            public Consumer convert(Pair<Long, URL> pair) {
                return SyncUtils.url2Consumer(pair);
            }
        },Constants.CONSUMERS_CATEGORY,Constants.APPLICATION_KEY,appName);
    }

    @Override
    public List<Consumer> listConsumerByService(String service) {
        return filterCategoryData(new ConvertURL2Entity<Consumer>() {
            @Override
            public Consumer convert(Pair<Long, URL> pair) {
                return SyncUtils.url2Consumer(pair);
            }
        },Constants.CONSUMERS_CATEGORY,Constants.INTERFACE_KEY,service);
    }

    @Override
    public List<Consumer> listConsumerByConditions(String... conditions) {
        return filterCategoryData(new ConvertURL2Entity<Consumer>() {
            @Override
            public Consumer convert(Pair<Long, URL> pair) {
                return SyncUtils.url2Consumer(pair);
            }
        },Constants.CONSUMERS_CATEGORY,conditions);
    }
    
}
