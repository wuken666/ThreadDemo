package com.cuc.threaddome;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo09 {

	public static void main(String[] args) {
		MyThread myThread= new MyThread();
		myThread.start();
		myThread.interrupt();
		
		System.out.println(myThread.isInterrupted());
		System.out.println("主线程是否有打断标记"+Thread.currentThread().isInterrupted());
		System.out.println(Thread.interrupted());
		System.out.println(myThread.isAlive());
		
		
	}
}

class MyThread extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		
		}
		System.out.println(this.isInterrupted());
	}
	
}
