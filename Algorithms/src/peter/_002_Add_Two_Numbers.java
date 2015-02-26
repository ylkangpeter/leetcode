package peter;

import util.Util.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * @author ylkang Feb 15, 2015
 */
public class _002_Add_Two_Numbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode root = l1;

		int promotion = 0;

		while (true) {
			int val = l1.val + l2.val + promotion;
			promotion = val / 10;
			val = val % 10;
			l1.val = val;
			if (l1.next != null && l2.next != null) {
				l1 = l1.next;
				l2 = l2.next;
			} else {
				if (l2.next == null) {
					break;
				} else {
					l1.next = l2.next;
					break;
				}
			}
		}

		if (l1.next == null) {
			if (promotion != 0) {
				l1.next = new ListNode(promotion);
			}
		} else {
			ListNode pre = l1;
			l1 = l1.next;
			while (l1 != null) {
				int val = l1.val + promotion;
				promotion = val / 10;
				val = val % 10;
				l1.val = val;
				if (promotion == 0) {
					break;
				}
				pre = l1;
				l1 = l1.next;
			}
			if (promotion > 0) {
				pre.next = new ListNode(promotion);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(5);
		a.next.next = new ListNode(8);
		ListNode b = new ListNode(9);
		b.next = new ListNode(5);
		b.next.next = new ListNode(5);
		b.next.next.next = new ListNode(5);

		System.out.println(addTwoNumbers(a, b));
	}
}