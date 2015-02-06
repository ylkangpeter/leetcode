package util;

import java.util.ArrayList;
import java.util.List;

public class Util {
	
	public class TreeLinkNode {
		public int val;
		public TreeLinkNode left, right, next;

		public TreeLinkNode(int x) {
			val = x;
		}
	}

	public static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int x) {
			val = x;
		}

		public String toString() {
			return String.valueOf(val);
		}
	}

	private static int pos;
	private static TreeNode[] theArray;

	public static void toArray(TreeNode node, int size) {
		pos = 0;
		theArray = new TreeNode[size];
		addNode(node);
	}

	private static void addNode(TreeNode current) {
		if (current != null) {
			addNode(current.left);
			theArray[pos++] = current;
			addNode(current.right);
		}
	}

	private static TreeNode root = new TreeNode(0);

	public static void fromArray(String[] arr, int inx, TreeNode node) {
		if (inx >= arr.length) {
			return;
		}
		node.val = Integer.parseInt(arr[inx]);
		node.left = new TreeNode(-1);
		node.right = new TreeNode(-1);
		fromArray(arr, inx * 2 + 1, node.left);
		fromArray(arr, inx * 2 + 2, node.right);
	}

	public static List<ListNode> buildNodes(int[][] arrs) {
		List<ListNode> list = new ArrayList<ListNode>();
		for (int i = 0; i < arrs.length; i++) {
			ListNode root = new ListNode(0);
			ListNode tmp = root;
			for (int j = 0; j < arrs[i].length; j++) {
				tmp.next = new ListNode(arrs[i][j]);
				tmp = tmp.next;
			}
			list.add(root.next);
		}
		return list;
	}

	public static void main(String[] args) {

		String[] tree = "1,2,3,-1,-1,-1,4".split(",");
		fromArray(tree, 0, root);
		System.out.println(root);
	}
}
