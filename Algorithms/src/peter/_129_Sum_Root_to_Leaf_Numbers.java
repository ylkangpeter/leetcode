package peter;

import util.Util.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 * <pre>
 *     1
 *    / \
 *   2   3
 * </pre>
 * 
 * The root-to-leaf path 1->2 represents the number 12. The root-to-leaf path
 * 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 * @author ylkang Feb 11, 2015
 */
public class _129_Sum_Root_to_Leaf_Numbers {

	public static int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null) {
			return sumNumbers(root.val, root.right);
		}
		if (root.right == null) {
			return sumNumbers(root.val, root.left);
		}
		return sumNumbers(root.val, root.left)
				+ sumNumbers(root.val, root.right);
	}

	private static int sumNumbers(int val, TreeNode node) {
		if (node == null) {
			return val;
		}
		val = val * 10 + node.val;
		if (node.left == null) {
			return sumNumbers(val, node.right);
		}
		if (node.right == null) {
			return sumNumbers(val, node.left);
		}
		return sumNumbers(val, node.left) + sumNumbers(val, node.right);
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(9);
		// node.left = new TreeNode(1);
		// node.left.left = new TreeNode(2);
		// node.left.right = new TreeNode(3);

		System.out.println(sumNumbers(node));
	}
}