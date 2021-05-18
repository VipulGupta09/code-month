package com.multithreading;

public class AbstractClassDemo {
	public static void main(String[] args) {
	
	}
}

abstract class PersonDetails {
	String name;
	int age;
	String city;

	public PersonDetails(String name, int age, String city) {
		this.name = name;
		this.age = age;
		this.city = city;
	}
	
	public abstract void getValue();
}

class Student extends PersonDetails {
	String className;

	public Student(String name, int age, String city, String className) {
		super(name, age, city);
		this.className = className;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getValue() {
		// TODO Auto-generated method stub
		
	}

}

class Teacher extends PersonDetails {
	String subject;

	public Teacher(String name, int age, String city, String subject) {
		super(name, age, city);
		this.subject = subject;

	}

	@Override
	public void getValue() {
		// TODO Auto-generated method stub
		
	}

}