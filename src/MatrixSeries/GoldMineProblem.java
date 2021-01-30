package MatrixSeries;

public class GoldMineProblem {

	public static void main(String[] args) {
		int mat[][] = { {1, 3, 1, 5},
                		{2, 2, 4, 1},
                		{5, 0, 2, 3},
                		{0, 6, 1, 2}};
		
		int mat1[][] ={ {13, 12,6, 5},
						{14, 11, 9, 1},
						{16, 9, 5, 3},
						{11, 11, 4, 2}};
//		  n
	//w	     e
		//s
		findSolution1(mat,mat.length,mat[0].length);

	}
	public static void findSolution1(int arr[][],int row,int col) {
		int maxGold[][] = new int[row][col];
		
		for(int j=col-1;j>=0;j--) {
			for(int i=0;i<row;i++) {
				
				int right = (j==col-1)?0:maxGold[i][j+1];
				
				int down = (i==row-1)?0:maxGold[i+1][j];
				
				int rightDown = (i==row-1 || j==col-1)?0:maxGold[i+1][j+1];
				
				maxGold[i][j] = arr[i][j]+ Math.max(right, Math.max(down, rightDown));
			}
		}
		int res = maxGold[0][0]; 
        
        for (int i = 1; i < row; i++) 
            res = Math.max(res, maxGold[i][0]); 
              
        System.out.println(res); 
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(maxGold[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void findSolution(int arr[][],int row,int col) {
		int maxGold[][] = new int[row][col];
		
		for(int j=col-1;j>=0;j--) {
			for(int i=0;i<row;i++) {
				
				int right = (j==col-1)?0:maxGold[i][j+1];
				
				int rightUp = (i==0||j==col-1)?0:maxGold[i-1][j+1];
				
				int rightDown = (i==row-1 || j==col-1)?0:maxGold[i+1][j+1];
				
				maxGold[i][j] = arr[i][j]+ Math.max(right, Math.max(rightUp, rightDown));
			}
		}
		int res = maxGold[0][0]; 
        
        for (int i = 1; i < row; i++) 
            res = Math.max(res, maxGold[i][0]); 
              
        System.out.println(res); 
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(maxGold[i][j]+" ");
			}
			System.out.println();
		}
	}

}
