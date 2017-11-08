package org.system.api.disrupter;
/**
 * longEvent事件数据
 * @author shinebar
 *LMAX 开源了一个高性能并发编程框架。可以理解为消费者-生产者的消息发布订阅模式
 */
public class LongEvent {
	private long value;

	public void set(long value) {
		this.value = value;
	}

	public long get() {
		return this.value;
	}
}
