package cn.dubbo.govern.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dubbo.govern.admin.model.Provider;
import cn.dubbo.govern.model.ApplicationInfo;
import cn.dubbo.govern.model.MethodMonitorOverview;
import cn.dubbo.govern.model.MethodStatistics;
import cn.dubbo.govern.model.ServiceInfo;
import cn.dubbo.govern.model.StatisticsOverview;
import cn.dubbo.govern.service.ProviderService;
import cn.dubbo.govern.service.StatisticsStorage;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.utils.ConfigUtils;
import com.alibaba.dubbo.common.utils.StringUtils;

@RestController
@RequestMapping("/monitor")
public class MonitorController {

    @Autowired
    private StatisticsStorage statisticsStorage ;

    @Autowired
    private ProviderService providerService;

    private static final long ONE_DAY=24*60*60*1000;
    private static final long ONE_HOUR=60*60*1000;

    @RequestMapping("/load-interval.htm")
    public Integer queryInterval(){
        return Integer.parseInt(ConfigUtils.getProperty("monitor.collect.interval"));
    }

    @RequestMapping("/{application}/{service}/{method}/now.htm")
    public MethodStatistics queryCurrentMethodStatistics(@PathVariable("application")String application,@PathVariable("service")String service,@PathVariable("method")String method){
        MethodStatistics methodStatistics = new MethodStatistics();
        long currentTime = System.currentTimeMillis();
        methodStatistics.setStatisticsCollection(statisticsStorage.queryStatisticsForMethod(application,service,method,currentTime-ONE_HOUR,currentTime));
        return methodStatistics;
    }

    @RequestMapping("/{application}/{service}/{method}/{startTime}-{endTime}/monitors.htm")
    public MethodStatistics queryMethodStatistics(@PathVariable("application")String application,@PathVariable("service")String service,@PathVariable("method")String method,@PathVariable("startTime")long startTime,@PathVariable("endTime") long endTime){
        MethodStatistics methodStatistics = new MethodStatistics();
        methodStatistics.setStatisticsCollection(statisticsStorage.queryStatisticsForMethod(application,service,method,startTime,endTime));
        return methodStatistics;
    }
    
    @RequestMapping("/{application}/{service}/now.htm")
    public Collection<MethodMonitorOverview> overviewServiceRealTime(@PathVariable("application")String application,@PathVariable("service")String service){
        List<Provider> providers = providerService.listProviderByServiceKey(service);
        List<String> methods = new ArrayList<String>();
        if(providers.size()>0){
            Provider provider = providers.get(0);
            Map<String,String> params = StringUtils.parseQueryString(provider.getParameters());
            String methodStr = params.get(Constants.METHODS_KEY);
            if(!StringUtils.isEmpty(methodStr)){
                String[] methodArray = Constants.COMMA_SPLIT_PATTERN.split(methodStr);
                for(String method:methodArray){
                    methods.add(method);
                }
            }
        }
        long currentTime = System.currentTimeMillis();
        return statisticsStorage.queryMethodMonitorOverview(application,service,methods.size(),currentTime-ONE_HOUR,currentTime);
    }
    
    @RequestMapping("/{application}/{service}/{startTime}-{endTime}/monitors.htm")
    public Collection<MethodMonitorOverview> overviewService(@PathVariable("application")String application,@PathVariable("service")String service,@PathVariable("startTime")long startTime,@PathVariable("endTime") long endTime){
        List<Provider> providers = providerService.listProviderByServiceKey(service);
        List<String> methods = new ArrayList<String>();
        if(providers.size()>0){
            Provider provider = providers.get(0);
            Map<String,String> params = StringUtils.parseQueryString(provider.getParameters());
            String methodStr = params.get(Constants.METHODS_KEY);
            if(!StringUtils.isEmpty(methodStr)){
                String[] methodArray = Constants.COMMA_SPLIT_PATTERN.split(methodStr);
                for(String method:methodArray){
                    methods.add(method);
                }
            }
        }
        return statisticsStorage.queryMethodMonitorOverview(application,service,methods.size(),startTime,endTime);
    }

    @RequestMapping("/index.htm")
    public Collection<ApplicationInfo> monitorIndex(){
        return statisticsStorage.queryApplications();
    }

    @RequestMapping("/{application}/{dayRange}/info.htm")
    public ApplicationInfo queryApplicationInfo(@PathVariable("application")String application,@PathVariable("dayRange")int dayRange){
        long currentTime = System.currentTimeMillis();
        return statisticsStorage.queryApplicationInfo(application,currentTime-ONE_DAY*dayRange,currentTime);
    }

    @RequestMapping("/{application}/{dayRange}/overview.htm")
    public StatisticsOverview queryApplicationOverview(@PathVariable("application")String application,@PathVariable("dayRange")int dayRange){
        long currentTime = System.currentTimeMillis();
        return statisticsStorage.queryApplicationOverview(application,currentTime-(dayRange*ONE_DAY),currentTime);
    }
    
    @RequestMapping("/{application}/{service}/{dayRange}/overview.htm")
    public StatisticsOverview queryServiceOverview(@PathVariable("application")String application,@PathVariable("service")String service,@PathVariable("dayRange")int dayRange){
        long currentTime = System.currentTimeMillis();
        return statisticsStorage.queryServiceOverview(application, service, currentTime - (dayRange * ONE_DAY), currentTime);
    }

    @RequestMapping("/{application}/{dayRange}/services.htm")
    public Collection<ServiceInfo> queryServiceByApp(@PathVariable("application")String application,@PathVariable("dayRange")int dayRange){
        long end = System.currentTimeMillis();
        long start = end-ONE_DAY*dayRange;
        return statisticsStorage.queryServiceByApp(application,start,end);
    }

}
