package com.geeks.array;

public class DigitSum {

	public static void main(String[] args) {
		int num = 123456;
		sum(num);
	}
	public static void sum(int num) {
		int count=0;
		while(num>9) {
			int val = 0;
			while(num>0) {
				 val += num%10;
				 num=num/10;
			}
			num = val;
			count++;
		}
		System.out.println(count);
		System.out.println(num);
	}
	

}
