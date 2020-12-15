package com.cuc.threaddome;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Demo05 {
	
	public static void main(String[] args) {
		ListThread lt= new ListThread();
		
		new Thread(lt,"线程1").start();
		new Thread(lt,"线程2").start();
		new Thread(lt,"线程3").start();
		new Thread(lt,"线程4").start();
		
	}
	
static class ListThread implements Runnable{
		
//		private static List<String> list =Collections.synchronizedList(new ArrayList<>());
		private static CopyOnWriteArrayList<String> list= new CopyOnWriteArrayList<>();

		static {
			list.add("aaa");
			list.add("bbb");
			list.add("ccc");
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
			
			list.add("eeeee");
		}
		}
		
		
		
	}

}
