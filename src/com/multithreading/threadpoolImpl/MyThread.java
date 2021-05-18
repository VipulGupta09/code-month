package com.multithreading.threadpoolImpl;

import java.util.concurrent.BlockingQueue;

public class MyThread implements Runnable {

	private Thread thread = null;
	private BlockingQueue<Runnable> taskQueue = null;
	private boolean isStooped = false;

	public MyThread(BlockingQueue<Runnable> queue) {
		this.taskQueue = queue;
	}

	@Override
	public void run() {
		this.thread = Thread.currentThread();
		while (!isStopped()) {
			try {
				Runnable runnable = (Runnable) taskQueue.take();
				runnable.run();
			} catch (Exception e) {

			}
		}
	}

	public synchronized void doStop() {
		isStooped = true;
		this.thread.interrupt();
	}

	public synchronized boolean isStopped() {
		return isStooped;
	}

}
