package array;

import java.util.ArrayList;

public class PatternPrint {

	public static void main(String[] args) {
		int n = 4;
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		int col=0;
		for(int i=n;i>0;i--) {
			int val = 1;
			ArrayList<Integer>  temp = new ArrayList<Integer>();
			for(int j = i-1;j<n;j++) {
			 temp.add(val);
				System.out.print(val+" ");
				val++;
			}
			list.add(temp);
			System.out.println();
		}
		System.out.println(list);
		
	}
	


}
