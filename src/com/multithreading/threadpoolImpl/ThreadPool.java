package com.multithreading.threadpoolImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {

	private BlockingQueue<Runnable> taskQueue = null;
	private List<MyThread> runnables = new ArrayList<MyThread>();

	private boolean isStopped = false;

	public ThreadPool(int noOfThreads, int maxNumberOfTasks) {
		taskQueue = new ArrayBlockingQueue<Runnable>(maxNumberOfTasks);

		for (int i = 0; i < noOfThreads; i++) {
			MyThread poolThreadRunnable = new MyThread(taskQueue);
			runnables.add(poolThreadRunnable);
		}

		for (MyThread runnable : runnables) {
			new Thread(runnable).start();
		}
	}

	public synchronized void execute(Runnable task) throws Exception {
		if (this.isStopped)
			throw new Exception("ThreadPool is stopped");
		this.taskQueue.offer(task);
	}

	public synchronized void stop() {
		this.isStopped = true;
		for (MyThread runnable : runnables) {
			runnable.doStop();
		}
	}
	
	public synchronized void waitUntilAllTasksFinished() {
        while(this.taskQueue.size() > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
