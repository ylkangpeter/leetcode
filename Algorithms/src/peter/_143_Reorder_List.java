package peter;

import util.Util.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 * L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _143_Reorder_List {

	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		fast = slow.next;
		slow.next = null;

		ListNode reverse = reverse(fast);
		head = merge(head, reverse);
	}

	private ListNode reverse(ListNode node) {
		ListNode pre = null;
		while (node != null) {
			ListNode tmp = node;
			node = node.next;
			tmp.next = pre;
			pre = tmp;
		}
		return pre;
	}

	private ListNode merge(ListNode n1, ListNode n2) {
		ListNode tmp = new ListNode(0);
		ListNode head = n1;
		tmp.next = head;
		while (n2 != null) {
			tmp.next = n1;
			n1 = n1.next;
			tmp.next.next = n2;
			n2 = n2.next;
			tmp = tmp.next.next;

		}
		if (n1 != null) {
			tmp.next = n1;
		}
		return head;
	}

}