package com.questions.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode {
	TreeNode left;
	TreeNode right;
	TreeNode nextRight;
	int val;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(TreeNode left, TreeNode right, int val) {
		this.left = left;
		this.right = right;
		this.val = val;
	}
}

public class TreeTraversal {
	// Pre :Root Left Right : 1 2 4 5 3
	// Post :Left Right Root : 4 5 2 3 1
	// In :Left Root Right : 4 2 5 1 3

//			1
//		2		3
//	4		5

	static ArrayList<Integer> list = new ArrayList<Integer>();
	static long max = 0;
	static int half = 0;

	public static void main(String[] args) {

		// TreeNode root = new TreeNode(new TreeNode(), new TreeNode(), 5);
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(6);
		root.right.left.right = new TreeNode(7);
		root.right.left.right.left = new TreeNode(8);
		root.right.left.right.right = new TreeNode(9);
//		5 
//	1		4
//		3		6

		/*
		 * preOrderTraversal(root); System.out.println("PreOrder"); print(list); list =
		 * new ArrayList<Integer>(); postOrderTraversal(root);
		 * System.out.println("PostOrder"); print(list); list = new
		 * ArrayList<Integer>(); inOrderTraversal(root); System.out.println("InOrder");
		 * print(list);
		 * 
		 * System.out.println(depthOfBinaryTree(root));
		 */

		// maxProduct(root);
		// isValidTree(root, null, null);
		// TreeMap<Integer, int[]> map = new TreeMap<Integer, int[]>();

		// printBottomView(root, 0, 0, map);

	}

	TreeNode LCA(TreeNode root, int n1, int n2) {
		if (root == null)
			return null;
		if (n1 < root.val && n2 < root.val)
			return LCA(root.left, n1, n2);
		else if (n1 > root.val && n2 > root.val)
			return LCA(root.right, n1, n2);
		else
			return root;
	}

	public static void connectNodeAtSameLevel(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		TreeNode temp = null;
		while (!queue.isEmpty()) {

			int n = queue.size();
			for (int i = 0; i < n; i++) {
				TreeNode prev = temp;
				temp = queue.poll();

				if (i > 0)
					prev.nextRight = temp;
				System.out.println(temp.val);

				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
			temp.nextRight = null;

		}
	}

	public static void printBottomView(TreeNode root, int curr, int hd, TreeMap<Integer, int[]> m) {
		if (root == null)
			return;
		if (!m.containsKey(hd)) {
			m.put(hd, new int[] { root.val, curr });
		} else {
			int[] p = m.get(hd);
			if (p[1] <= curr) {
				p[1] = curr;
				p[0] = root.val;
			}
			m.put(hd, p);
		}
		printBottomView(root.left, curr + 1, hd - 1, m);
		printBottomView(root.right, curr + 1, hd + 1, m);
	}

	public static void printVerticalOrder(TreeNode root, int hd, TreeMap<Integer, Queue<Integer>> map) {
		if (root == null)
			return;
		Queue<Integer> list = map.get(hd);
		if (list == null) {
			list = new LinkedList<Integer>();
			list.add(root.val);
		} else {
			list.add(root.val);
		}
		map.put(hd, list);

		printVerticalOrder(root.left, hd - 1, map);
		printVerticalOrder(root.right, hd + 1, map);

	}

	public static int maxProduct(TreeNode root) {
		findTotalSum(root); // 21
		half = root.val / 2; // 10
		compute(root, root.val);
		return (int) (max % (1e9 + 7));
	}

	public static int findTotalSum(TreeNode root) {
		if (root == null)
			return 0;
		root.val += findTotalSum(root.left) + findTotalSum(root.right);
		return root.val;
	}

	public static void compute(TreeNode node, long sum) { // 21
		if (node == null)
			return;
		max = Math.max(max, (node.val * (sum - node.val)));
		if (node.val >= half) {
			compute(node.left, sum);
			compute(node.right, sum);
		}
	}

	public static void print(ArrayList<Integer> list) {
		for (int i : list)
			System.out.print(i + " ");
		System.out.println();

	}

	public static ArrayList<Integer> preOrderTraversal(TreeNode root) {
		if (root == null)
			return list;
		list.add(root.val);
		if (root.left != null)
			preOrderTraversal(root.left);
		if (root.right != null)
			preOrderTraversal(root.right);
		return list;
	}

	// Left Right Root
	public static ArrayList<Integer> postOrderTraversal(TreeNode root) {
		if (root == null)
			return list;
		if (root.left != null)
			postOrderTraversal(root.left);
		if (root.right != null)
			postOrderTraversal(root.right);
		list.add(root.val);

		return list;

	}

	// Left Root Right
	public static ArrayList<Integer> inOrderTraversal(TreeNode root) {
		if (root == null)
			return list;
		if (root.left != null)
			inOrderTraversal(root.left);
		list.add(root.val);
		if (root.right != null)
			inOrderTraversal(root.right);
		return list;
	}

//		1
//	   / \
//	  2   2
//	 / \ / \
//	3  4 4  3
	// Mirror image
	public static boolean isSymmetric(TreeNode lt, TreeNode rt) {
		if (lt == null || rt == null)
			return lt == rt;
		if (lt.val != rt.val)
			return false;
		return isSymmetric(lt.left, rt.right) && isSymmetric(lt.right, rt.left);
	}

	// Two Trees are same or not
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null)
			return p == q;
		if (p.val != q.val)
			return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public static int depthOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		int left = depthOfBinaryTree(root.left);
		int right = depthOfBinaryTree(root.right);

		return 1 + Math.max(left, right);
	}

//		3
//	   / \
//	  9  20
//	    /  \
//	   15   7
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<Integer>();

			for (int i = 0; i < size; i++) {
				TreeNode tempNode = queue.poll();
				level.add(tempNode.val);
				if (tempNode.left != null)
					queue.offer(tempNode.left);
				if (tempNode.right != null)
					queue.offer(tempNode.right);
			}
			result.add(level);
		}
		return result;
	}

	public static ArrayList<Integer> leftViewOfTree(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		if (root == null)
			return list;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (i == 0)
					list.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}
		return list;
	}

	public static boolean isValidTree(TreeNode root, Integer min, Integer max) {
		if (root == null)
			return true;
		if ((min != null && root.val <= min) || (max != null && root.val >= max))
			return false;
		return isValidTree(root.left, min, root.val) && isValidTree(root.right, root.val, max);
	}

	// construct BST from sorted array [-10,-3,0,5,9], o/p: [0,-10,5,null,-3,null,9]
	public TreeNode constructTree(int[] nums, int start, int end) {
		if (start > end)
			return null;
		int mid = start + (end - start) / 2;

		TreeNode root = new TreeNode(nums[mid]);
		root.left = constructTree(nums, start, mid - 1);
		root.right = constructTree(nums, mid + 1, end);
		return root;
	} // 0,1, 2, 3,4 // size = 6
//			inorder =   [9,3,15,20,7] Left Root Right
// 			postorder = [9,15,7,20,3] Left Right Root
//		3
//	   / \
//	  9  20
//	    /  \
//	   15   7

	public static TreeNode constructBinaryTree(int[] inOrder, int[] postOrder, int inStart, int inEnd, int postStart,
			int postEnd) {
		if (inStart > inEnd)
			return null;
		int rootVal = postOrder[postEnd];
		TreeNode root = new TreeNode(rootVal);

		int rootIndex = 0;
		for (rootIndex = 0; rootIndex <= inEnd; rootIndex++) {
			if (inOrder[rootIndex] == root.val) {
				break;
			}
		}
		int leftTreeSize = rootIndex - inStart;
		int rightTreeSize = inEnd - rootIndex;

		root.left = constructBinaryTree(inOrder, postOrder, inStart, rootIndex - 1, postStart,
				postStart + leftTreeSize - 1);
		root.right = constructBinaryTree(inOrder, postOrder, rootIndex + 1, inEnd, postEnd - rightTreeSize,
				postEnd - 1);
		return root;
	}

	class Solution {
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			Map<Integer, Integer> map = new HashMap<>();

			for (int i = 0; i < inorder.length; i++) {
				map.put(inorder[i], i);
			}

			return buildTree(0, 0, inorder.length - 1, preorder, inorder, map);
		}

		public TreeNode buildTree(int index, int left, int right, int[] preorder, int[] inorder,
				Map<Integer, Integer> map) {
			if (index >= preorder.length) {
				return null;
			}

			if (left > right) {
				return null;
			}

			if (left == right) {
				return new TreeNode(preorder[index]);
			}

			TreeNode node = new TreeNode(preorder[index]);

			node.left = buildTree(index + 1, left, map.get(preorder[index]) - 1, preorder, inorder, map);

			int leftLength = map.get(preorder[index]) - left;

			node.right = buildTree(index + leftLength + 1, map.get(preorder[index]) + 1, right, preorder, inorder, map);

			return node;
		}
	}
}
