package com.dubboclub.dk.storage.mysql.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dubboclub.dk.storage.model.ApplicationInfo;

public interface ApplicationMapper {

    int addApplication(ApplicationInfo applicationInfo);
    
    List<ApplicationInfo> listApps();
    
    int getAppType(@Param("name")String name);
    
    int updateAppType(@Param("name")String name,@Param("type")int type);

}
