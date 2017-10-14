package com.dubboclub.dk.storage.disruptor;

import com.dubboclub.dk.storage.model.Statistics;

public class StatisticsEvent {

    private Statistics statistics;

    public void set(Statistics statistics){
        this.statistics = statistics;
    }

    public Statistics get(){
        return statistics;
    }
}
