package cn.dubbo.govern.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.dubbo.govern.admin.model.Application;
import cn.dubbo.govern.common.SuperMapper;
import cn.dubbo.govern.model.ApplicationInfo;

public interface ApplicationMapper extends SuperMapper<Application> {

    int addApplication(ApplicationInfo applicationInfo);
    
    List<ApplicationInfo> listApps();
    
    int getAppType(@Param("name")String name);
    
    int updateAppType(@Param("name")String name,@Param("type")int type);

}
