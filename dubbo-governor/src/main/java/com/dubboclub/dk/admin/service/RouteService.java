package com.dubboclub.dk.admin.service;

import com.dubboclub.dk.admin.model.Route;

import java.util.List;

public interface RouteService {

    void createRoute(Route route);

    void deleteRoute(Long id);

    void updateRoute(Route route);

    List<Route> listByServiceKey(String serviceKey);

    Route getRoute(Long id);

    void enable(Long id);

    void disable(Long id);

}
