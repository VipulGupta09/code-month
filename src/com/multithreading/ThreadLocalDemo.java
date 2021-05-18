package com.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThreadLocal implements Runnable{
	
	
	
	static int custId = 0;
	private static ThreadLocal threadLocal = new ThreadLocal() {
		protected Integer initialValue() {
			return ++custId;
		}
	};

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+" "+threadLocal.get());
	}
	
}

public class ThreadLocalDemo {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(5);
		MyThreadLocal t1 = new MyThreadLocal();
		
		MyThreadLocal t2 = new MyThreadLocal();
		
		MyThreadLocal t3 = new MyThreadLocal();
		
		MyThreadLocal t4 = new MyThreadLocal();
		
		MyThreadLocal t5 = new MyThreadLocal();
		
		
		MyThreadLocal[] th = {t1,t2,t3,t4,t5};
		
		for(int i=1;i<40;i++)
		for(MyThreadLocal th1 : th)
			service.submit(th1);
		
		service.shutdown();

	}

}
