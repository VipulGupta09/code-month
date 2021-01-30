package slidingwindow;

import java.util.HashMap;

//https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring/0

/*Given a string you need to print the size of the longest possible substring that has exactly k unique characters. If there is no possible substring print -1.
Example
For the string aabacbebebe and k = 3 the substring will be cbebebe with length 7.
*/public class Problem_VII {

	public static void main(String[] args) {
		String str = "aabacbebebe";
		String str1 = "aaaa";
		findMaxStringWithKChar(str, 3);
	}
	public static void findMaxStringWithKChar(String str,int k) {
		int i=0,j=0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int maxLength = 0;
		while(j<str.length()) {
			map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0)+1);
			if(map.size()<k) {
				j++;
			}
			
			else if(map.size() == k) {
				if(maxLength < j-i+1) {
					maxLength = j-i+1;
				}
				j++;
			}
			else if(map.size()>k) {
				while(map.size()>k) {
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
