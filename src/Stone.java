import java.util.Collections;
import java.util.PriorityQueue;

class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

public class Stone {

	public static void main(String[] args) {
		Node node = new Node(62);
		node.left = new Node(10);

		node.left.right = new Node(8);
		node.left.right.right = new Node(8);
		node.right = new Node(15);
		node.right.right = new Node(7);
		node.right.left = new Node(4);
		node.right.left.left = new Node(4);

		boolean data = isSumTree(node);
		System.out.println(data);

	}

	static boolean isSumTree(Node root) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		if (root.left != null && root.right == null)
			return root.data == root.left.data;
		if (root.left == null && root.right != null)
			return root.data == root.right.data;

		int sum = root.data;
		int leftSum = sum(root.left, 0);
		int rightSum = sum(root.right, 0);

		if (sum != (leftSum + rightSum))
			return false;
		isSumTree(root.left);
		isSumTree(root.right);

		return true;

	}

	public static int sum(Node root, int sum) {
		int leftSum = 0, rightSum = 0;
		if (root == null)
			return 0;
		if (root.left != null)
			leftSum = sum(root.left, sum);
		if (root.right != null)
			rightSum = sum(root.right, sum);
		sum = root.data + leftSum + rightSum;
		return sum;
	}

}
