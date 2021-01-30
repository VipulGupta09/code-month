package slidingwindow;

import java.util.HashMap;


//Given a string s, find the length of the longest substring without repeating characters.
//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class Problem_VIII {

	public static void main(String[] args) {
		String str = "aabacbebebe";
		String str1 = "aaaa";
		findMaxStringWithKUniqueChar(str, 3);
	}
	
	public static void findMaxStringWithKUniqueChar(String str,int k) {
		int i=0,j=0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int maxLength = 0;
		while(j<str.length()) {
			map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0)+1);
			
			if(map.size() == j-i+1) {
				if(maxLength < j-i+1) {
					maxLength = j-i+1;
				}
				j++;
			}
			else if(map.size()<j-i+1) {
				while(map.size()<j-i+1) {
					map.put(str.charAt(i), map.get(str.charAt(i))-1);
					if(map.get(str.charAt(i))==0) 
						map.remove(str.charAt(i));
					i++;	
				}
				j++;
			}
		}
		System.out.println(maxLength);
	}
}
