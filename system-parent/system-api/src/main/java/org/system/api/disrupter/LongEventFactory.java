package org.system.api.disrupter;

import com.lmax.disruptor.EventFactory;

/**
 * LongEventFactory事件工厂
 * @author shinebar
 *
 */
public class LongEventFactory implements EventFactory<LongEvent>{
	@Override
	public LongEvent newInstance() {
		return new LongEvent();
	}
}
