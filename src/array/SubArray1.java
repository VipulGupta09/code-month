package array;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Find all the subarrays having the sum less than or equla to k
public class SubArray1 {

	public static void main(String[] args) {
		int arr[] = {2, 1, 3, 4, 5, 6, 2}, K = 10 ;
		int arr1[] = {2,7,1,4}, K1=7;
		int arr2[] = {10,5,2,6}, k2=100;
		int arr3[] = {1,2,3}, K3 =0;
		
		 // findSubArrays(arr, K); findSubArrays(arr1, K1); findSubArrays(arr2, k2);
		 
	//	findSubArrays(arr3, K3);
		find();
	}
	
	public static void findSubArrays(int arr[] , int k) {
		int start =0;
		int product =1;
		int count=0;
		
		ArrayList<List<Integer>> list = new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			
			while(product<=k && start <arr.length) {
				product=product*arr[start];
				start++;
			}
			if(product>k && k>0) {
				product=product/arr[start-1];
				start--;
			}
			ArrayList<Integer> listInternal = new ArrayList<Integer>();
			for(int j=i;j<start;j++) {
				count++;
				listInternal.add(0,arr[j]);
				list.add(new ArrayList<>(listInternal));
			}
			product=product/arr[i];
		}
		
		System.out.println(list.size());
		System.out.println(count);
		
		
	}
	public static void find() {
		int arr[][] = new int[3][];
		arr[1]=new int[] {1,2,3};
		arr[2]=new int[] {4,5};
		System.out.println(arr[0][1]);
		LocalDate myDate = LocalDate.now();
		System.out.println(myDate);
		String lang ="A";
		switch(lang) {
		case "A": System.out.println("Hello");
		case "B": System.out.println("Hello");
		case "C": System.out.println("Hello");
		}
		System.out.println(1==1);
		
	}

}
