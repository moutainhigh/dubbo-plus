package cn.dubbo.govern.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.dubbo.govern.model.ApplicationInfo;
import cn.dubbo.govern.model.MethodMonitorOverview;
import cn.dubbo.govern.model.ServiceInfo;
import cn.dubbo.govern.model.Statistics;
import cn.dubbo.govern.model.StatisticsOverview;
import cn.dubbo.govern.service.StatisticsStorage;

@Service
public class MysqlStatisticsStorage implements StatisticsStorage {

	@Override
	public void storeStatistics(Statistics statistics) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Statistics> queryStatisticsForMethod(String application,
			String serviceInterface, String method, long startTime, long endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<MethodMonitorOverview> queryMethodMonitorOverview(
			String application, String serviceInterface, int methodSize,
			long startTime, long endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ApplicationInfo> queryApplications() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApplicationInfo queryApplicationInfo(String application, long start,
			long end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatisticsOverview queryApplicationOverview(String application,
			long start, long end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatisticsOverview queryServiceOverview(String application,
			String service, long start, long end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<ServiceInfo> queryServiceByApp(String application,
			long start, long end) {
		// TODO Auto-generated method stub
		return null;
	}

}
