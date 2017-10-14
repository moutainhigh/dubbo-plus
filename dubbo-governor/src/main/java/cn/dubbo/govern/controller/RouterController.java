package cn.dubbo.govern.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dubbo.govern.admin.model.Provider;
import cn.dubbo.govern.admin.model.Route;
import cn.dubbo.govern.model.BasicResponse;
import cn.dubbo.govern.model.RouteAbstractInfo;
import cn.dubbo.govern.service.ProviderService;
import cn.dubbo.govern.service.RouteService;

import com.alibaba.dubbo.common.Constants;

@Controller
@RequestMapping("/route")
public class RouterController {

    @Autowired
    private RouteService routeService;

    @Autowired
    private ProviderService providerService;

    @ResponseBody
    @RequestMapping("provider/{serviceKey}/list.htm")
    public List<Route> queryRoutesByServiceKey(@PathVariable("serviceKey")String serviceKey) throws UnsupportedEncodingException {
        serviceKey = URLDecoder.decode(serviceKey, "UTF-8");
        return routeService.listByServiceKey(serviceKey);
    }

    @ResponseBody
    @RequestMapping("create.htm")
    public BasicResponse createRoute(@RequestBody Route route){
        BasicResponse response = new BasicResponse();
        response.setResult(BasicResponse.SUCCESS);
        routeService.createRoute(route);
        return response;
    }

    @ResponseBody
    @RequestMapping("batch-{type}.htm")
    public BasicResponse batchDelete(@RequestParam("ids")String ids,@PathVariable("type") String type){
        BasicResponse response = new BasicResponse();
        String[] idArray = Constants.COMMA_SPLIT_PATTERN.split(ids);
        if("delete".equals(type)){
            for(String id:idArray){
                routeService.deleteRoute(Long.parseLong(id));
            }
        }else if("enable".equals(type)){
            for(String id:idArray){
                routeService.enable(Long.parseLong(id));
            }
        }else if("disable".equals(type)){
            for(String id:idArray){
                routeService.disable(Long.parseLong(id));
            }
        }
        response.setResult(BasicResponse.SUCCESS);
        return response;
    }

    @ResponseBody
    @RequestMapping("{type}_{id}.htm")
    public BasicResponse delete(@PathVariable("type")String type,@PathVariable("id")Long id){
        BasicResponse response = new BasicResponse();
        response.setResult(BasicResponse.SUCCESS);
        if("delete".equals(type)){
            routeService.deleteRoute(id);
        }else if("enable".equals(type)){
            routeService.enable(id);
        }else if("disable".equals(type)){
            routeService.disable(id);
        }else{
            response.setResult(BasicResponse.FAILED);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("update.htm")
    public BasicResponse updateRoute(@RequestBody Route route){
        BasicResponse response = new BasicResponse();
        response.setResult(BasicResponse.SUCCESS);
        route.setRule(null);
        routeService.updateRoute(route);
        return response;
    }

    @ResponseBody
    @RequestMapping("list.htm")
    public List<RouteAbstractInfo> list(){
        List<Provider> providers = providerService.listAllProvider();
        List<RouteAbstractInfo> routeAbstractInfos = new ArrayList<RouteAbstractInfo>();
        for(Provider provider :providers){
            RouteAbstractInfo routeAbstractInfo = new RouteAbstractInfo();
            routeAbstractInfo.setServiceKey(provider.getServiceKey());
            routeAbstractInfo.setApplicationName(provider.getApplication());
            routeAbstractInfo.setRouteCount(routeService.listByServiceKey(provider.getServiceKey()).size());
            if(routeAbstractInfo.getRouteCount()>0){
                routeAbstractInfos.add(routeAbstractInfo);
            }
        }
        return routeAbstractInfos;
    }

    @ResponseBody
    @RequestMapping("get_{id}.htm")
    public Route getRoute(@PathVariable("id")Long id){
        return routeService.getRoute(id);
    }

}
