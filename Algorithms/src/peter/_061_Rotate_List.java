package peter;

import util.Util.ListNode;

/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 * 
 * @author ylkang Feb 25, 2015
 */
public class _061_Rotate_List {

	/**
	 * 'Rotate by 1' means to move the last element to the very beginning.
	 * 'Rotate by n' means to repeat 'Rotate by 1' n times. So for {1,2},
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode rotateRight(ListNode head, int n) {
		int len = 0;

		if (head == null || n == 0) {
			return head;
		}

		ListNode fast = head;
		ListNode slow = head;

		while (fast != null) {
			len++;
			fast = fast.next;
		}

		n = n % len;

		if (n == 0) {
			return head;
		}

		fast = head;
		int i = 0;
		while (i++ < n && fast != null && fast.next != null) {
			fast = fast.next;
		}

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		fast.next = head;
		head = slow.next;
		slow.next = null;

		return head;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		// node.next.next = new ListNode(3);
		// node.next.next.next = new ListNode(4);
		// node.next.next.next.next = new ListNode(5);
		System.out.println(rotateRight(node, 2));

	}
}