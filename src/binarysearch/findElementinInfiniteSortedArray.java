package binarysearch;

public class findElementinInfiniteSortedArray {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		System.out.println(findIndex(arr, 10));
	}
	public static int findIndex(int [] arr,int key) {
		int start = 0, end = 1;
		while(arr[end]<key) {
			start = end;
			end = end *2;
		}
		
		while(start<end) {
			int mid = start + (end - start)/2;
			if(arr[mid] == key) {
				return mid;
			}
			else if(arr[mid]>key) {
				end =  mid -1;
			}
			else {
				start = mid +1;
			}
		}
		
		
		
		return -1;
	}

}
