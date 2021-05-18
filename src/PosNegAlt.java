
public class PosNegAlt {

	public static void main(String[] args) {
		int N = 10;
		int Arr[] = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
		rearrange(Arr, N);
	}

	static void rearrange(int arr[], int n) {

		int result[] = new int[arr.length];
		int even = 0;
		int odd = 1;
		int posCount = 0;
		int negCount = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0)
				negCount++;
			else
				posCount++;
		}
		int i = 0;
		while (posCount > 0 && negCount > 0) {
			if (arr[i] >= 0 && even < arr.length) {
				result[even] = arr[i];
				even = even + 2;
				posCount--;
			} else if (odd < arr.length) {
				result[odd] = arr[i];
				odd = odd + 2;
				negCount--;
			}
			i++;
		}
		while (i < arr.length) {
			result[even] = arr[i];
			i++;
			even++;
		}

		while (i < arr.length) {
			result[odd] = arr[i];
			i++;
			odd++;
		}

		for (i = 0; i < arr.length; i++)
			arr[i] = result[i];
	}

}
