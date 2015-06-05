package peter;

import util.Util.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * @author ylkang Feb 10, 2015
 */
public class _142_Linked_List_Cycle_II {

	public static ListNode detectCycle(ListNode head) {

		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}

		ListNode root = new ListNode(0);
		root.next = head;
		ListNode fast = head.next.next;
		head = head.next;
		while (fast != head) {
			head = head.next;
			if (head == null) {
				return null;
			}
			fast = fast.next;
			if (fast == null) {
				return null;
			}
			fast = fast.next;
			if (fast == null) {
				return null;
			}
		}
		fast = fast.next;
		head.next = null;

		ListNode circle = fast;
		int circleLen = 0;
		while (circle != null) {
			circleLen++;
			circle = circle.next;
		}

		ListNode newStart1 = root.next;
		ListNode newStart2 = root.next;

		for (int i = 0; i < circleLen; i++) {
			if (newStart2 == null) {
				return root.next;
			}
			newStart2 = newStart2.next;
		}
		while (newStart2 != null) {
			newStart1 = newStart1.next;
			newStart2 = newStart2.next;
		}
		while (true) {
			if (newStart1 == fast) {
				//for special case: no tail, only ring
				return fast;
			}
			newStart1 = newStart1.next;
			fast = fast.next;
		}
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(0);
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
//		ListNode d = new ListNode(4);
//		ListNode e = new ListNode(5);
//		ListNode f = new ListNode(6);
		node.next = a;
		a.next = a;
		b.next = c;
		 c.next = a;
		// d.next = e;
		// e.next = f;
		// f.next = d;
		System.err.println(detectCycle(node.next));
	}
}