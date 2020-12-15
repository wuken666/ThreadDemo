package com.cuc.threaddome;

public class Demo02 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println("主线程名称："+Thread.currentThread().getName()+i);
			if(i==1) {
				new Thread(new SecondThread(),"子线程1").start();
				
				new Thread(new SecondThread(),"子线程2").start();
				
				
				
			}
			
		}
	}

}

class SecondThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			
			System.out.println("子线程名称："+Thread.currentThread().getName());
			
		}
	}
	
}
