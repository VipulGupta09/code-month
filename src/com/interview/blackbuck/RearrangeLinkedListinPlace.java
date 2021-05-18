package com.interview.blackbuck;

class LinkedList {
	int val;
	LinkedList next;

	public LinkedList() {

	}

	public LinkedList(int val) {
		this.val = val;
	}
}

public class RearrangeLinkedListinPlace {

	public static void main(String[] args) {
		LinkedList root = new LinkedList(1);
		root.next = new LinkedList(2);
		root.next.next = new LinkedList(3);
		root.next.next.next = new LinkedList(4);
		root.next.next.next.next = new LinkedList(5);
		root.next.next.next.next.next = new LinkedList(6);

		rearrangeLinkedList(root);

	}

	// 1->2->3->4->5->6
	// 1->2->3->4->5
	public static void rearrangeLinkedList(LinkedList head) {

		LinkedList slow = head;
		LinkedList fast = slow.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		LinkedList node1 = head;
		LinkedList node2 = slow.next;
		slow.next = null;

		node2 = reverse(node2);

		head = new LinkedList(0);
		
		LinkedList curr = head;
		while (node1 != null || node2 != null) {
			if (node2 != null) {
				curr.next = node2;
				curr = curr.next;
				node2 = node2.next;
			}
			if (node1 != null) {
				curr.next = node1;
				curr = curr.next;
				node1 = node1.next;
			}
		}
		head = head.next;
	}

	public static LinkedList reverse(LinkedList node2) {

		LinkedList prev = null;
		LinkedList curr = node2;

		while (curr != null) {
			LinkedList temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		node2 = prev;
		return node2;

	}

}
