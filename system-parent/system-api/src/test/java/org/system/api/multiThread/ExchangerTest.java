package org.system.api.multiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerTest {
	static class Producer implements Runnable{
		//生产者，消费都交换的数据结构
		private List<String> buffer;
		//生产者和消费都交换对象
		private Exchanger<List<String>> exchanger;
		
	    public Producer(List<String> buffer, Exchanger<List<String>> exchanger) {
			this.buffer = buffer;
			this.exchanger = exchanger;
		}

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println("生产者第"+i+"次提供");
				for (int j = 0; j < 3; j++) {
					System.out.println("生产者装入"+i+"--"+j);
					buffer.add("buffer:"+i+"--"+j);
				}
				System.out.println("生产者装满，等待和消费者交换。。。");
				try {
					exchanger.exchange(buffer);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	static class Consumer implements Runnable {
		private List<String> buffer;
		private Exchanger<List<String>> exchanger;
		
	    public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
			this.buffer = buffer;
			this.exchanger = exchanger;
		}

		@Override
	    public void run() {
	    	for (int i = 0; i < 5; i++) {
				try {
					//调用exchanger()与消费者进行数据交换
					buffer = exchanger.exchange(buffer);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("消费者第"+i+"次被提取");
				for (int j = 0; j < 3; j++) {
					System.out.println("消费者："+buffer.get(0));
					buffer.remove(0);
				}
			}
	    	
	    }
	}

	public static void main(String[] args) {
		List<String> buffer1=new ArrayList<>();
		List<String> buffer2=new ArrayList<>();
		Exchanger<List<String>> exchanger=new Exchanger<>();
		Thread producerThread=new Thread(new Producer(buffer1,exchanger));
		Thread consumerThread=new Thread(new Consumer(buffer2, exchanger));
		producerThread.start();
		consumerThread.start();
		

	}

}
