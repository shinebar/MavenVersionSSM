package org.system.api.disrupter;

import com.lmax.disruptor.EventHandler;

/**
 * 消息者事件处理器，打印输出到控制台 
 * @author shinebar
 *
 */
public class LongEventHandler implements EventHandler<LongEvent> {
	
	public void onEvent(LongEvent event, long sequence, boolean endOfBatch) {
		System.out.println("consumer:" + Thread.currentThread().getName() + " Event: value=" + event.get()
				+ ",sequence=" + sequence + ",endOfBatch=" + endOfBatch);
	}
}
