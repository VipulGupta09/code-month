
public class Jump {

	public static void main(String[] args) {
		int [] arr = {12,14,8,32,23,3,25,14,22,3,4,14,3,27,1,0,17,10,16,6,20,9,28,22,8,27,4,2,7,11,10,9,0,10,20,11,5,3,18,22,32,28,1,2,12,23,1,17,1,29,11,2,11,15,7,8,8,2,2,9,14,13,8,27,0,31,25,9,13,13,21,7,14,14,23,6,28,6,6,8,12,17,2,12,7,18,23,10,24,14,1,30,28,24,22,29,7,22,23};
		canReach(arr, arr.length);
	}
	static int[] dp = new int[100001];
    static int canReach(int[] A, int N) {
        int temp=0; int index =0;
        while(temp<N){
            if(dp[temp]==-1)
                break;
                 dp[temp]=-1;
               if(A[temp]==0)
            	   index++;
               else
            	   index = index+A[temp];
            temp = temp+A[temp];
           
        }
        if(index>=N)
        return 1;
        return 0;
    }

}
