import java.util.ArrayList;

public class PlusOne {

	public static void main(String[] args) {
		int arr[] = { 1,2,5 };
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(9);
		list.add(9);
		list.add(9);
		
		plusOne1(list);

	}

	public static int[] plusOne(int[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] < 9)
				arr[i]++;
			else {
				arr[i] = 0;
			}
		}
		int result[] = new int[arr.length + 1];
		result[0] = 1;
		return result;
	}

	public static ArrayList<Integer> plusOne1(ArrayList<Integer> arr) {
		for (int i = arr.size() - 1; i >= 0; i--) {
			int ele = arr.get(i);
			if ( ele < 9) {
				arr.remove(i);
				arr.add(i, ++ele);
				return arr;
			}
			else {
				arr.remove(i);
				arr.add(i,0);
			}
		}
		arr.add(0, 1);;
		return arr;
	}

}
