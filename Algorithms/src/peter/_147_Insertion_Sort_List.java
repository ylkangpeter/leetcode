package peter;

import util.Util.ListNode;

public class _147_Insertion_Sort_List {

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode root = new ListNode(0);
		root.next = head;
		ListNode remainNode = head.next;
		root.next.next = null;

		while (remainNode != null) {
			ListNode preInsertNode = root;
			ListNode insertNode = root.next;
			while (true) {
				if (insertNode == null) {
					preInsertNode.next = remainNode;
					remainNode = remainNode.next;
					preInsertNode.next.next = null;
					break;
				} else if (insertNode.val < remainNode.val) {
					preInsertNode = insertNode;
					insertNode = insertNode.next;
				} else {
					preInsertNode.next = remainNode;
					remainNode = remainNode.next;
					preInsertNode.next.next = insertNode;
					break;
				}
			}
		}
		return root.next;
	}

}