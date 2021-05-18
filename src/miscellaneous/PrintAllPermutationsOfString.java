package miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllPermutationsOfString {
	
	public static void main(String[] args) {
		char[] nums = {'a','c','b'};
		Arrays.sort(nums);
		System.out.println(permute(nums));
		
	}

    private static List<List<Character>> result = new ArrayList<>();
    // One permutation list
    private static List<Character> combine = new ArrayList<>();

    public static List<List<Character>> permute(char[] nums) {
        int[] used = new int[nums.length]; // Record the used flag
        permute(nums, used);
        return result;
    }

    public static void permute(char[] nums, int[] used) {
        // When combine list's size equals array's length, it is one result of all permutations
        if (combine.size() == nums.length) {
            result.add(new ArrayList<>(combine));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) { // if the used flag is 1, continue next loop
                continue;
            }
            combine.add(nums[i]); // Add one element that is not used
            used[i] = 1; // set used flag
            permute(nums, used); // recurse next unused element
            // for the backtracking remove and unset used flag
            combine.remove(combine.size() - 1); 
            used[i] = 0;
        }
    }
}
