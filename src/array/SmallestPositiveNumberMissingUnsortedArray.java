package array;

public class SmallestPositiveNumberMissingUnsortedArray {

	public static void main(String[] args) {
		int arr[] = { 2, 3, -7, 6, 8, 1, -10, 15};
		findMissing(arr);
	}
	//0 1 2  3 4  5  6  7
	//1 2 3 -7 15 6 -10 8
	public static void findMissing(int[] arr) {
		int i=0;
		while(i<arr.length) {
			if (arr[i] >= 1 && arr[i] <= arr.length) {
				if (arr[i] != arr[arr[i] - 1]) {
					int temp = arr[arr[i] - 1];
					arr[arr[i] - 1] = arr[i];
					arr[i] = temp;
				}else {
					i++;
				}
			}else {
				i++;
			}
		}
		boolean flag = false;
		for(int j=0;j<arr.length;j++) {
			if(arr[j]!=j+1) {
				System.out.println(j+1);
				flag=true;
				break;
			}
				
		}
		if(!flag) {
			System.out.println(arr.length+1);
		}
	}

}
