package com.cuc.threaddome;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo11 {

	public static void main(String[] args) {
		 //设置核心池大小
        int corePoolSize = 5;
        //设置线程池最大能接受多少线程
        int maximumPoolSize = 10;
        //当前线程数大于corePoolSize、小于maximumPoolSize时，超出corePoolSize的线程数的生命周期
        long keepActiveTime = 200;  
        //设置时间单位，秒
        TimeUnit timeUnit = TimeUnit.SECONDS;
        //设置线程池缓存队列的排队策略为FIFO，并且指定缓存队列大小为5
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(5);
        //创建ThreadPoolExecutor线程池对象，并初始化该对象的各种参数
        ThreadPoolExecutor executor =new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepActiveTime, timeUnit, workQueue);
        for(int i=1;i<15;i++) {
        	PollThread pollThread= new PollThread(i);
        	executor.execute(pollThread);
            //获取线程池中线程的相应参数
            System.out.println("线程池中线程数目：" +executor.getPoolSize() + "，队列中等待执行的任务数目："+executor.getQueue().size() + "，已执行完的任务数目："+executor.getCompletedTaskCount());
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
		System.out.println("任务"+this.num+"开始执行");
		try {
			Thread.currentThread().sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("任务"+this.num+"执行结束");
		
	}
	
}
