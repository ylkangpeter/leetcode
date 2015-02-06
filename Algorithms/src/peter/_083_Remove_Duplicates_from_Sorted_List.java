package peter;

import util.Util.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _083_Remove_Duplicates_from_Sorted_List {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode n = head;
		while (n != null) {
			if (n.next == null) {
				return head;
			}
			if (n.val == n.next.val) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
		return head;
	}

}