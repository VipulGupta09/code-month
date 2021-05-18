package dp.MCM;

import java.util.HashMap;
import java.util.Map;

public class BooleanParenthesis {
	static Map<String, Integer> memoization;
	public static void main(String[] args) {
		
		memoization= new HashMap<String, Integer>();
		String str = "T|T&F^T";
		int count = countBoolean(str, 0, str.length() - 1, true);
		System.out.println(count);

	}

	static int countBoolean(String str, int i, int j, boolean isTrue) {
		
		if (i > j) 
			return 0;
		if (i == j) {
			if (isTrue)
				return str.charAt(i) == 'T' ? 1 : 0;
			else
				return str.charAt(i) == 'F' ? 1 : 0;
		}
		
		String key = ""+i+j+isTrue;
		if(memoization.containsKey(key))
			return memoization.get(key);
	
		int ans = 0;
		for (int k = i + 1; k < j; k += 2) {
			int lt = countBoolean(str, i, k - 1, true);
			int lf = countBoolean(str, i, k - 1, false);
			int rt = countBoolean(str, k + 1, j, true);
			int rf = countBoolean(str, k + 1, j, false);
			if (str.charAt(k) == '&') {
				if (isTrue)
					ans += lt * rt;
				else
					ans += lt * rf + lf * rt + lf * rf;
			} else if (str.charAt(k) == '|') {
				if (isTrue)
					ans += lt * rf + lf * rt + lt * rt;
				else
					ans += lf * rf;

			} else if (str.charAt(k) == '^') {
				if (isTrue)
					ans += lt * rf + lf * rt;
				else
					ans += lf * rf + lt * rt;
			}
		}
		ans = ans % 1003;
		memoization.put(key, ans);
		// dp[i][j][getNumfrombool(isTrue)] = ans;
		return ans;
	}
}
