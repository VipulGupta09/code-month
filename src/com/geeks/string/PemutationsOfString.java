package com.geeks.string;

import java.util.HashSet;
import java.util.Set;

public class PemutationsOfString {
	// static ArrayList<String> list = new ArrayList<String>();
	static Set<String> list = new HashSet<String>();

	public static void main(String[] args) {

		String str = "CBA";
		permutations(str, 0, str.length());

		for (String s : list)
			System.out.println(s);

	}

	public static void permutations(String str, int start, int end) {
		if (start == end) {
			list.add(str);
			return;
		}

		for (int i = start; i < end; i++) {
			str = interchange(str, start, i);
			permutations(str, start + 1, end);
			str = interchange(str, start, i);
		}

	}

	public static String interchange(String str, int start, int end) {
		char[] array = str.toCharArray();
		char temp = array[start];
		array[start] = array[end];
		array[end] = temp;
		return String.valueOf(array);
	}

}
