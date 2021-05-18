package array;

public class MooreVotingAlgo {

	public static void main(String[] args) {
		int [] nums = {10, 10, 20, 30, 10, 10};
		System.out.println(majorityElement(nums));
	}

	 public static int majorityElement(int[] nums) {
	        int maj_index = 0,count =1;
	        for(int i=1;i<nums.length;i++){
	            if(nums[maj_index] == nums[i]){
	                count++;
	            }
	            else {
	                count--;
	            }
	            if(count == 0){
	                maj_index = i;
	                count =1;
	            }
	        }
	        count =0;
	        for(int i=0;i<nums.length;i++){
	            if(nums[maj_index] == nums[i])
	                count++;
	        }
	        if(count> nums.length/3)
	            return nums[maj_index];
	        else
	            return -1;
	    }

}
