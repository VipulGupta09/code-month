package slidingwindow;

import java.util.*;

public class Problem_V {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		// 1 3 -1 -3 5 3 6 7
		list.add(1);
		list.add(3);
		list.add(-1);
		list.add(-3);
		list.add(5);
		list.add(3);
		list.add(6);
		list.add(7);
		System.out.println(slidingMaximum(list, 3));

	}

	public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Deque<Integer> deque = new ArrayDeque<Integer>();

		int i = 0, j = 0;

		while (j < A.size()) {

			while (!deque.isEmpty() && A.get(deque.peekLast())<=A.get(j)) {
				deque.pollLast();
			}
			deque.addLast(j);

			if (j - i + 1 < B) {
				j++;
			} else if (j - i + 1 == B) {
				if (!deque.isEmpty() && deque.peekFirst()<i)
					deque.removeFirst();
				list.add(A.get(deque.peekFirst()));
				j++;
				i++;
			}

		}

		return list;

	}

}
