package cn.dubbo.govern.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.dubbo.govern.admin.model.Route;
import cn.dubbo.govern.admin.sync.Pair;
import cn.dubbo.govern.admin.sync.SyncUtils;
import cn.dubbo.govern.admin.sync.Tool;
import cn.dubbo.govern.service.AbstractService;
import cn.dubbo.govern.service.RouteService;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;

@Service
public class RouteServiceImpl extends AbstractService implements RouteService {

    @Override
    public void createRoute(Route route) {
        add(route.toUrl());
    }

    @Override
    public void deleteRoute(Long id) {
        delete(id, Constants.ROUTERS_CATEGORY);
    }

    @Override
    public void updateRoute(Route route) {
        URL oldUrl = getOneById(Constants.ROUTERS_CATEGORY,route.getId());
        update(oldUrl,route.toUrl());
    }

    @Override
    public List<Route> listByServiceKey(final String serviceKey) {
        return filterCategoryData(new ConvertURL2Entity<Route>() {

            @Override
            public Route convert(Pair<Long, URL> pair) {
                if(pair.getValue().getPath().equals(Tool.getInterface(serviceKey))){
                    return SyncUtils.url2Route(pair);
                }else{
                    return null;
                }
            }
        }, Constants.ROUTERS_CATEGORY, Constants.VERSION_KEY, Tool.getVersion(serviceKey),Constants.GROUP_KEY,Tool.getGroup(serviceKey));
    }

    @Override
    public Route getRoute(Long id) {
        return SyncUtils.url2Route(new Pair<Long, URL>(id,getOneById(Constants.ROUTERS_CATEGORY,id)));
    }

    @Override
    public void enable(Long id) {
        Route route = getRoute(id);
        if(route.isEnabled()){
            return ;
        }
        route.setEnabled(true);
        updateRoute(route);
    }

    @Override
    public void disable(Long id) {
        Route route = getRoute(id);
        if(!route.isEnabled()){
            return ;
        }
        route.setEnabled(false);
        updateRoute(route);
    }
}
