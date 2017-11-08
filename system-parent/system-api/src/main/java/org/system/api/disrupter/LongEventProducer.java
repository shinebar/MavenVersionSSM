package org.system.api.disrupter;

import java.nio.ByteBuffer;

import com.lmax.disruptor.RingBuffer;

/**
 *  生产者，生产longEvent事件 
 * @author shinebar
 *LongEventProducer事件生产者
 */
public class LongEventProducer {
	private final RingBuffer<LongEvent> ringBuffer;

	public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	public void product(ByteBuffer bb) {
		long sequence = ringBuffer.next(); // Grab the next sequence
		try {
			LongEvent event = ringBuffer.get(sequence); // Get the entry in the
														// Disruptor
														// for the sequence
			event.set(bb.getLong(0)); // Fill with data
		} finally {
			ringBuffer.publish(sequence);
		}
	}
}
