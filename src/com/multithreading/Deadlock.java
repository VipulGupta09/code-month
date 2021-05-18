package com.multithreading;

public class Deadlock {

	public static void main(String[] args) {
		
		A a = new A();
		B b = new B();
		DeadLockHelper dh = new DeadLockHelper(a, b);
		dh.startCall();

	}

}

class DeadLockHelper implements Runnable{
	A a;
	B b;
	
	public DeadLockHelper(A a, B b) {
		this.a = a;
		this.b = b;
	}
	public void startCall() {
		
		Thread thread = new Thread(this);
		thread.start();
		a.startA(b);
	}

	@Override
	public void run() {
		
		b.startB(a);
		
	}
	
}

class A {
	public synchronized void startA(B b) {
		System.out.println("StartA is called");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		b.lastB();
	}

	public synchronized void lastA() {
		System.out.println("Last A is called");
	}
}

class B {
	public synchronized void startB(A a) {
		System.out.println("StartB is called");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a.lastA();
	}

	public synchronized void lastB() {
		System.out.println("Last B is called");
	}
}
