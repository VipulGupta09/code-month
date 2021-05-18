package dp.knapsackunbounded;

public class CoinChangeProblemMinimumCoins {

	public static void main(String[] args) {
		int coins[] = {25, 10, 5}, V = 30;
		int coins2[] = {9,6,5,1} , V2 = 11;
		
		int count = knapsackdp(coins2, V2, coins2.length);
		System.out.println(count);
	}
	public static int knapsackdp(int wt[],int W, int n) {
		int mat[][] = new int[n+1][W+1];
		
		for(int i=0;i<W+1;i++)
			mat[0][i] = Integer.MAX_VALUE-1;
		for(int i=0;i<n+1;i++)
			mat[i][0] = 0;
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<W+1;j++) {
				
				if(wt[i-1]<=j) {
					mat[i][j] =  Math.min(1 + mat[i][j-wt[i-1]], mat[i-1][j]);
				}
				else {
					mat[i][j] = mat[i-1][j];
				}
			}
		}
		return mat[n][W];
	}
}
