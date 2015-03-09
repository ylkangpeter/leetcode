package peter;

import util.Util.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 * @author ylkang Mar 4, 2015
 */
public class _086_Partition_List {

	public static ListNode partition(ListNode head, int x) {

		if (head == null) {
			return null;
		}

		ListNode smallRoot = new ListNode(0);
		ListNode smallRootCur = smallRoot;
		ListNode bigRoot = null;
		ListNode bigRootCur = null;

		while (head != null) {
			if (head.val < x) {
				smallRootCur.next = head;
				smallRootCur = smallRootCur.next;
				head = head.next;
			} else {
				if (bigRoot == null) {
					bigRoot = head;
					bigRootCur = head;
				} else {
					bigRootCur.next = head;
					bigRootCur = bigRootCur.next;
				}
				head = head.next;
			}
		}
		smallRootCur.next = bigRoot;
		if (bigRootCur != null) {
			bigRootCur.next = null;
		}
		return smallRoot.next;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(4);
		node.next.next = new ListNode(3);
		// node.next.next.next = new ListNode(2);
		// node.next.next.next.next = new ListNode(5);
		// node.next.next.next.next.next = new ListNode(2);

		System.out.println(partition(node, 4));
	}
}