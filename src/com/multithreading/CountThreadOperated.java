package com.multithreading;

public class CountThreadOperated {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new check());
		Thread t2 = new Thread(new check());
		

		Thread t3 = new Thread(new check());
		Thread t4 = new Thread(new check());
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		 
		

	}

}

class check implements Runnable{

	volatile  int count = 0;
	@Override
	public void run() {
		count++;
		System.out.println(count);
	}
	
	
}
