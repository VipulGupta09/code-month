package array;

import java.util.ArrayList;
import java.util.List;

class Result {

	/*
	 * Complete the 'constructSequence' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER n 2. INTEGER lo 3. INTEGER hi
	 */

	public static List<Integer> constructSequence(int n, int lo, int hi) {
		List<Integer> list = new ArrayList<Integer>();
		int x = hi - lo + 2;
		int y = 2 * (hi - lo) + 1;
		if (n > y || lo == hi) {
			list.add(-1);
			return list;
		}

		else if (n <= x) {
			int ct = hi - 1, f = 0;
			for (int len = 0; len < n; len++) {
				list.add(ct);
				if (f == 0)
					ct++;
				else
					ct--;
				if (ct == hi)
					f = 1;
			}
		} else if (n <= y) {
			int t = hi - lo + 1;
			int ct = hi - (n - t), f = 0;

			for (int len = 0; len < n; len++) {
				list.add(ct);
				if (f == 0)
					ct++;
				else
					ct--;
				if (ct == hi)
					f = 1;
			}
		} else {
			list.add(-1);
		}
		return list;
	}

}
