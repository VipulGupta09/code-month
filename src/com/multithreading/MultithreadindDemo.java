package com.multithreading;

public class MultithreadindDemo extends Thread{
	Test1 test1 = new Test1();
	Test2 test2 = new Test2();
	
	public void m1() {
		this.start();
		test1.method1(test2);
	}
	@Override
	public void run() {
		test2.method1(test1);
	}
	public static void main(String[] args) {
		
		MultithreadindDemo thread1 = new MultithreadindDemo();
		thread1.setName("Thread-1");
		thread1.m1();
		
	}
	
	
}

class Test1{
	public synchronized void method1(Test2 t2) {
		System.out.println(Thread.currentThread().getName() +" acquire lock of Class Test-1 Method-1..");
		try {
			System.out.println(Thread.currentThread().getName()+ " enter into sleeping state");
		} catch (Exception e) {
			e.printStackTrace();
		}
		t2.method2();
	}
	public synchronized void method2() {
		System.out.println(Thread.currentThread().getName()+" running Class Test-1 Method-2");
		this.notify();
	}
}
class Test2{
	public synchronized void method1(Test1 t1) {
		System.out.println(Thread.currentThread().getName() +" acquire lock of Class Test-2 Method-1...");
		try {
			System.out.println(Thread.currentThread().getName() +" enter into sleeping state");
			//Thread.sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		t1.method2();
	}
	public synchronized void method2() {
		System.out.println(Thread.currentThread().getName()+" running Class Test-2  Method-2");
	}
}
