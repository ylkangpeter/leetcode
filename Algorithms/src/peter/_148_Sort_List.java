package peter;

import util.Util.ListNode;

public class _148_Sort_List {

	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		fast = slow.next;
		slow.next = null;

		fast = sortList(fast);
		slow = sortList(head);

		return merge(fast, slow);
	}

	private ListNode merge(ListNode fast, ListNode slow) {
		if (fast == null) {
			return slow;
		}

		if (slow == null) {
			return fast;
		}

		ListNode head = fast;
		if (fast.val > slow.val) {
			head = slow;
			slow = slow.next;
		} else {
			fast = fast.next;
		}
		ListNode tmp = new ListNode(0);
		tmp.next = head;

		while (fast != null && slow != null) {
			if (fast.val < slow.val) {
				head.next = fast;
				fast = fast.next;
				head = head.next;
			} else {
				head.next = slow;
				slow = slow.next;
				head = head.next;
			}
		}
		if (fast != null) {
			head.next = fast;
		} else if (slow != null) {
			head.next = slow;
		}
		return tmp.next;
	}

}