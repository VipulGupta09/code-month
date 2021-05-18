package dp.lcs;

public class ShortestCommonSubsequenceLength {
	 static int dp[][] = new int[101][101]; // take the values from constraints +1;
	public static void main(String[] args) {
		for(int i=0;i<101;i++) {
			   for(int j=0;j<101;j++)
				   dp[i][j] = -1;
		   }
		
		String str1 = "AGGTAB",  str2 = "GXTXAYB";
		int count = LCSMemoized(str1, str2, str1.length(), str2.length());
		
		int shortestLength = str1.length() + str2.length() - count;
		System.out.println(shortestLength); //9

	}
	public static int LCSMemoized(String str1, String str2, int len1, int len2) {
		
		if(len1==0 || len2==0)
			return 0;
		if(dp[len1][len2]!=-1)
			return dp[len1][len2];
		
		else if(str1.charAt(len1-1)== str2.charAt(len2-1)) {
			return dp[len1][len2] = 1+ LCSMemoized(str1, str2, len1-1, len2-1);
		}
		else {
			return dp[len1][len2] = Math.max(LCSMemoized(str1, str2, len1-1, len2), LCSMemoized(str1, str2, len1, len2-1));
		}
	}
}