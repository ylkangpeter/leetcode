package peter;

import util.Util.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note: Given n will always be valid. Try to do this in one pass.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _019_Remove_Nth_Node_From_End_of_List {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		int cursor = 0;
		ListNode rootNode = new ListNode(0);
		rootNode.next = head;
		ListNode node1 = rootNode;
		ListNode node2 = rootNode;

		while (node1 != null && cursor <= n) {
			cursor++;
			node1 = node1.next;
		}

		while (node1 != null) {
			node1 = node1.next;
			node2 = node2.next;
		}
		node2.next = node2.next.next;
		return rootNode.next;
	}

}