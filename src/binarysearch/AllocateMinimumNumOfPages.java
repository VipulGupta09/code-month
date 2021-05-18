package binarysearch;

public class AllocateMinimumNumOfPages {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7,8,9,10}, D = 5;
		int count = shipWithinDays(arr, D);
		System.out.println(count);

	}
	 public static int shipWithinDays(int[] arr, int D) {
	        int end = 0, start = 0;
	        for(int i : arr){
	            end+=i;
	            if(i>start)
	                start = i;
	        }
	        int result = -1;
	        while(start <= end){
	            int mid = start + (end - start)/2;
	            if(isValid(arr,D,mid)){
	                result = mid;
	                end = mid -1;
	            }
	            else{
	                start = mid + 1; 
	            }
	        }
	         return result;   
	    }
	    public static  boolean isValid(int []arr,int D,int mid){
	        int student = 1;
	        int sum = 0;
	        for(int i=0;i<arr.length;i++){
	            sum+=arr[i];
	            if(sum>mid){
	                student++;
	                sum = arr[i];
	            }
	        }
	        if(student>D)
	            return false;
	        return true;
	    }
}
