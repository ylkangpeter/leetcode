package peter;

import java.util.Stack;

import util.Util.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, Given
 * 
 * <pre>
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * </pre>
 * 
 * The flattened tree should look like:
 * 
 * <pre>
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * </pre>
 * 
 * *
 * 
 * @author ylkang Feb 12, 2015
 */
public class _114_Flatten_Binary_Tree_to_Linked_List {

	public static void flatten_stack_and_slow(TreeNode root) {

		if (root == null) {
			return;
		}

		TreeNode newRoot = root;
		TreeNode tmpTail = newRoot;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (newRoot != null) {
			tmpTail = newRoot;
			stack.push(newRoot);
			newRoot = newRoot.left;
		}

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			TreeNode tmp = node.right;

			while (tmp != null) {
				stack.push(tmp);
				tmpTail.left = tmp;
				tmp = tmp.left;
				tmpTail = tmpTail.left;
			}
		}

		newRoot = root;
		TreeNode tmpRoot = root;
		while (newRoot != null) {
			TreeNode a = newRoot.left;
			newRoot = newRoot.left;
			tmpRoot.right = a;
			tmpRoot.left = null;
			tmpRoot = tmpRoot.right;
		}

	}

	/**
	 * <pre>
	 *          1
	 *         / \
	 *        2   5
	 *       / \   \
	 *      3   4   6
	 * </pre>
	 * 
	 * outer: 1->2->5 inner:2->3->4 5->6
	 * 
	 * @param root
	 */

	public static void flatten(TreeNode root) {
		doIt(root);
	}

	public static TreeNode doIt(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode node = root;
		TreeNode lastNode = root;

		while (node != null) {
			if (node.left == null) {
				lastNode = node;
				node = node.right;
			} else {
				TreeNode left = node.left;
				node.left = null;
				TreeNode right = node.right;
				TreeNode result = doIt(left);
				node.right = left;
				result.right = right;
				lastNode = result;
				node = right;
			}
		}

		return lastNode;
	}

	public static void main(String[] args) {
		TreeNode n = new TreeNode(1);
		n.left = new TreeNode(2);
		// n.right.right = new TreeNode(3);
		// n.right.right.left = new TreeNode(4);
		n.left.right = new TreeNode(4);
		n.left.left = new TreeNode(3);
		n.left.left.left = new TreeNode(5);
		// n.right.right = new TreeNode(6);
		flatten(n);
		System.out.println(n);
	}

}