package binarysearch;

public class CountOccurance {
	public static void main(String[] args) {
		int[] arr ={ 1, 2, 2, 3, 3, 3, 3};
		int first = findFirstOccr(arr,3);
		int last = findLastOccr(arr,3);
		System.out.println(last - first +1);
	}
	
	public static int findFirstOccr(int[] arr, int num) {
		int res = -1;
		int start =0,end =arr.length-1;
		while(start<=end) {
		int	mid = start + (end-start)/2;
			if(arr[mid]==num) {
				res = mid;
				end = mid - 1 ;
			}
			else if(arr[mid]>num) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
			
		}
		return res;
	}
	
	public static int findLastOccr(int[] arr, int num) {
		int res = -1;
		int start =0,end =arr.length-1;
		while(start<=end) {
		int	mid = start + (end-start)/2;
			if(arr[mid]==num) {
				res = mid;
				start = mid + 1 ;
			}
			else if(arr[mid]>num) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
			
		}
		return res;
	}
}
