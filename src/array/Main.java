package array;

public class Main {

	public static void main(String[] args) {
		String str ="abccba";
		String str2 = "abc";
		
		int start = 0;
		int end = str.length()-1;
	
		//System.out.println(isPallindrome(str,start,end));
		//System.out.println(isPallindrome(str2, start, str2.length()-1));
		
		
		int arr[]={3, 26, 56, 24, 99, 8, 17};
		
		String str3 = "aacbcdeefc";
		// a 2
		// c 3
		// b 1
		// d 1
		// e 2
		// f 1

	}
	
	// a b c b a
	// 0 1 2 3 4
	static boolean isPallindrome(String str,int start, int end) { // abccba 3 2
		//base condition
		
		
		//only 1 char is left
		if(start == end)
			return true;
		
		// traversion logic
		if(str.charAt(start) !=str.charAt(end))
			return false;
		
		//main logic
		if(start<end+1)
		return isPallindrome(str, start+1, end-1);
		
		return true;
		
	}
	
	
//Approach
//1. consicutive pair(say) 2 variabels x & y
//2. for any x and y check index of previous occurences of them.// not sure
//3. if previous occurence is not similar to current element update min distanc.

//Algo:
	
	
	
	

}
