
public class GCD {

	public static void main(String[] args) {
		int a =58, b = 2;
		int div = 0;
		while(div!=1 && a%b!=0) {
			div = a%b;
			a=b;
			b=div;
		}
		int n =(int) Math.pow(10, 2);
		if(a%b==0)
			div = b;
		int arr[]= {1,2,3,4,5};
		rotateArrayAnti(arr, 2, div);

	}
	
	public static void rotateArrayAnti(int[] arr,int d ,int gcd) {
		int len = arr.length;
		for(int i=0;i<gcd;i++) {
			int temp = arr[i];
			int j = i;
			
			while(true) {
				int k = j+d;
				if(k>=len)
					k=k-len;
				if(k==i)
					break;
				arr[j]=arr[k];
				j=k;
			}
			arr[j]=temp;
		}
	}

}
