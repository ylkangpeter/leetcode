package peter;

import util.Util.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _021_Merge_Two_Sorted_Lists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode h = new ListNode(0);
		ListNode tmp = h;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				tmp.next = l1;
				l1 = l1.next;
			} else {
				tmp.next = l2;
				l2 = l2.next;
			}
			tmp = tmp.next;
		}

		if (l1 != null) {
			tmp.next = l1;
		}

		if (l2 != null) {
			tmp.next = l2;
		}
		return h.next;

	}

}