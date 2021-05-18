
package dp.tree;

class TreeNode{
	TreeNode left;
	TreeNode right;
	int value;
	public TreeNode() {
		
	}
	public TreeNode(TreeNode left, TreeNode right, int value) {
		this.left = left;
		this.right = right;
		this.value = value;
	}
}

public class DiameterOfBinaryTree {
	static int result = Integer.MIN_VALUE;
	public static void main(String[] args) {
		TreeNode node = new TreeNode(new TreeNode(), new TreeNode(), 3);
		node.left = new TreeNode(new TreeNode(), new TreeNode(), 2);
		node.left.left = new TreeNode(new TreeNode(), new TreeNode(), 1);
		node.left.right = new TreeNode(new TreeNode(),null,3);
		node.left.right.left = new TreeNode(new TreeNode(), null, 10);
		node.left.right.left.left = new TreeNode(null, null, 11);
		node.left.left.left = new TreeNode(null, null, 4);
		node.left.left.right = new TreeNode(null,null,5);
		
		/*
		 * node.right = new TreeNode(new TreeNode(), new TreeNode(), 10);
		 * node.right.left = new TreeNode(null,null,1); node.right.right = new
		 * TreeNode(new TreeNode(), null, 3);
		 */		int count = diameter(node);
		//System.out.println(count);
		
		System.out.println(heightOfTree(node));
		
//		3
//	2		 10
// 1	  3		1 3
//4 4

	}
	
	public static int heightOfTree(TreeNode root) {
		if(root==null)
			return 0;
		TreeNode left = root.left;
		TreeNode right = root.right;
		return 1+Math.max(height(left), height(right));
	}
	
	public static int height(TreeNode root) {
		if(root == null)
			return 0;
		int left = height(root.left);
		int right = height(root.right);
		return 1+Math.max(left, right);
		
	}
	public static int diameter(TreeNode root) {
		solve(root);
		return result;
	}
	public static int solve(TreeNode root) {
		
		if(root == null)
			return 0;
		int left = solve(root.left);
		int right = solve(root.right);
		
		int temp = Math.max(left, right) +1;
		int ans = Math.max(temp	, left+right+1);
		result = Math.max(result, ans);
		
		return temp;
		/*
		 * maxDiameter = Math.max(maxDiameter, left+right+1); // if this is candidate
		 * for largest return Math.max(left, right)+1; // if this is not candidate for
		 * largest
		 */	}
}
