package array;

public class FindDuplicates {

	public static void main(String[] args) {
		int n = 7 ,
		array[] = {1, 2, 3, 4 ,3};
		
		find(array);
	}
	
	public static void find(int arr[]) {
		int i = 0;
		while(i<arr.length-1) {
			if(arr[i]!= arr[arr[i]-1]) {
				int temp = arr[arr[i]-1];
				arr[arr[i]-1] = arr[i];
				arr[i] = temp;
			}
			else{
				i++;
			}	
		}
		for(int j=0;j<arr.length;j++) {
			if(arr[j]!=j+1)
				System.out.print(arr[j] +" ");
		}
	}

}
