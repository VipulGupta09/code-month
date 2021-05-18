package com.geeks.array;

public class NumberToWord {
	static String one[] = { "", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ", "ten ",
			"eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ", "eighteen ",
			"nineteen " };
	static String ten[] = { "", "", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ",
			"ninety " };

	public static void main(String[] args) {
		long n = 190;
		System.out.println(convertToWords(n));
	}

	public static String convertToWords(long num) {
		String out = "";
		out+=numToWords((int)(num/10000000), "crore ");
		
		out+=numToWords((int)(num/100000)%100, "lakh ");
		
		out+=numToWords((int)(num/1000)%100, "thousand ");
		
		out+=numToWords((int)(num/100)%10, "hundred ");
		
		if(num>100 && num%100>0)
			out+="and ";
		
		out+=numToWords((int)(num%100), "");
		return out;
	}

	public static String numToWords(int n, String s) {
		String str = "";
		if (n > 19) {
			str += ten[n / 10] + one[n % 10];
		} else
			str += one[n];
		if (n != 0)
			str += s;
		return str;
	}

}
