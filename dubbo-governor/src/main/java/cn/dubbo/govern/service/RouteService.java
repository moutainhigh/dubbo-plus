package cn.dubbo.govern.service;

import java.util.List;

import cn.dubbo.govern.admin.model.Route;

public interface RouteService {

    void createRoute(Route route);

    void deleteRoute(Long id);

    void updateRoute(Route route);

    List<Route> listByServiceKey(String serviceKey);

    Route getRoute(Long id);

    void enable(Long id);

    void disable(Long id);

}
