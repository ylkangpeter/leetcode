package peter;

import util.Util.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 * 
 * @author ylkang Mar 4, 2015
 */
public class _092_Reverse_Linked_List_II {

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || m == n) {
			return head;
		}
		ListNode root = new ListNode(0);
		root.next = head;

		ListNode node = root.next;

		ListNode slow = root;

		int i = 1;
		while (i < m) {
			node = node.next;
			slow = slow.next;
			i++;
		}
		slow.next = null;

		ListNode tail = node;
		ListNode reverseNode = node;
		ListNode currentNode = node.next;
		node.next = null;
		reverseNode.next = null;

		while (i < n) {
			ListNode tmp = currentNode.next;
			currentNode.next = reverseNode;
			reverseNode = currentNode;
			currentNode = tmp;
			i++;
		}
		slow.next = reverseNode;
		tail.next = currentNode;
		return root.next;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next = new ListNode(6);
		System.out.println(reverseBetween(node, 2, 4));
	}
}