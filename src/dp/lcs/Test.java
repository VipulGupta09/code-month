package dp.lcs;

public class Test {

	public static void main(String[] args) {
		String A = "abc";
		String B = "aaabc";

	}

	boolean isSubSequence(String A, String B) {
		{
			int i = 0, j = 0;
			while (i < A.length() && j < B.length()) {
				if (A.charAt(i) == B.charAt(j)) {
					i++;
					j++;
				} else
					j++;
			}
			if (i == A.length())
				return true;
			return false;
		}
	}

}
