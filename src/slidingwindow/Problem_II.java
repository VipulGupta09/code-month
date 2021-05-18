package slidingwindow;
//Given an array and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.
//https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k/0#
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem_II {
	public static void main(String[] args) throws NumberFormatException, IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int testcase = Integer.parseInt(br.readLine());
		 while(testcase-->0){
		     int size = Integer.parseInt(br.readLine());
		     int arr[] = new int[size];
		    String[] strs = br.readLine().trim().split("\\s+");
	            for (int i = 0; i < size; i++) {
	                 arr[i] = Integer.parseInt(strs[i]);
	              }
		     int windowSize = Integer.parseInt(br.readLine());
		     calculate(size,arr,windowSize);
		 }
	}

	public static void calculate(int n, int[] arr, int k) {
		int i = 0;
		int j = 0;
		ArrayList<Integer> list = new ArrayList<>();
		while (j < n) {
			if (arr[j] < 0)
				list.add(arr[j]);
			if (j - i + 1 < k)
				j++;
			else if (j - i + 1 == k) {
				if(list.size() == 0)
					System.out.print("0 ");
				else {
					System.out.print(list.get(0)+" ");
					if(arr[i] == list.get(0)) {
						list.remove(0);
					}
				}
				i++;
				j++;
			}
		}
		System.out.println();
	}
}
