package dp.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BurnTree {
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static Queue<TreeNode> queue = new LinkedList<TreeNode>();
	public static void main(String[] args) {
		
		
		TreeNode node = new TreeNode(null, null, 1);
		node.left = new TreeNode(null, null, 2);
		node.right = new TreeNode(null, null, 3);
		node.right.left = new TreeNode(null, null, 4);
		node.right.right = new TreeNode(null,null,5);
		node.right.left.left = new TreeNode(null, null, 6);
		node.right.left.right = new TreeNode(null, null, 7);
		node.right.right.right = new TreeNode(null,null,8);
		node.right.right.right.right = new TreeNode(null,null,9);
		
		burnTree(node, 4);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			list.add(temp.value);
		}
		
		for(int i:list)
			System.out.print(i+" ");

	}
	
	public static int burnTree(TreeNode root, int target) {
		if(root==null)
			return 0;
		if(root.value == target) {
			list.add(root.value);
			if(root.left!=null)
				queue.add(root.left);
			if(root.right!=null)
				queue.add(root.right);
			return 1;
		}
		int a = burnTree(root.left, target);
		if(a==1) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				TreeNode temp = queue.poll();
				list.add(temp.value);
				
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
			}
			if(root.right!=null) {
				queue.add(root.right);
				list.add(root.value);
				return 1;
			}
		}
		int b = burnTree(root.right, target);
		if(b==1) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				TreeNode temp = queue.poll();
				list.add(temp.value);
				
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
			}
			if(root.left!=null) {
				queue.add(root.left);
				list.add(root.value);
				return 1;
			}
		}
		return 0;
	}
	

}
