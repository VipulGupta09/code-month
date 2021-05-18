package binarysearch;

public class FindElementInSortedRotated {

	public static void main(String[] args) {
		int nums[] = { 4, 5, 6, 7, 0, 1, 2 }, target = 7;

		int mid = findRotation(nums);
		int val = findElement(0, mid - 1, target, nums);
		int val2 = findElement(mid, nums.length - 1, target, nums);

		if (val == -1) {
			System.out.println(val2);
		} else {
			System.out.println(val);
		}
	}

	public static int findRotation(int[] arr) {
		int len = arr.length;
		int start = 0, end = len - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] <= arr[(mid + len - 1) % len] && arr[mid] <= arr[(mid + 1) % len]) {
				return mid;
			} else if (arr[mid] < arr[0]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static int findElement(int start, int end, int target, int arr[]) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == target)
				return mid;
			else if (arr[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

}
