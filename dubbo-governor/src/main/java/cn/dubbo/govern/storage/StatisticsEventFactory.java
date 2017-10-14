package cn.dubbo.govern.storage;

import com.lmax.disruptor.EventFactory;

public class StatisticsEventFactory implements EventFactory<StatisticsEvent> {

	@Override
    public StatisticsEvent newInstance() {
        return new StatisticsEvent();
    }
	
}
