package com.multithreading;

import java.util.ArrayList;

public class ImmutableNature {
	public static void main(String[] args) {
		String s1 = "abc";
		String s4 = "abcd";
		String s2 = new String("abcd");
		String s3 = s1.intern();
		
		
		System.out.println(s3 == s4);
		
		
		
	}
}
