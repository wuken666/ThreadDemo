package com.cuc.threaddome;

public class Demo01 {
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			System.out.println("���߳����ƣ�"+Thread.currentThread().getName()+i);
			if(i==1) {
				new FirstThread().start();
				
			}
			
		}
	}

	
}

class FirstThread extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int i = 0; i < 10; i++) {
			System.out.println("�߳����ƣ�"+this.getName());
			
		}
	}
	
}