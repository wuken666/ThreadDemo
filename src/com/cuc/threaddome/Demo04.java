package com.cuc.threaddome;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo04 {

	public static void main(String[] args) {
		System.out.println("��ʼ");
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
							System.out.println("��ȡ������");
							for (int i = 0; i < 5; i++) {
								System.out.println(Thread.currentThread().getName()+":"+i);
								
							}
							
						} catch (Exception e) {
							// TODO: handle exception
						}finally {
							lock.unlock();
						}
						
					}else {
						System.out.println("û���õ���");
						return;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		},"�߳�1").start();
		new Thread( new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					if(lock.tryLock()) {
						try {
							System.out.println("��ȡ������");
							for (int i = 0; i < 5; i++) {
								System.out.println(Thread.currentThread().getName()+":"+i);
								
							}
							
						} catch (Exception e) {
							// TODO: handle exception
						}finally {
							lock.unlock();
						}
						
					}else {
						System.out.println("û���õ���");
						return;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		},"�߳�2").start();

	}
}
