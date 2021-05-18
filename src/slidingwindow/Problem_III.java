package slidingwindow;
//Given a word pat and a text txt. Return the count of the occurences of anagrams of the word in the text.
//https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
import java.util.HashMap;

public class Problem_III {

	public static void main(String[] args) {
		System.out.println(search("AABA", "AABAACAADAABAABA"));

	}
	static int  search(String pat, String txt) {
        int patLen = pat.length();
        int txtLen = txt.length();
        int total = 0;
        int count = 0;
        int i=0,j=0;
       HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int k=0;k<patLen;k++){
            Character ch = pat.charAt(k);
            if(map.containsKey(ch))
                map.put(ch,map.get(ch)+1);
            else{
                map.put(ch,1);
                count++;
            }     
        }
        count = map.size();
        while(j<txtLen){
        	char ch = txt.charAt(j);
            if(map.containsKey(ch)){
            	if(map.containsKey(ch))
    	        {
    	            map.put(ch,map.get(ch)-1);
    	            
    	            if(map.get(ch) == 0)
    	            {
    	                count--;
    	            }
    	        }
            }
            if(j-i+1<patLen)
                j++;
            else if(j-i+1 == patLen){
            	if(count==0)
	            {
	                total++;
	                System.out.println(txt.substring(i,j+1));
	            }
            	if(map.containsKey(txt.charAt(i)))
	            {
	                map.put(txt.charAt(i),map.get(txt.charAt(i))+1);
	                
	                if(map.get(txt.charAt(i))==1)
	                {
	                    count++;
	                }
	            }
                j++;
                i++;
            }
        }
        return total;
    }

}
