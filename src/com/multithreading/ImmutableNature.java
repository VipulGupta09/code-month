package com.multithreading;

class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println("hello");
	}
}

class MyRunnable implements Runnable{
	static Thread th;
	
	

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Runnable called");
			//Thread.yield();
		}
		
		
	}
	
}


public class ImmutableNature {
	static Thread mt;
	public static void main(String[] args) throws InterruptedException {
		MyThread myThread = new MyThread();
		myThread.start();
		
		mt = Thread.currentThread();
		MyRunnable myRunnable = new MyRunnable();
		myRunnable.th = mt;
		Thread thread = new Thread(myRunnable);
		thread.start();
		thread.join();
		for(int i=0;i<10;i++) {
			System.out.println("Main called");
		}

	}
}
