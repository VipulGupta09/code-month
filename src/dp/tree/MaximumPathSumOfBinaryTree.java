package dp.tree;


public class MaximumPathSumOfBinaryTree {
	static int result = Integer.MIN_VALUE;
	public static void main(String[] args) {
		TreeNode node = new TreeNode(new TreeNode(), new TreeNode(), -9);
		node.left = new TreeNode(new TreeNode(), new TreeNode(), 6);
		/*
		 * node.left.left = new TreeNode(new TreeNode(), new TreeNode(), -10);
		 * node.left.right = new TreeNode(new TreeNode(),null,4);
		 */
		node.right = new TreeNode(new TreeNode(), new TreeNode(), -10);
		/*
		 * node.left.right.left = new TreeNode(new TreeNode(), null, 10);
		 * node.left.right.left.left = new TreeNode(null, null, 11); node.left.left.left
		 * = new TreeNode(null, null, 4); node.left.left.right = new
		 * TreeNode(null,null,5);
		 */
		
//				3
//			   2
//			 1   3
//			4 5   10
//			  11
		
		solve(node);
		System.out.println(result);
	}
	
	public static int solve(TreeNode root) {
		if(root == null)
			return 0;
		int left = solve(root.left);
		int right = solve(root.right);
		
		int temp = Math.max(Math.max(left, right) + root.value, root.value) ;
		int ans = Math.max(temp, left+right+root.value);
		result = Math.max(result, ans);
		return temp;
	}

}
