package com.cuc.threaddome;

import java.util.concurrent.Semaphore;

public class Demo07 {
	public static void main(String[] args) {
		Semaphore semaphore= new Semaphore(5);
		SemaphoreThread st = new SemaphoreThread(semaphore);
		for(int i=1;i<9;i++) {
			new Thread(st,""+i).start();
			
		}
		
	}
	

}

class SemaphoreThread implements Runnable{
     

	private Semaphore semaphore;
	public  SemaphoreThread(Semaphore semaphore ) {
		// TODO Auto-generated constructor stub
		this.semaphore=semaphore;
	
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			semaphore.acquire();
			  System.out.println("����"+Thread.currentThread().getName()+"ռ��һ������������...");
              Thread.sleep(2000);
              System.out.println("����"+Thread.currentThread().getName()+"�ͷų�����");
              semaphore.release();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
