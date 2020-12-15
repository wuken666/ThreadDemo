package com.cuc.threaddome;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo11 {

	public static void main(String[] args) {
		 //���ú��ĳش�С
        int corePoolSize = 5;
        //�����̳߳�����ܽ��ܶ����߳�
        int maximumPoolSize = 10;
        //��ǰ�߳�������corePoolSize��С��maximumPoolSizeʱ������corePoolSize���߳�������������
        long keepActiveTime = 200;  
        //����ʱ�䵥λ����
        TimeUnit timeUnit = TimeUnit.SECONDS;
        //�����̳߳ػ�����е��ŶӲ���ΪFIFO������ָ��������д�СΪ5
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(5);
        //����ThreadPoolExecutor�̳߳ض��󣬲���ʼ���ö���ĸ��ֲ���
        ThreadPoolExecutor executor =new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepActiveTime, timeUnit, workQueue);
        for(int i=1;i<15;i++) {
        	PollThread pollThread= new PollThread(i);
        	executor.execute(pollThread);
            //��ȡ�̳߳����̵߳���Ӧ����
            System.out.println("�̳߳����߳���Ŀ��" +executor.getPoolSize() + "�������еȴ�ִ�е�������Ŀ��"+executor.getQueue().size() + "����ִ�����������Ŀ��"+executor.getCompletedTaskCount());
        }
        executor.shutdown();
        
//        PollThread pt= new PollThread(3);
//        new Thread(pt).start();
        
        }
	}
	

class PollThread implements Runnable{

	private int num;
	public PollThread(int num) {
		this.num=num;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("����"+this.num+"��ʼִ��");
		try {
			Thread.currentThread().sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("����"+this.num+"ִ�н���");
		
	}
	
}
