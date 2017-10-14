package cn.dubbo.govern.storage;

import cn.dubbo.govern.model.Statistics;

public class StatisticsEvent {

    private Statistics statistics;

    public void set(Statistics statistics){
        this.statistics = statistics;
    }

    public Statistics get(){
        return statistics;
    }
}
