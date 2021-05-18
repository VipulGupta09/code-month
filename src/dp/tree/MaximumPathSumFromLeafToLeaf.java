package dp.tree;

public class MaximumPathSumFromLeafToLeaf {

	static int result = Integer.MIN_VALUE;
	public static void main(String[] args) {
		TreeNode node = new TreeNode(new TreeNode(), new TreeNode(), -9);
		node.left = new TreeNode(new TreeNode(), new TreeNode(), 6);
		/*
		 * node.left.left = new TreeNode(new TreeNode(), new TreeNode(), -10);
		 * node.left.right = new TreeNode(new TreeNode(),null,4);
		 */
		node.right = new TreeNode(new TreeNode(), new TreeNode(), -10);
		solve(node);
		System.out.println(result);
	}
	
	public static int solve(TreeNode root) {
		if(root == null)
			return 0;
		int left = solve(root.left);
		int right = solve(root.right);
		
		int temp = Math.max(left, right) + root.value;
		if(root.left==null && root.right==null)
			temp = Math.max(temp, left+right+root.value);
		int ans = Math.max(temp, left + right +root.value);
		
		result = Math.max(ans, result);
		return ans;
	}

}
