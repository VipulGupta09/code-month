package binarysearch;

public class FirstNLastOccurance {
	public static void main(String[] args) {
		int[] arr ={ 1, 2, 2, 2, 2,2, 3, 4, 7, 8, 8 };
		int first = findFirstOccr(arr,2);
		int last = findLastOccr(arr,2);
		System.out.println(first +" "+last);
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
