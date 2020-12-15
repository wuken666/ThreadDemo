package com.cuc.threaddome;

import java.util.concurrent.CountDownLatch;

public class Demo06 {
	
	public static void main(String[] args) {
		
		CountDownLatch latch = new  CountDownLatch(50);
		
		CountDownThread ct = new CountDownThread(latch);
		
		long start= System.currentTimeMillis();
		
		for(int i=1;i<51;i++) {
			new Thread(ct,"线程"+i).start();
		}
		try {
			latch.await();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		long end =System.currentTimeMillis();
		System.out.println("50个线程输出1-50000之间的偶数共用时："+((end-start)/2)/1000+"秒");
		
		
		
	}
	
	
	
	
	
	
   

}
class  CountDownThread implements Runnable{

		private CountDownLatch latch;
		public CountDownThread(CountDownLatch latch) {
			this.latch=latch;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				for(int i=0;i<50000;i++) {
					if(i%2==0) {
						System.out.println(Thread.currentThread().getName()+":1到50000之间的偶数："+i);
					}
				}
			} finally {
				// TODO: handle finally clause
				latch.countDown();
				
			}
		}
		
		
		
	}
