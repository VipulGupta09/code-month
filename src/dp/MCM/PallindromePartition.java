package dp.MCM;

public class PallindromePartition {
	static int mat[][] = new int[502][502]; // size of string +1

	public static void main(String[] args) {
		String str = "abab";// 3 a|babbbab|b|ababa.
		int count = solve(str, 0, str.length() - 1);
		System.out.println(count);

		// for memotization
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				mat[i][j] = -1;
			}
		}
		int count1 = solveMemoize(str, 0, str.length() - 1);
		System.out.println(count1);
		
		int count2 = solveMemoizeFurthurOptimize(str, 0, str.length()-1);
		System.out.println(count2);
		
		int count3 = solve1(str, 0, str.length()-1);
		System.out.println(count3);
	}

	public static int solve(String str, int i, int j) {

		if (i >= j)
			return 0;
		if (isPallindrome(str, i, j))
			return 0;
		int mm = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int temp = solve(str, i, k) + solve(str, k + 1, j) + 1;
			if (temp < mm)
				mm = temp;
		}
		return mm;
	}

	public static boolean isPallindrome(String str, int i , int j){
        while(i<=j){
            if(!(str.charAt(i)==str.charAt(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }

	public static int solveMemoize(String str, int i, int j) {
		if (i >= j)
			return 0;
		if (isPallindrome(str, i, j))
			return 0;
		int mm = Integer.MAX_VALUE;
		if (mat[i][j] != -1)
			return mat[i][j];

		for (int k = i; k <= j - 1; k++) {
			int temp = solveMemoize(str, i, k) + solve(str, k + 1, j) + 1;
			if (temp < mm)
				mm = temp;
		}
		mat[i][j] = mm;
		return mm;
	}

	// further possibility that mat[i][k] might be present in matrix so before calling check both of them
	public static int solveMemoizeFurthurOptimize(String str, int i, int j) {
		if (i >= j)
			return 0;
		if (isPallindrome(str, i, j))
			return 0;
		int mm = Integer.MAX_VALUE;
		if (mat[i][j] != -1)
			return mat[i][j];

		for (int k = i; k <= j - 1; k++) {
			// int temp = solveMemoize(str, i, k)+solve(str, k+1, j) +1;
			int left = 0, right = 0;
			if (mat[i][k] != -1) {
				left = mat[i][k];
			} else {
				left = solve(str, i, k);
				mat[i][k] =  left;
			}
			if (mat[k+1][j] != -1) {
				right = mat[k + 1][j];
			} else {
				right = solve(str, k + 1, j);
				mat[k+1][j] = right;
			}
			int temp = left + right +1;
			if (temp < mm)
				mm = temp;
		}
		mat[i][j] = mm;
		return mm;
	}
	 public static int solve1(String str, int i, int j){
	        if(i>=j)
	            return 0;
	        if(isPallindrome(str,i,j))
	            return 0;
	        if(mat[i][j]!=-1)
	            return mat[i][j];
	        int mm = Integer.MAX_VALUE;
	        
	        for(int k=i;k<=j-1;k++){
	            int left = 0, right = 0;
	            if(mat[i][k]!=-1)
	                return mat[i][k];
	            else{
	                left = solve(str,i,k);
	                mat[i][k]=left;
	            }
	             if(mat[k+1][j]!=-1)
	                return mat[k+1][j];
	            else{
	                right = solve(str,k+1,j);
	                mat[k+1][j]=right;
	            }
	            int temp = left + right +1;
	            
	            if(temp<mm)
	                mm = temp;
	        }
	        mat[i][j]=mm;
	        return mm;
	    }

}
