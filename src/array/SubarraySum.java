package array;

import java.util.ArrayList;
import java.util.List;

public class SubarraySum {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(3);
		list.add(2);
		int count = birthday(list, 3, 2);
		System.out.println(count);
	}

	public static int birthday(List<Integer> list, int d, int m) {

		int sumTillNow = 0;
		int sizeOfWindow = 0;
		int count = 0;
		int iCounter = 0;
		for (int i = 0; i < list.size(); i++) {
			while (sizeOfWindow < m && sumTillNow < d && iCounter < list.size()) {
				sumTillNow += list.get(iCounter);
				sizeOfWindow++;
				iCounter++;
			}
			if (sizeOfWindow == m && sumTillNow == d) {
				count++;
			}
			sizeOfWindow--;
			sumTillNow -= list.get(i);
		}
		return count;

	}

}
