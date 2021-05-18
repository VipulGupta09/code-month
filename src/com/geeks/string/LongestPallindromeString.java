package com.geeks.string;

public class LongestPallindromeString {
	static int resultStart;
	static int resultEnd;
	public static void main(String[] args) {
		String str = "Geek";
		System.out.println(longestPallindrome(str));

	}
	
	public static String longestPallindrome(String str) {
		int strLen = str.length();
		if(strLen<2)
			return str;
		
		for(int start = 0;start<str.length()-1;start++) {
			expandRange(str,start,start);// if odd
			expandRange(str,start,start+1);// if number is even
		}
		return str.substring(resultStart, resultStart+resultEnd);
	}
	
	public static void expandRange(String str, int start, int end) {
		while(start>=0 && end<str.length() && str.charAt(start)==str.charAt(end)) {
			start--;end++;
		}
		if(resultEnd< end-start-1) {
			resultStart = start+1;
			resultEnd = end-start-1;
		}
	}

}
