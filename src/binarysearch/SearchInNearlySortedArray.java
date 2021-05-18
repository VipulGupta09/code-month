package binarysearch;

public class SearchInNearlySortedArray {

	// it means i , i+1, i-1
	public static void main(String[] args) {
		int arr[]= {10, 3, 40, 20, 50, 80, 70}; 
		int key = 1;
		System.out.println(findIndex(arr,key));

	}
	// 3, 10,20,40,50,70,80
	public static int findIndex(int arr[],int key) {
		int start =0, end = arr.length-1;
		while(start<=end) {
			int mid = start + (end - start)/2;
			 if(arr[mid] == key )
				 return mid;
			 if(mid!=arr.length-1 && arr[mid+1] ==key)
				 return mid+1;
			 if(mid !=0 && arr[mid-1]==key)
				 return mid-1;
			 else if(arr[mid]>key)
				 end = mid-2;
			 else {
				 start = mid +2;
			 }
		}
			
		
		return -1;
	}

}
