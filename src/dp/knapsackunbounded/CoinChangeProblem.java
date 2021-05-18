package dp.knapsackunbounded;

public class CoinChangeProblem {

	public static void main(String[] args) {
		int [] wt={2, 5, 3, 6};
		int W =10;
		
		int [] wt2= {1,2,3};
		int W2 = 4;
		int count = knapsackdp(wt2, W2, wt2.length);
		
		System.out.println(count);

	}
	
	// n==i, W==j
	
	public static int knapsackdp(int wt[],int W, int n) {
		int mat[][] = new int[n+1][W+1];
		
		for(int i=0;i<W+1;i++)
			mat[0][i] = 0;
		for(int i=0;i<n+1;i++)
			mat[i][0] = 1;
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<W+1;j++) {
				
				if(wt[i-1]<=j) {
					mat[i][j] =  mat[i][j-wt[i-1]] + mat[i-1][j];
				}
				else {
					mat[i][j] = mat[i-1][j];
				}
			}
		}
		return mat[n][W];
	}

}
