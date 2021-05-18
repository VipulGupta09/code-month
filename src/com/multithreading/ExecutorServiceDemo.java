package com.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Person p1 = new Person("AA");
		Person p2 = new Person("BB");
		Person p3 = new Person("CC");
		Person p4 = new Person("DD");
		Person p5 = new Person("EE");
		Person p6 = new Person("GG");
		
		/*
		 * Person [] person = {p1,p2,p3,p4,p5,p6};
		 * 
		 * ExecutorService executorService = Executors.newFixedThreadPool(6);
		 * 
		 * for(Person p:person) { executorService.submit(p); }
		 * executorService.shutdown();
		 */
		
		CallableDemo  cd1 = new CallableDemo(2);
		CallableDemo  cd2 = new CallableDemo(3);
		CallableDemo  cd3 = new CallableDemo(4);
		CallableDemo  cd4 = new CallableDemo(5);
		
		CallableDemo[] cd = {cd1,cd2,cd3,cd4};
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		for(CallableDemo calD : cd) {
			Future ft = service.submit(calD);
			System.out.println(ft.get());
		}
			service.shutdown();
		
	}

}

class CallableDemo implements Callable{
	
	private int sum;
	
	public CallableDemo(int sum) {
		this.sum = sum;
	}

	@Override
	public Object call() throws Exception {
		for(int i=0;i<10;i++)
			sum+=i;
		return sum;
	}
	
}

class Person implements Runnable{
	
	private String name;
	
	public Person(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("Current thread is "+name +" "+Thread.currentThread().getName()+" "+"started work..");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Current thread is "+name +" "+Thread.currentThread().getName()+" "+"Completed work..");
		
	}
	
}
