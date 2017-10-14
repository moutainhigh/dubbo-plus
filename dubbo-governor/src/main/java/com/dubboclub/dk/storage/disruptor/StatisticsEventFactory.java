package com.dubboclub.dk.storage.disruptor;

import com.lmax.disruptor.EventFactory;

public class StatisticsEventFactory implements EventFactory<StatisticsEvent> {

	@Override
    public StatisticsEvent newInstance() {
        return new StatisticsEvent();
    }
	
}
