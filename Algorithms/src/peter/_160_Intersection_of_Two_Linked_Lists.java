package peter;

import util.Util.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * 
 * For example, the following two linked lists:
 * 
 * <pre>
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗            
 * B:     b1 → b2 → b3
 * </pre>
 * 
 * begin to intersect at node c1.
 * 
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null. The linked
 * lists must retain their original structure after the function returns. You
 * may assume there are no cycles anywhere in the entire linked structure. Your
 * code should preferably run in O(n) time and use only O(1) memory.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _160_Intersection_of_Two_Linked_Lists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}

		ListNode a = headA;

		while (a.next != null) {
			a = a.next;
		}

		ListNode b = headB;
		while (b != null) {
			if (b.val == a.val) {

				// intersect
				a = headA;
				b = headA;

				while (true) {

					a = a.next;
					if (a == null) {
						a = headB;
					}
					b = b.next;
					if (b == null) {
						b = headB;
					}
					b = b.next;
					if (b == null) {
						b = headB;
					}
					if (a.val == b.val) {
						break;
					}
				}

				a = headA;
				while (true) {
					if (a.val == b.val) {
						return a;
					}
					a = a.next;
					b = b.next;
					if (b == null) {
						b = headB;
					}
				}
			}
			b = b.next;
		}
		return null;
	}

}