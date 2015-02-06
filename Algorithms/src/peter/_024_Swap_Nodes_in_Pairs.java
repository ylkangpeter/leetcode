package peter;

import util.Util.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _024_Swap_Nodes_in_Pairs {

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode root = new ListNode(0);
		root.next = head;
		ListNode mo = root;

		while (mo != null) {
			ListNode moveNode = mo.next;
			if (moveNode == null) {
				return root.next;
			}
			if (mo.next.next == null) {
				return root.next;
			}
			mo.next = mo.next.next;
			ListNode tmp = mo.next.next;
			mo.next.next = moveNode;
			moveNode.next = tmp;

			mo = mo.next.next;
		}
		return root.next;
	}

}