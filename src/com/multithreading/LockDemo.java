package com.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

	public static void main(String[] args) throws InterruptedException {
		RentrentLockDemo rd = new RentrentLockDemo();
		Thread t1 = new Thread(rd);
		Thread t2 = new Thread(rd);
		Thread t3 = new Thread(rd);
		
		t1.start();
		t2.start();
		t1.join();
		t3.start();

	}

}

class RentrentLockDemo implements Runnable{
	
	static ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		if(lock.tryLock()) {
			System.out.println(Thread.currentThread().getName() + " get the lock");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
			lock.unlock();
		}
		else {
			System.out.println(Thread.currentThread().getName() +" executes alternate method");
		}
		
	}
	
	
}
