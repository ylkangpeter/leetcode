package peter;

import java.util.LinkedList;

import util.Util.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * <pre>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * </pre>
 * 
 * @author ylkang May 11, 2015
 */
public class _098_Validate_Binary_Search_Tree {

	public boolean isValidBST(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		long pre = Long.MIN_VALUE;

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (pre >= node.val) {
				return false;
			}
			pre = node.val;
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return true;
	}

	public boolean isValidBST_Better(TreeNode root) {
		return helper(Long.MIN_VALUE, Long.MAX_VALUE, root);
	}

	private boolean helper(long minValue, long maxValue, TreeNode root) {
		if (root == null)
			return true;
		return minValue < root.val && root.val < maxValue
				&& helper(minValue, root.val, root.left)
				&& helper(root.val, maxValue, root.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.right = new TreeNode(6);
		root.left.left = new TreeNode(4);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(10);
		System.out.println(new _098_Validate_Binary_Search_Tree()
				.isValidBST(root));
	}
}