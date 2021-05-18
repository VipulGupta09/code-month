package com.multithreading;

import java.util.ArrayList;

public class ProducerConsumerProblem {

	public static void main(String[] args) {
		Process process = new Process();
		
		Producer producer = new Producer(process);
		Thread t1 = new Thread(producer);
		
		Consumer consumer = new Consumer(process);
		Thread t2 = new Thread(consumer);
		t2.start();
		t1.start();
		

	}

}

class Consumer implements Runnable {
	Process process;

	public Consumer(Process process) {
		this.process = process;
	}

	@Override
	public void run() {
		try {
			process.consumer();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Producer implements Runnable {
	Process process;

	public Producer(Process process) {
		this.process = process;
	}

	@Override
	public void run() {
		try {
			process.producer();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Process {
	ArrayList<Integer> list = new ArrayList<Integer>();
	int capacity = 3;

	public void producer() throws InterruptedException {
		int value = 0;
		while (true) {
			synchronized (this) {

				while (list.size() == 2) {
					wait();
					value = 0;
				}
					
				System.out.println("Producer Produces " + value);

				list.add(value++);

				notify();

				Thread.sleep(1000);
			}
		}
	}

	public void consumer() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (list.size() == 0)
					wait();

				int val = list.remove(0);
				System.out.println("Consumer consumes " + val);

				notify();

				Thread.sleep(1000);
			}
		}
	}
}
