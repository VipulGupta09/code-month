package miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInString {

	public static void main(String[] args) {
		String s= "cbaebabacd", p= "abc";
	System.out.println(findAnagrams(s, p));	
		


	}
	 public static List<Integer> findAnagrams(String s, String p) {
	        int pLen=p.length();
	        int sLen=s.length();
	        if(pLen>sLen)return new ArrayList();
	        
	        int charArr[]=new int[26];
	        
	        for(int i=0;i<pLen;i++){
	            charArr[p.charAt(i)-'a']--;
	            charArr[s.charAt(i)-'a']++;
	        }
	        
	        List<Integer> list=new ArrayList();
	        for(int i=pLen;i<sLen;i++){
	            if(areAllZeroes(charArr)){
	                list.add(i-pLen);
	            }
	            charArr[s.charAt(i)-'a']++;
	            charArr[s.charAt(i-pLen)-'a']--;
	            
	        }
	       if(areAllZeroes(charArr)){
	                list.add(sLen-pLen);
	            }
	        return list;
	    }
	 static   boolean  areAllZeroes(int[] charArr){
	        for(int i=0;i<26;i++)
	            if(charArr[i]!=0)return false;
	        return true;
	    }

}
