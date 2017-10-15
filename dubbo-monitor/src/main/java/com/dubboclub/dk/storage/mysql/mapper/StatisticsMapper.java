package com.dubboclub.dk.storage.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dubboclub.dk.storage.model.ServiceInfo;
import com.dubboclub.dk.storage.model.Statistics;

public interface StatisticsMapper {

    Integer addOne(@Param("application")String application,@Param("statistics")Statistics statistics);

    Integer batchInsert(@Param("application")String application,@Param("list")List<Statistics> statistics);

    Long queryMaxElapsed(@Param("application")String application,@Param("service")String service,@Param("start")long start,@Param("end")long end);

    Long queryMaxConcurrent(@Param("application")String application,@Param("service")String service,@Param("start")long start,@Param("end")long end);

    Integer queryMaxFault(@Param("application")String application,@Param("service")String service,@Param("start")long start,@Param("end")long end);

    Integer queryMaxSuccess(@Param("application")String application,@Param("service")String service,@Param("start")long start,@Param("end")long end);

    List<Statistics> queryStatisticsForMethod(@Param("application")String application,@Param("start")long start,@Param("end")long end,@Param("serviceInterface")String serviceInterface,@Param("method")String method);

    Long queryMethodMaxItemByServiceForLong(@Param("item")String item,@Param("application")String application,@Param("serviceInterface")String serviceInterface,@Param("method")String method,@Param("start")long start,@Param("end")long end);

    Integer queryMethodMaxItemByServiceForInteger(@Param("item")String item,@Param("application")String application,@Param("serviceInterface")String serviceInterface,@Param("method")String method,@Param("start")long start,@Param("end")long end);

    Double queryMethodMaxItemByServiceForDouble(@Param("item")String item,@Param("application")String application,@Param("serviceInterface")String serviceInterface,@Param("method")String method,@Param("start")long start,@Param("end")long end);

    List<String> queryMethodForService(@Param("application")String application,@Param("serviceInterface")String serviceInterface);

    List<Statistics> queryApplicationOverview(@Param("application")String application,@Param("item")String item,@Param("start")long start,@Param("end")long end);

    List<Statistics> queryServiceOverview(@Param("application")String application,@Param("service")String service,@Param("item")String item,@Param("start")long start,@Param("end")long end);

    List<ServiceInfo> queryServiceByApp(@Param("application")String application);

}
