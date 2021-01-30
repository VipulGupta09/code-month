package slidingwindow;

import java.util.HashMap;

/*Problem Description: No Where, it was an interview problem

John is at a toy store help him pick maximum number of toys. He can only select in a continuous manner and he can select only two types of toys.


Example:
Input:
1
abaccab*/
public class Problem_IX {

	public static void main(String[] args) {
		String str = "abaccab";
		findMaxToysCount(str);
	}
	
	public static void findMaxToysCount(String str) {
		int i=0,j=0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int maxCount = 0;
		
		while(j<str.length()) {
			
			map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0)+1);
			if(map.size()<2) {
				j++;
			}
			else if(map.size()==2) {
				if(maxCount<j-i+1) {
					maxCount = j-i+1;
				}
				j++;
			}
			else if(map.size()>2) {
				while(map.size()>2) {
					map.put(str.charAt(i), map.get(str.charAt(i))-1);
					if(map.get(str.charAt(i))==0)
						map.remove(str.charAt(i));
					i++;
				}
				j++;
			}
		}
		System.out.println(maxCount);
	}

}
