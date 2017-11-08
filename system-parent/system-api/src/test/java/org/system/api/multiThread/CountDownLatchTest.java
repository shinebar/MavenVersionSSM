package org.system.api.multiThread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	private static CountDownLatch countDownLatch=new CountDownLatch(5);
	
	static class BossThread extends Thread{
		@Override
		public void run() {
			System.out.println("老板在会议室等待，总共有"+countDownLatch.getCount()+"人开会....");
			try {
				countDownLatch.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("所有人都到齐了，开会。。。。。。。");
			
		}
		
	}
	
	static class EmployeeThread extends Thread{
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+"到达会议室.....");
			//员工到达会议室 count - 1
			countDownLatch.countDown();
		}
	}
	
	public static void main(String[] args) {
		new BossThread().start();
		System.out.println(countDownLatch.getCount());
		for (int i = 0; i < countDownLatch.getCount(); i++) {
			System.out.println(countDownLatch.getCount());
			new EmployeeThread().start();
			System.out.println("dd:"+countDownLatch.getCount());
		}
	}
	
}
