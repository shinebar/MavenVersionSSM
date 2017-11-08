package org.system.api.multiThread;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	static class Parking{
		
		private  Semaphore semaphore;
		
		public Parking(int count) {
			semaphore=new Semaphore(count);
		}
		public void park(){
			try {
				semaphore.acquire();
				long time=(long)(Math.random() * 10);
				System.out.println(Thread.currentThread().getName()+"进入停车场，停车"+time+"秒");
				Thread.sleep(time);
				System.out.println(Thread.currentThread().getName()+"开出停车场....");
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				semaphore.release();
			}
		}
	}
	static class Car extends Thread{
		Parking parking;
		Car(Parking parking){
			this.parking=parking;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			parking.park();
		}
	}
	
	public static void main(String[] args) {
		Parking parking=new Parking(3);
		for (int i = 0; i < 5; i++) {
			new Car(parking).start();
		}

	}

}
