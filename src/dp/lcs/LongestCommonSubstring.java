package dp.lcs;

public class LongestCommonSubstring {

	
	public static void main(String[] args) {
		String str1 = "abcde", str2 = "ababcde"; 
		int count = longestCommonSubstring(str1, str2, str1.length(), str2.length());
		System.out.println(count);

	}
	public static int longestCommonSubstring(String str1, String str2, int len1, int len2) {
	
		
		int mat[][] = new int[len1+1][len2+1];
		for(int i=0;i<len1+1;i++)
			mat[i][0]=0;
		for(int i=0;i<len2+1;i++)
			mat[0][i]=0;
		
		int maxCount = Integer.MIN_VALUE;
		for(int i=1;i<len1+1;i++) {
			for(int j=1;j<len2+1;j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					mat[i][j] = 1+ mat[i-1][j-1];
					if(mat[i][j]>maxCount) {
						maxCount = mat[i][j];
					}
						
				}	
				else {
					mat[i][j] = 0;
					
				}
			}
		}
		
		return maxCount;
	}

}
