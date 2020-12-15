package com.cuc.threaddome;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo10 {
	
	
	public static void main(String[] args) {
		ABCABCThread abc=new ABCABCThread();
		
		new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i <11; i++) {
					abc.loopA(i);
				}
			}
		},"A").start();
		new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i <11; i++) {
					abc.loopB(i);
				}
			}
		},"B").start();
		new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i <11; i++) {
					abc.loopC(i);
				}
			}
		},"C").start();
	}

	
	

}



class ABCABCThread extends Thread{
	private  int num=1;
	Lock lock =new ReentrantLock();
	Condition condition1= lock.newCondition();
	Condition condition2= lock.newCondition();
	Condition condition3= lock.newCondition();
	
	public void loopA(int totalNum) {
		lock.lock();
		try {
			if(this.num!=1) {
				condition1.await();
			}
			System.out.println(this.currentThread().getName()+"---"+totalNum);
			num=2;
			condition2.signal();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
	}
	public void loopB(int totalNum) {
		lock.lock();
		try {
			if(this.num!=2) {
				condition2.await();
			}
			System.out.println(this.currentThread().getName()+"---"+totalNum);
			num=3;
			condition3.signal();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
	}
	public void loopC(int totalNum) {
		lock.lock();
		try {
			if(this.num!=3) {
				condition3.await();
			}
			System.out.println(this.currentThread().getName()+"---"+totalNum);
			num=1;
			condition1.signal();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
	}

}