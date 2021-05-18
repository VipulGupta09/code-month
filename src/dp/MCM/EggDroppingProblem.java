package dp.MCM;

public class EggDroppingProblem {
	static int mat[][] ;
	public static void main(String[] args) {
		int floor = 4, egg = 2;
		
		mat = new int[floor+1][egg+1];
		
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++)
				mat[i][j]=-1;
		}
		
		int count = solve(floor, egg);
		System.out.println(count);

	}
	
	public static int solve(int floor, int egg) {
		if(floor == 0 || floor == 1)
			return floor;
		if(egg == 1)
			return floor;
		
		if(mat[floor][egg]!=-1)
			return mat[floor][egg];
		
		int ans = Integer.MAX_VALUE;
		for(int k=1;k<=floor;k++) {
			int temp = 1+ Math.max(solve(k-1, egg - 1), solve(floor-k, egg));
			
			if(temp<ans)
				ans = temp;
		}
		mat[floor][egg]=ans;
		return ans;
	}

}
