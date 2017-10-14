package com.dubboclub.dk.storage;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dubboclub.dk.storage.model.ApplicationInfo;
import com.dubboclub.dk.storage.model.MethodMonitorOverview;
import com.dubboclub.dk.storage.model.ServiceInfo;
import com.dubboclub.dk.storage.model.Statistics;
import com.dubboclub.dk.storage.model.StatisticsOverview;

public interface StatisticsStorage {

    String STORAGE_KEY="dubbo.monitor.storage";
    Logger LOGGER = LoggerFactory.getLogger("dubbokeeper-server");
    
    void storeStatistics(Statistics statistics);

    /**
     * 查看某个应用的某个接口在制定区间内的监控情况
     * 
     * @param application
     * @param serviceInterface
     * @param method
     * @param startTime
     * @param endTime
     * @return
     */
    List<Statistics> queryStatisticsForMethod(String application, String serviceInterface, String method, long startTime, long endTime);

    /**
     * 查看某个服务的监控概要
     * 
     * @param application
     * @param serviceInterface
     * @param methodSize
     * @param startTime
     * @param endTime
     * @return
     */
    Collection<MethodMonitorOverview> queryMethodMonitorOverview(String application, String serviceInterface, int methodSize, long startTime, long endTime);

    /**
     * 获取所有当前监控的所有应用
     * 
     * @return
     */
    Collection<ApplicationInfo> queryApplications();

    /**
     * 获取某个应用的信息
     * 
     * @param application
     * @param start
     * @param end
     * @return
     */
    ApplicationInfo queryApplicationInfo(String application, long start, long end);
    
    /**
     * 获取某个应用的当前监控概要信息
     * 
     * @param application
     * @param start
     * @param end
     * @return
     */
    StatisticsOverview queryApplicationOverview(String application, long start, long end);

    /**
     * 查询某个应用下面某个服务的统计信息
     * 
     * @param application
     * @param service
     * @param start
     * @param end
     * @return
     */
    StatisticsOverview queryServiceOverview(String application, String service, long start, long end);

    /**
     * 查询某个应用里面提供的服务列表
     * 
     * @param application
     * @param start
     * @param end
     * @return
     */
    Collection<ServiceInfo> queryServiceByApp(String application, long start, long end);
    
}
