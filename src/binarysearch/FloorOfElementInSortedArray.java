package binarysearch;

public class FloorOfElementInSortedArray {

	public static void main(String[] args) {
		int arr[] = {1, 2, 8, 10, 10, 12, 19}, x = 0;
		int count = findFloor(arr, x);
		System.out.println(count);

		int count1 = findCeil(arr, 11);
		System.out.println(count1);

	}
	public static int findFloor(int[] arr,int key) {
		int start = 0, end = arr.length-1;
		int result = Integer.MIN_VALUE;
		while(start<=end) {
			int mid = start + (end - start)/2;
			
			if(arr[mid] ==key) {
				return arr[mid];
			}
			else if(arr[mid]>key) {
				
				end = mid -1;
			}
			else {
				if(arr[mid] >result)
					result = arr[mid];
				start = mid+1;
				
			}
		}
		return result;
	}
	public static int findCeil(int[] arr,int key) {
		int start = 0, end = arr.length-1;
		int result = Integer.MAX_VALUE;
		while(start<=end) {
			int mid = start + (end - start)/2;
			
			if(arr[mid] ==key) {
				return arr[mid];
			}
			else if(arr[mid]>key) {
				if(arr[mid]<result)
					result = arr[mid];
				end = mid -1;
			}
			else {
				start = mid+1;
				
			}
		}
		return result;
	}

}
