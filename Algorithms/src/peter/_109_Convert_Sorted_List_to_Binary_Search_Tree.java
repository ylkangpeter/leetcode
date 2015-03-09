package peter;

import java.util.Arrays;

import util.Util.ListNode;
import util.Util.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * @author ylkang Mar 4, 2015
 */
public class _109_Convert_Sorted_List_to_Binary_Search_Tree {

	/**
	 * let's suppose the list is no larger than 2,000,000
	 */
	private static int[] arr = { 0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023,
			2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287,
			1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863,
			134217727, 268435455, 536870911, 1073741823, 2147483647 };

	private static int maxLevelEle = 0;

	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}

		int len = 0;
		ListNode tmp = head;
		while (tmp != null) {
			tmp = tmp.next;
			len++;
		}

		int level = Arrays.binarySearch(arr, len);
		if (level < 0) {
			level = -1 - level;
		}
		if (level > 0) {
			maxLevelEle = len - arr[level - 1];
		}
		Pack pack = buildNode(head, level);
		return pack.node;
	}

	private static Pack buildNode(ListNode head, int level) {
		if (head == null) {
			return null;
		}
		if (level == 1) {
			if (maxLevelEle != 0) {
				Pack pack = new Pack();
				pack.nextNode = head.next;
				pack.node = new TreeNode(head.val);
				maxLevelEle--;
				return pack;
			}
		} else {
			Pack left = buildNode(head, level - 1);
			if (left == null) {
				left = new Pack();
				left.node = new TreeNode(head.val);
				left.nextNode = head.next;
				return left;
			}
			ListNode tmpNode = left.nextNode;
			if (tmpNode == null) {
				return left;
			}
			TreeNode father = new TreeNode(tmpNode.val);
			head = tmpNode.next;
			father.left = left.node;
			Pack right = buildNode(head, level - 1);
			Pack pack = new Pack();
			pack.node = father;
			if (right == null) {
				if (head != null) {
					pack.nextNode = head;
				}
				return pack;
			}

			pack.nextNode = right.nextNode;
			father.right = right.node;
			return pack;
		}
		return null;
	}

	private static class Pack {
		TreeNode node;
		ListNode nextNode;
	}

	public static void main(String[] args) {

		// for (int i = 0; i < Integer.MAX_VALUE; i++) {
		// long n = (long) Math.pow(2, i) - 1;
		// if (n > Long.MAX_VALUE) {
		// break;
		// }
		// System.out.println(n);
		// }
		ListNode node = new ListNode(0);
		node.next = new ListNode(1);
		node.next.next = new ListNode(2);
		node.next.next.next = new ListNode(3);
		node.next.next.next.next = new ListNode(4);
		node.next.next.next.next.next = new ListNode(5);
		node.next.next.next.next.next.next = new ListNode(6);
		node.next.next.next.next.next.next.next = new ListNode(7);
		node.next.next.next.next.next.next.next.next = new ListNode(8);
		node.next.next.next.next.next.next.next.next.next = new ListNode(9);
		System.out.println(sortedListToBST(node));
	}
}