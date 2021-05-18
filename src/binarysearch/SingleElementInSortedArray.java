package binarysearch;

public class SingleElementInSortedArray {

	public static void main(String[] args) {
		int arr[] = {1,1,2,3,3,4,4,8,8};
				   //0,1,2,3,4,5,6,7,8
		int element = findElement(arr);
		System.out.println(element);
	}
	
	public static int findElement(int [] arr) {
		if(arr.length == 1)
			return arr[0];
		int start = 0,  end = arr.length-1;
		while(start <=end) {
			int mid = start + (end - start)/2;
			
			if(mid == 0 && arr[mid] != arr[mid+1])
				return arr[mid];
			if(mid == arr.length-1 && arr[mid]!=arr[mid-1])
				return arr[mid];
			if(arr[mid]!=arr[mid+1] && arr[mid]!=arr[mid-1])
				return arr[mid];
			
			if(mid % 2 == 0) {
				if(arr[mid]!=arr[mid+1])
					end = mid-1;
				else 
					start = mid+1;
			}
			else {
				if(arr[mid]!=arr[mid-1])
					end = mid-1;
				else
					start = mid+1;
			}
			
		}
		
		
		return -1;
	}

}
