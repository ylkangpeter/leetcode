package peter;

import util.Util.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end
 * should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example, Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * @author peter Mar 26, 2015
 * 
 */
public class _025_Reverse_Nodes_in_k_Group {

	public static ListNode reverseKGroup(ListNode head, int k) {

		int length = 0;
		ListNode counterNode = head;
		while (counterNode != null) {
			length++;
			counterNode = counterNode.next;
		}

		if (length < k || k <= 0) {
			return head;
		}

		ListNode root = null;
		ListNode currentNode = head;
		ListNode tail = null;

		ListNode tmpQueueHead = null;
		ListNode tmpQueueTail = null;

		if (k == 0) {
			return head;
		}

		int counter = 0;

		while (currentNode != null) {
			if (counter != 0 && counter % k == 0) {
				if (root == null) {
					root = tmpQueueHead;
					tail = tmpQueueTail;
				} else {
					tail.next = tmpQueueHead;
					tail = tmpQueueTail;
				}
				length -= k;
				tmpQueueHead = null;
				tmpQueueTail = null;
			}
			if (length < k) {
				break;
			}
			ListNode tmp = currentNode;
			currentNode = currentNode.next;
			tmp.next = null;
			if (tmpQueueTail == null) {
				tmpQueueTail = tmp;
				tmpQueueHead = tmp;
			} else {
				tmp.next = tmpQueueHead;
				tmpQueueHead = tmp;
			}

			counter++;
		}
		if (tail != null) {
			if (currentNode != null) {
				tail.next = currentNode;
			} else {
				tail.next = tmpQueueHead;
			}
		} else {
			return tmpQueueHead;
		}
		return root;

	}

	public static void main(String[] args) {
		ListNode node = new ListNode(0);
		node.next = new ListNode(1);
		node.next.next = new ListNode(2);
		node.next.next.next = new ListNode(3);
		node.next.next.next.next = new ListNode(4);
		node.next.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next.next = new ListNode(6);
		node.next.next.next.next.next.next.next = new ListNode(7);
		node.next.next.next.next.next.next.next.next = new ListNode(8);
		// System.out.println(reverseKGroup(node, 1));
		// System.out.println(reverseKGroup(node, 2));
		// System.out.println(reverseKGroup(node, 3));
		// System.out.println(reverseKGroup(node, 4));
		// System.out.println(reverseKGroup(node, 5));
//		System.out.println(reverseKGroup(node, 6));
		// System.out.println(reverseKGroup(node, 7));
		// System.out.println(reverseKGroup(node, 8));
		 System.out.println(reverseKGroup(node, 10));
	}
}