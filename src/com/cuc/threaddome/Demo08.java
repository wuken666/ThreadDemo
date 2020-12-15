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
					//����Ʒ
					System.out.println("����������Ʒ,������Ʒ");
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
					//����Ʒ����ʼ����
					System.out.println("����������Ʒ����ʼ������Ʒ");
					ValueObject.value="";
					lock.notifyAll();
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
	
}