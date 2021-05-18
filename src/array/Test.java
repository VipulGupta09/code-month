package array;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {

	public static void main(String[] args) {
		int arr[] = { 14, 3, 6, 8, 11, 16 };
		// countTriplet(arr, arr.length);
		int arr1[] = { 74, -72, 94, -53, -59, -3, -66, 36, -13, 22, 73, 15, -52, 75 };
		// maxSubarraySum(arr1, arr1.length);
		// minimumDistances(new int[]{7, 1, 3, 4, 1, 7});
		// getClosese(new int[] {4 ,14,16,10});
		//rearrange(new int[] { 1, 2, 3, 4, 5, 6 });
		//chocolateFeast(15, 3, 2);
		//pickingNumbers(new ArrayList<Integer>(Arrays.asList(4 ,6 ,5 ,3 ,3 ,1)));
		//strangeCounter(17);
		//reverseInteger(-102);
		//reverse(102);
		int arr2[]={-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
		inPlaceSort(arr2);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	//101,10
	//10,100
	//123,12,1
	//3,2,1
	static void reverseInteger(int num) {
		int rev_num=0;
		boolean flag = true;
		if(num<0) {
			num=num*(-1);
			flag = false;
		}
		while(num>0) {
			rev_num =rev_num*10 + num%10;
			num = num/10;
		}
		if(flag) {
			System.out.println(num);
		}else {
			System.out.println(num*-1);
		}
	}
	
	static void reverse(int num) {
		int rev_num = 0; 
        while(num > 0) 
        { 
            rev_num = rev_num * 10 + num % 10; 
            num = num / 10; 
        } 
        System.out.println(rev_num);
	}
	
	 static long strangeCounter(long t) {
	        long timer = 3;
	        long initial = 3;
	        long time = 1;
	        while(true){
	            if(time == t)
	                return timer;
	            if(timer == 1){
	            	System.out.print(time);
		            System.out.print(" ");
		            System.out.println(timer);
		           
	                timer = 2*initial;
	                initial = timer;
	                time++;
	                continue;
	            }
	            System.out.print(time++);
	            System.out.print(" ");
	            System.out.println(timer--);
	           
	        }

	    }
	
	public static int pickingNumbers(List<Integer> a) {
        Collections.sort(a);
        int maxCurrLen = 0;
        int maxLen = Integer.MIN_VALUE;
        int minEle = a.get(0);
        //1,1,2,2,4,4,5,5,5
        for(int i=1;i<a.size();i++){
            if(a.get(i)-a.get(i-1)<2 &&a.get(i)-minEle<2){
                maxCurrLen++;
            }else{
                maxCurrLen = 0;
                minEle = a.get(i);
            }
            if(maxCurrLen>maxLen){
                maxLen = maxCurrLen;
            }
        }
    return maxLen==Integer.MIN_VALUE?0:maxLen+1;
    }
	
	static int chocolateFeast(int n, int c, int m) {
        //15 , 3 , 2
        // 5+2+1+1
        // 5,(1+2),(1+1),()
        
        int total = n/c;
        int wrapper = total ;
        int wrapperLeft =0;
        while(wrapper>=m){
        	wrapperLeft = wrapper%m;
            total+=wrapper/m;
            wrapperLeft+=wrapper/m;
            wrapper=wrapperLeft;
            
        }
        return total;

    }


	static int maxSubarraySum(int arr[], int n) {
		int maxTillNow = 0;
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			maxTillNow += arr[i];
			if (maxTillNow > maxSum) {
				maxSum = maxTillNow;
			}
		}
		return maxSum;

	}

	static int countTriplet(int arr[], int n) {
		// 1,2,3,5
		// 3,6,8,11,14,16
		Arrays.sort(arr);
		int count = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			int j = 0;
			int k = i - 1;
			int sum = 0;
			while (j < k) {
				sum = arr[j] + arr[k];
				if (sum < arr[i])
					j++;
				else if (sum > arr[i])
					k--;
				if (sum == arr[i]) {
					count++;
					k--;
				}

			}

		}
		return count;
	}

	// 7, 1, 3, 4, 1, 7
	static int minimumDistances(int[] a) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int dis = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				if (i - map.get(a[i]) < dis)
					dis = i - map.get(a[i]);
				map.put(a[i], (i - map.get(a[i])));
			} else {
				map.put(a[i], i);
			}
		}

		return dis;

	}

	public static int getClosese(int[] arr) {
		int element = 0;
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 9) {
				int temp = arr[i] - 9;
				if (temp < diff) {
					element = arr[i];
					diff = temp;
				}
			}
		}
		return diff == Integer.MAX_VALUE ? -1 : element;
	}

	// 1,2,3,4,5,6
	// 1+(6*7),2+(1*7),3+(5*7),4+(2*7),5+(4*7),6+(3*7)
	// 6,1,5,2,4,3
	public static void rearrange(int[] arr) {
		int min_index = 0;
		int max_index = arr.length - 1;
		int max_ele = arr[max_index] + 1;

		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				arr[i] += (arr[max_index] % max_ele) * max_ele;
				max_index--;
			} else {
				arr[i] += (arr[min_index] % max_ele) * max_ele;
				min_index++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] / max_ele;
		}
	}
	
	public static void inPlaceSort(int arr[]) {
		//int arr1[]={-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=i && arr[i]!=-1) {
				int temp = arr[arr[i]];
				arr[arr[i]]=arr[i];
				arr[i]=temp;
				i--;
			}
		}
		
		System.out.print(Arrays.toString(arr));
	}
}
