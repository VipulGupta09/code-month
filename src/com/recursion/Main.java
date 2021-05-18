package com.recursion;

import java.util.ArrayList;

public class Main {

	static String str = " ";
	public static void main(String[] args) {
		//System.out.println(kthGrammar(30, 434991989));
		
		kthGrammarR(4,6);
	}

	public static int kthGrammar(int N, int K) {
		char ch = find(1, N, K);
		return ch - '0';
	}

	public static char find(int tempN, int N, int k) {
		if (tempN == N) {
			solve(str);
			return str.charAt(k-1);
		}
		solve(str);
		return find(tempN + 1, N, k);

	}

	public static void solve(String s) {
		if (s.trim().length() == 0) {
			str = "0";
			return;
		}
		if(s.length() == 1) {
			str = "01";
			return;
		}
		StringBuffer sb = new StringBuffer();
		int temp = (str.length()/2);
		sb.append(str);
		for (int i = temp; i < str.length(); i++) {
			if (str.charAt(i) == '0') {
				sb.append("01");
			} else if (str.charAt(i) == '1') {
				sb.append("10");
			}
		}
		str = sb.toString();

	}
	public static int kthGrammarR(int N, int K) {
        if (N == 1 && K == 1) {
      return 0;
    }
        double length = Math.pow(2, N - 1);
        double mid = length / 2;

    // Hypothesis
    if (K <= mid) {
      return kthGrammarR(N - 1, K);
    } else {
      // Induction
      if (kthGrammarR(N - 1, (int) (K - mid)) == 0) {
        return 1;
      } else {
        return 0;
      }
    }
  }
}
