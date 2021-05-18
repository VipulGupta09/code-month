package com.geeks.array;

public class FactorialOfLargeNumber {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	// 5 4 3 2 1

	public static void main(String[] args) {
		int num = 5;
		Node node = new Node(1);
		for (int i = 2; i <= num; i++)
			calFact(i, node);
			printList(node);
	}
	public static void printList(Node node) {
		if(node==null)
			return ;
		 printList(node.next);
		System.out.print(node.data+"");
	}

	public static void calFact(int num, Node tail) {
		Node temp = tail, prevNode = tail;
		int carry = 0;
		while (temp != null) {
			int data = temp.data * num + carry;
			temp.data = data % 10;
			carry = data / 10;
			prevNode = temp;
			temp = temp.next;
		}
		while (carry != 0) {
			prevNode.next = new Node((int) carry % 10);
			carry /= 10;
			prevNode = prevNode.next;
		}
	}
}
