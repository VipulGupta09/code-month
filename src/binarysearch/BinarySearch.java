package binarysearch;

public class BinarySearch {
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6,7,8,9,10,11};
		int index = findIndexOfElement(arr,11);
		int descArr[] = {10,9,8,7,6,5,4,3,2,1};
		int descIndex = findIndexOfElementDesc(descArr,1);
		System.out.println(index);
		System.out.println(descIndex);
	}
	public static int findIndexOfElement(int[] arr, int num) {
		int start = 0, end = arr.length-1;
		while(start<=end) {
			int mid = start + (end-start)/2;
			if(arr[mid] == num) {
				return mid;
			}
			else if(arr[mid]>num) {
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		return -1;
	}
	
	public static int findIndexOfElementDesc(int[] arr, int num) {
		int start = 0, end = arr.length-1;
		while(start<=end) {
			int mid = start + (end - start)/2;
			if(arr[mid] == num) {
				return  mid;
			}
			else if(arr[mid]>num) {
				start = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		return -1;
	}
}
