package cn.dubbo.govern.storage;

import cn.dubbo.govern.model.Statistics;

import com.lmax.disruptor.RingBuffer;

/**
 * 统计数据的生产者,将统计的数据封装成disruptor的event
 * 
 * @author lry
 */
public class StatisticsProducer {

    private final RingBuffer<StatisticsEvent> statisticsEventRingBuffer;

    public StatisticsProducer(RingBuffer<StatisticsEvent> statisticsEventRingBuffer) {
        this.statisticsEventRingBuffer = statisticsEventRingBuffer;
    }

    public void produce(Statistics statistics){
        long sequence = statisticsEventRingBuffer.next();
        try{
            StatisticsEvent statisticsEvent = statisticsEventRingBuffer.get(sequence);
            statisticsEvent.set(statistics);
        }finally {
            statisticsEventRingBuffer.publish(sequence);
        }
    }
}
