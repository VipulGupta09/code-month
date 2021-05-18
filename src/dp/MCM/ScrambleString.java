package dp.MCM;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {
	static Map<String, Boolean> map;
	public static void main(String[] args) {
		String str1 = "great";
		String str2 = "rgeat";
		
		map = new HashMap<String, Boolean>();
		
		boolean flag = solve(str1, str2);
		System.out.println(flag);
	}


	public static boolean solve(String str1, String str2) {
		
		if(str1.compareTo(str2)==0)
			return true;
		if(str1.length()<=1 || str2.length()<=1)
			return false;
		
		String key = str1+"_"+str2;
		if(map.containsKey(key))
			return map.get(key);
		
		boolean flag = false;
		int n = str1.length();
		
		for(int i=1;i<=n-1;i++) {
			/**
             * Now when we are swapping strings:
             *
             *          G R E A T       ----->   T E A R G
             *          0 1 2 3 4                0 1 2 3 4
             * if I Swap at i = 1
             *
             *             GREAT       ------->  TEARG
             *            /    \                 /    \
             *           GR    EAT             TEA    RG
             *
             *  We have to compare
             *              (GR)EAT     --with-->  TEA(RG)   i.e GR of A is A scramble String of RG in B.
             *  and         GR(EAT)    ---with---> (TEA)RG   i.e. EAT is a Scramble string of TEA.
             */

            /**
             * When we are not swapping the Strings.
             *
             * then at that time we have to compare:
             *             GREAT     ------>      GTEAR
             *
             *             compare (G)REAT ----with---->  (G)TEAR
             *             and compare G(REAT) --with---> G(TEAR).
             */
			
			if(solve(str1.substring(0, i), str2.substring(n-i)) ==true &&
					solve(str1.substring(i, n), str2.substring(0, n-i)) ==true
					 ||
				solve(str1.substring(0, i), str2.substring(0,i))==true &&
					solve(str1.substring(i,n), str2.substring(i,n)) ==true
					) {
				flag = true;
				break;
			}
		}
		map.put(key, flag);
		return flag;
	}

}
