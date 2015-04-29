package peter;

import util.Util.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example
 * 
 * <pre>
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * </pre>
 * 
 * *
 * 
 * @author peter Apr 29, 2015
 * 
 */
public class _203_Remove_Linked_List_Elements {

	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}

		ListNode root = null;

		while (head != null && head.val == val) {
			head = head.next;
		}
		if (head == null) {
			return null;
		}
		root = head;
		head = head.next;
		root.next = null;
		ListNode cursor = root;

		while (head != null) {
			if (head.val == val) {
				head = head.next;
				continue;
			} else {
				cursor.next = head;
				head = head.next;
				cursor = cursor.next;
				cursor.next = null;
			}
		}

		return root;
	}

	public static void main(String[] args) {
		ListNode list = new ListNode(1);
		list.next = new ListNode(1);
		list.next.next = new ListNode(1);
		list.next.next.next = new ListNode(5);
		list.next.next.next.next = new ListNode(5);
		System.out.println(new _203_Remove_Linked_List_Elements()
				.removeElements(list, 5));
	}
}
