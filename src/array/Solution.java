package array;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		int arr[] = {101, 204, 334, 432, 523, 604,700};
//					{6*10+1,5*10+2,4*10+3,4*10+3,5*10+2,6*10+1};
//					{61,52,43,43,52,61}
//odd- div even- mod{6,2,4,3,5,1}
		rearrange(arr);
	}
	
	//Space = O(1)
		public static void rearrageArray(int arr[]) {
			int i = 0,j=arr.length-1;
			while(i<=j) {
				arr[i] = arr[j]*10+arr[i];
				arr[j] = arr[j]*10+arr[i];
				i++;
				j--;	
			}
			for(int k=0;k<arr.length;k++) {
				if(i%2==0) {
					arr[k] = arr[k]/10;
				}
				else {
					arr[k]=arr[k]%10;
				}
			}
			System.out.println(Arrays.toString(arr));
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Space = O(n)
	public static void rearrange(int[]arr) {
		int temp[] = new int[arr.length];
		int count =0;
		int i=0, j= arr.length-1;
		while(i<=j) {
			if(i!=j) {
			temp[count]=arr[j];
			count++;
			j--;
			}
			temp[count]=arr[i];
			i++;
			count++;
		}
		System.out.println(Arrays.toString(temp));
	}
	
	

}
