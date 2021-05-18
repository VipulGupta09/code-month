import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ConveryNumberInWords {
	static HashMap<Integer, String> map = new HashMap<Integer, String>();

	public static void main(String[] args) {
		int num = 438237764;
		fillMap();
		findWords(num);
	}
	/*
	 * 1413 = [1, 4, 2, 3] [1000, 100, 10, 1]
	 */

	public static void findWords(int num) {
		int original = num;
		int count = 1;
		ArrayList<Integer> listOfNumber = new ArrayList<Integer>();
		ArrayList<Integer> listOfDigitEquivalent = new ArrayList<Integer>();

		while (num > 0) {
			int temp = num % 10; // give us digit
			num = num / 10;
			listOfNumber.add(temp);
			listOfDigitEquivalent.add(count);
			count = count * 10;
		}
		Collections.reverse(listOfDigitEquivalent);
		Collections.reverse(listOfNumber);
		if (original < 100) {
			String words = getValueForLastTwoDigits(num);
			System.out.println(words);
			return;
		}

		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (i = 0; i < listOfNumber.size() - 2; i++) {
			int i1 = listOfNumber.get(i);
			int i2 = listOfDigitEquivalent.get(i);
			
			if(i1*i2==0)
				continue;
			String s1 = map.get(i1);
			String s2 = map.get(i2);

			sb.append(s1);
			sb.append(" ");
			sb.append(s2);
			sb.append(" ");

		}
		int val = 10;
		int j = 0;
		for (j = i; j < listOfDigitEquivalent.size() - 1; j++) {
			val *= listOfNumber.get(i);
		}
		val = val + listOfNumber.get(j);
		sb.append(getValueForLastTwoDigits(val));
		
		System.out.println(sb.toString());

	}

	public static String getValueForLastTwoDigits(int num) {
		int temp = 0;
		
		if(num>=20 && num<=29)
			temp = 20;
		else if(num>=30 && num<=39)
			temp = 30;
		else if(num>=40 && num<=49)
			temp = 40;
		else if(num>=50 && num<=59)
			temp = 50;
		else if(num>=60 && num<=69)
			temp = 60;
		else if(num>=70 && num<=79)
			temp = 70;
		else if(num>=80 && num<=89)
			temp = 80;
		else if(num>=90 && num<=99)
			temp = 90;
		else
			return map.get(num);
		
		
		return map.get(temp);
	}

	public static void fillMap() {
		map.put(0, "zero");
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "eight");
		map.put(9, "nine");
		map.put(10, "ten");

		map.put(11, "eleven");
		map.put(12, "twelve");
		map.put(13, "thirteen");
		map.put(14, "fourteen");
		map.put(15, "fifteen");
		map.put(16, "sixteen");
		map.put(17, "seventeen");
		map.put(18, "eighteen");
		map.put(19, "nineteen");
		map.put(20, "twenty");

		map.put(30, "thrity");
		map.put(40, "forty");
		map.put(50, "fifty");
		map.put(60, "sixty");
		map.put(70, "seventy");
		map.put(80, "eighty");
		map.put(90, "ninty");
		map.put(100, "hundreed");
		map.put(1000, "thousand");
		map.put(100000, "lakh");
		map.put(10000000, "crore");

	}
}
