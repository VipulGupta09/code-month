import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int a[] = { 1, 0, 0, 1, 0, 1, 0, 1, 1, 1,
                1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0 };
		sort(a);
		System.out.println(Arrays.toString(a));

	}
	public static void sort(int arr[]) {
		int start = 0,  end = arr.length-1;
		while(start<=end) {
			if(arr[start]==0) {
				start++;
			}
			else if(arr[end]!=0) {
				end--;
			}
			else {
				int temp = arr[start];
				arr[start]= arr[end];
				arr[end]=temp;
				start++;
				end--;
			}
		}
	}
	
}
