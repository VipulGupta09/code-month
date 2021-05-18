package com.geeks.array;

public class StockBuySell {

	public static void main(String[] args) {
		int prices[] = { 7,1,5,3,6,4 };
		buySellMultipleTimes(prices);
		buySellSingleTime(prices);
	}
	public static void buySellSingleTime(int arr[]) {
		int buy = Integer.MAX_VALUE;
		int profit = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<buy) {
				buy = arr[i];
			}
			else if(arr[i]>buy) {
				profit = Math.max(profit, arr[i]-buy);
			}
		}
		System.out.println(profit);
	}
	
	public static void buySellMultipleTimes(int arr[]) {
		int buy = Integer.MAX_VALUE;
		int profit = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<buy)
				buy = arr[i];
			else if(arr[i]>buy) {
				profit+=arr[i]-buy;
				buy = arr[i];
			}
		}
		System.out.println(profit);
	}
}
