
public class Test1 {

	public static void main(String[] args) {
		int number = 16;
		int val = squareRoot(number);
		System.out.println(val);
		
		String s1 = "";
		String s2 = "";
		
	}
	
	public static int squareRoot(int num) {
		int start=0,end = num/2;int mid=0;
		int ans = 0;
		
	
		
		while(start<=end) {
			 mid = start + (end-start)/2;
			int root = mid*mid;
			
			if(root==num) {
				//System.out.println(mid);
				return mid;
			}
			else if(root<num) {
				start = mid+1;
				ans = mid;
			}
			else 
				end = mid-1;
		}
		return ans;
		
	}

}
