package miscellaneous;

public class SalaryHikes {
	public static void main(String[] args) {
		int rating[] = {5, 3, 4, 2, 1, 6};
		int len = rating.length;
		findMinHike(rating, len);
		// [1,1,1,1,1,1]
		// [1,1,2,1,1,2]
		// [2,1,3,2,1,2]
	}
	public static void findMinHike(int rating[],int len) {
		int [] hikes = new int[len];
		
		for(int i=0;i<len;i++)
			hikes[i]=1;
		
		for(int i=1;i<len;i++) {
			if(rating[i-1]<rating[i] && hikes[i-1]>=hikes[i])
				hikes[i] = hikes[i-1]+1;
		}
		for(int i=len-1;i>0;i--) {
			if(rating[i-1]>rating[i] && hikes[i-1]<=hikes[i])
				hikes[i-1] = hikes[i]+1;
		}
		
		for(int i=0;i<len;i++)
			System.out.print(hikes[i] + " ");
	}
	
}
