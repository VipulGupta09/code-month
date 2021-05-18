package com.multithreading.threadpoolImpl;

import java.util.HashMap;
import java.util.Map;

public class HashMapInternalImpl {
	public static void main(String[] args) {
		HashMap<Employee, TechStack> map = new HashMap<Employee, TechStack>();
		
		Employee emp1 = new Employee(8, "AA");
		Employee emp2 = new Employee(16, "AB");
		Employee emp3 = new Employee(2, "AC");
		Employee emp4 = new Employee(18, "AD");
		
		TechStack techStack1 = new TechStack(1, "C");
		TechStack techStack2 = new TechStack(2, "C++");
		TechStack techStack3 = new TechStack(3, "Java");
		TechStack techStack4 = new TechStack(4, "Java");
		
		map.put(emp1, techStack1);
		map.put(emp2, techStack2);
		map.put(emp3, techStack3);
		map.put(emp4, techStack4);
		
		/*
		 * for(Map.Entry<Employee, TechStack> entry : map.entrySet()) {
		 * System.out.println(entry.getKey()+" "+entry.getValue()); }
		 */
	System.out.println(	map.get(emp1));
	System.out.println(map.get(emp2));
		
		
	}
}

class Employee{
	private int empId;
	private String empName;
	
	public Employee(int id, String name) {
		this.empId = id;
		this.empName = name;
	}
	
	@Override
	public int hashCode() {
		Employee e1 = this;
		return e1.empId%16;
	}
	
	@Override
	public boolean equals(Object obj) {
		Employee e1 = (Employee)obj;
		if(this.empId == e1.empId) {
				return true;
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}
	
	
}

class TechStack{
	private int experience;
	private String language;
	
	public TechStack(int experience, String lang) {
		this.experience = experience;
		this.language = lang;
	}

	@Override
	public String toString() {
		return "TechStack [experience=" + experience + ", language=" + language + "]";
	}
	
	
}
