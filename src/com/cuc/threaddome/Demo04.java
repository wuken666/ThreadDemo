package com.cuc.threaddome;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo04 {

	public static void main(String[] args) {
		System.out.println("开始");
		Lock lock =new ReentrantLock();
		List<String> lists = new ArrayList<>();
		lists.add(0, "123");
		new Thread( new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					if(lock.tryLock()) {
						try {
							System.out.println("获取到了锁");
							for (int i = 0; i < 5; i++) {
								System.out.println(Thread.currentThread().getName()+":"+i);
								
							}
							
						} catch (Exception e) {
							// TODO: handle exception
						}finally {
							lock.unlock();
						}
						
					}else {
						System.out.println("没有拿到锁");
						return;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		},"线程1").start();
		new Thread( new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					if(lock.tryLock()) {
						try {
							System.out.println("获取到了锁");
							for (int i = 0; i < 5; i++) {
								System.out.println(Thread.currentThread().getName()+":"+i);
								
							}
							
						} catch (Exception e) {
							// TODO: handle exception
						}finally {
							lock.unlock();
						}
						
					}else {
						System.out.println("没有拿到锁");
						return;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		},"线程2").start();

	}
}
