package miscellaneous;

import java.util.Arrays;

public class MaxAreaAfterHorizontalVerticalCut {

	public static void main(String[] args) {
		int h = 5, w = 4;
		int  horizontalCuts []= {3,1}, verticalCuts []= {1};
		find(h, w, horizontalCuts, verticalCuts);
	}
	public static void find(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		long x_diff = 0;
		long y_diff = 0;
		
		int prevx = 0;
		int prevy = 0;
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);
		
		for(int i : horizontalCuts) {
			x_diff = Math.max(x_diff, i - prevx);
			prevx = i;
		}
		x_diff = Math.max(x_diff, h-prevx);
		
		for(int i : verticalCuts) {
			y_diff = Math.max(y_diff, i - prevy);
			prevy = i;
		}
		y_diff = Math.max(y_diff, w-prevy);
		
		long val = x_diff * y_diff;
		System.out.println(val);
		
	}
	

}
