package binarysearch;

public class SquareRoot {

	public static void main(String[] args) {
		findSquareRoot(50, 3);

	}
	
	public static void findSquareRoot(int num , int precision) {
		int start = 0, end = num;
		double ans = 0.0;
		while(start<=end) {
			int mid = start + (end -start)/2;
			
			if(mid*mid==num) {
				ans = mid;
				break;
			}
			else if(mid*mid>num) {
				end = mid-1;
				//ans = mid;
				
			}
			else {
				start = mid +1;
				ans = mid;
			}
		}
		double increment = 0.1;
		for(int i =0;i<precision;i++) {
			while(ans*ans<=num) {
				ans+=increment;
			}
			ans = ans-increment;
			increment = increment/10;
		}
		System.out.println((float)ans);
	}
	
}
