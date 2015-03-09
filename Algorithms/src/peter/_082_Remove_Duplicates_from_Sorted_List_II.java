package peter;

import java.util.LinkedList;

import util.Util.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3,
 * return 2->3.
 * 
 * @author ylkang Mar 4, 2015
 */
public class _082_Remove_Duplicates_from_Sorted_List_II {

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		LinkedList<ListNode> list = new LinkedList<ListNode>();

		ListNode newRoot = null;
		ListNode newRootCur = null;

		list.push(head);
		head = head.next;

		while (head != null) {
			if (list.peek().val == head.val) {
				if (list.size() > 1) {
					list.pop();
					if (list.peek().val == head.val) {
						list.push(head);
					} else {
						list.push(head);
						list.push(head);
					}
				} else {
					list.push(head);
				}
				head = head.next;
				continue;
			} else {
				ListNode last = list.pop();
				if (list.size() > 0 && list.peek().val == last.val) {
					list.push(last);
					list.push(head);
				} else {
					list.push(head);
					if (newRoot == null) {
						newRoot = last;
						newRootCur = last;
					} else {
						newRootCur.next = last;
						newRootCur = last;
					}
					newRootCur.next = null;
				}
				head = head.next;
			}
		}
		if (list.size() > 1) {
			ListNode node = list.pop();
			if (node.val != list.peek().val) {
				if (newRootCur == null) {
					node.next = null;
					return node;
				}
				newRootCur.next = node;
				node.next = null;
			}
		} else if (list.size() == 1) {
			ListNode node = list.pop();
			if (newRootCur == null) {
				node.next = null;
				return node;
			}
			newRootCur.next = node;
			node.next = null;
		}
		return newRoot;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(0);
		node.next = new ListNode(1);
		// node.next.next = new ListNode(3);
		// node.next.next.next = new ListNode(2);
		// node.next.next.next.next = new ListNode(2);
		// node.next.next.next.next.next = new ListNode(3);
		// node.next.next.next.next.next.next = new ListNode(3);
		// node.next.next.next.next.next.next.next = new ListNode(4);
		// node.next.next.next.next.next.next.next.next = new ListNode(8);
		// node.next.next.next.next.next.next.next.next.next = new ListNode(9);
		System.out.println(deleteDuplicates(node));
	}
}