package com.cuc.threaddome;

public class Demo08 {
	public static void main(String[] args) {
		
		Object lock =new Object();
		
		P p=new P(lock);
		C c=new C(lock);
		p.start();
		c.start();
		

	}

}

class ValueObject {
	public static String value = "";
}

class P extends Thread {

	private Object lock;

	public P(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				synchronized (lock) {
					if (!ValueObject.value.equals("")) {
						lock.wait();
					}
					//无商品
					System.out.println("缓冲区无商品,加入商品");
					ValueObject.value=System.currentTimeMillis()+"";
					lock.notifyAll();
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}

class C extends Thread {

	private Object lock;

	public C(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				synchronized (lock) {
					if (ValueObject.value.equals("")) {
						lock.wait();
					}
					//有商品，开始消费
					System.out.println("缓冲区有商品，开始购买商品");
					ValueObject.value="";
					lock.notifyAll();
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
	
}