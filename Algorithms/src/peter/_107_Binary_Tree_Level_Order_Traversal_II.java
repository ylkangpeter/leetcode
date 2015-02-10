package peter;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import util.Util.TreeNode;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes'
 * values. (ie, from left to right, level by level from leaf to root).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7},
 * 
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 * 	  15   7
 * 
 * </pre>
 * 
 * return its bottom-up level order traversal as:
 * 
 * <pre>
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * </pre>
 * 
 * @author ylkang Feb 10, 2015
 */
public class _107_Binary_Tree_Level_Order_Traversal_II {

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();

		if (root == null)
			return list;

		int levelSize = 1;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			int i = levelSize;
			levelSize = 0;

			LinkedList<Integer> innerList = new LinkedList<Integer>();
			list.addFirst(innerList);
			while (i-- > 0) {
				TreeNode node = stack.pop();
				innerList.addFirst(node.val);

				if (node.right != null) {
					stack.add(node.right);
					levelSize++;
				}
				if (node.left != null) {
					stack.add(node.left);
					levelSize++;
				}
			}
		}

		return list;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		System.out.println(levelOrderBottom(root));
	}
}