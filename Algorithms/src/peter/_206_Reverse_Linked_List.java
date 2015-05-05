package peter;

import util.Util.ListNode;

/**
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
 * 
 * @author ylkang May 5, 2015
 */
public class _206_Reverse_Linked_List {

	/**
	 * iteratively
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode newNode = head;
		head = head.next;
		newNode.next = null;

		while (head != null) {
			ListNode tmp = head;
			head = head.next;
			tmp.next = newNode;
			newNode = tmp;
		}

		return newNode;
	}

	/**
	 * recursively
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverseList_recursively(ListNode head) {
		if (null == head || null == head.next) {
			return head;
		}
		ListNode reversedHead = reverseList_recursively(head.next);
		head.next.next = head;
		head.next = null;
		return reversedHead;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		System.out.println(new _206_Reverse_Linked_List()
				.reverseList_recursively(node));
	}
}
