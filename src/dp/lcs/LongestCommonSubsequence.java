package dp.lcs;

public class LongestCommonSubsequence {
	static int dp[][] = new int[10001][10001]; // take the values from constraints +1;

	public static void main(String[] args) {
		String s1 = "ABCDGH"; // AGGTAB
		String s2 = "AEDFHR"; // GXTXAYB
		// output : ADH length 3

		int count = LCS(s1, s2, s1.length(), s2.length());
		System.out.println(count);

		for (int i = 0; i < 10001; i++) {
			for (int j = 0; j < 10001; j++)
				dp[i][j] = -1;
		}

		int countdp = LCSMemoized(s1, s2, s1.length(), s2.length()); // Bottom up
		System.out.println(countdp);

		int countTopDown = topDown(s1, s2, s1.length(), s2.length());
		System.out.println(countTopDown);

	}

	public static int LCS(String str1, String str2, int len1, int len2) {

		if (len1 == 0 || len2 == 0)
			return 0;
		else if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) {
			return 1 + LCS(str1, str2, len1 - 1, len2 - 1);
		} else {
			return Math.max(LCS(str1, str2, len1 - 1, len2), LCS(str1, str2, len1, len2 - 1));
		}
	}

	public static int LCSMemoized(String str1, String str2, int len1, int len2) {

		if (len1 == 0 || len2 == 0)
			return 0;
		if (dp[len1][len2] != -1)
			return dp[len1][len2];

		else if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) {
			return dp[len1][len2] = 1 + LCSMemoized(str1, str2, len1 - 1, len2 - 1);
		} else {
			return dp[len1][len2] = Math.max(LCSMemoized(str1, str2, len1, len2 - 1),
					LCSMemoized(str1, str2, len1 - 1, len2));
		}
	}

	public static int topDown(String str1, String str2, int len1, int len2) {
		int mat[][] = new int[len1 + 1][len2 + 1];

		/*
		 * if(len1==0 || len2==0) return 0;
		 */
		for (int i = 0; i < len1 + 1; i++) {
			mat[i][0] = 0;
		}
		for (int i = 0; i < len2 + 1; i++) {
			mat[0][i] = 0;
		}

		/*
		 * if(str1.charAt(len1-1)== str2.charAt(len2-1)) return 1+ LCS(str1, str2,
		 * len1-1, len2-1); else { return Math.max(LCS(str1, str2, len1-1, len2),
		 * LCS(str1, str2, len1, len2-1)); }
		 */
		// len1 = i & len2 = j
		for (int i = 1; i < len1 + 1; i++) {
			for (int j = 1; j < len2 + 1; j++) {

				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					mat[i][j] = 1 + mat[i - 1][j - 1];
				} else {
					mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
				}
			}
		}
		return mat[len1][len2];
	}
}
