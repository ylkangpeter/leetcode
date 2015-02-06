package peter;

import util.Util.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * @author ylkang Feb 5, 2015
 */
public class _141_Linked_List_Cycle {

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return false;
		}

		ListNode fast = head.next.next;
		head = head.next;
		while (fast != head) {
			head = head.next;
			if (head == null) {
				return false;
			}
			fast = fast.next;
			if (fast == null) {
				return false;
			}
			fast = fast.next;
			if (fast == null) {
				return false;
			}
		}
		return true;
	}

}
