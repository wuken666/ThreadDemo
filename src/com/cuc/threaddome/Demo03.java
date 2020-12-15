package com.cuc.threaddome;

public class Demo03 {
	
	public static void main(String[] args) {
		
		BackThread backThread= new BackThread("后台子线程");
		backThread.setDaemon(true);
		backThread.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i =1; i < 51; i++) {
			System.out.println("主线程"+Thread.currentThread().getName()+i);
		}
		
		FrontThread frontThread =new FrontThread("前端子线程");
	    frontThread.start();
		
	}
	

}

class FrontThread extends Thread { 
	public FrontThread(String name) {
		super(name);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int i = 1; i < 101; i++) {
			try {
				this.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("子线程名称："+this.getName()+i);
			
		}
		
		
	}
	
}

class BackThread extends Thread {

	public BackThread(String name) {
		super(name);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int i = 1; i < 101; i++) {
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("子线程名称："+this.getName()+i);
			
		}
		
	}
	
}
