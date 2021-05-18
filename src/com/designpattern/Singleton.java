package com.designpattern;

class SingletonDoubleLock {

	private static SingletonDoubleLock instance;

	private SingletonDoubleLock() {
	}

	public static SingletonDoubleLock getInstance() {
		if (instance == null) {
			synchronized (SingletonDoubleLock.class) {
				if (instance == null) {
					instance = new SingletonDoubleLock();
				}
			}
		}
		return instance;
	}
}

public class Singleton {

	public static void main(String[] args) {
		System.out.println(SingletonDoubleLock.getInstance());
		System.out.println(SingletonDoubleLock.getInstance());

	}

}
