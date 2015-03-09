package peter;

import java.util.LinkedList;
import java.util.List;

import util.Util.TreeNode;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
 * 
 * For example: Given binary tree {3,9,20,#,#,15,7},
 * 
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 * 
 * return its zigzag level order traversal as:
 * 
 * <pre>
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * </pre>
 * 
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized
 * on OJ.
 */
public class _103_Binary_Tree_Zigzag_Level_Order_Traversal {

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();

		if (root == null)
			return list;

		boolean left2Right = true;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		LinkedList[] stacks = new LinkedList[2];
		stacks[0] = new LinkedList<TreeNode>();
		stacks[1] = new LinkedList<TreeNode>();
		stacks[0].push(root);

		int i = 0;

		while (!stacks[0].isEmpty() || !stacks[1].isEmpty()) {

			LinkedList currentStack = stacks[i % 2];
			i = (i + 1) % 2;

			LinkedList<Integer> innerList = new LinkedList<Integer>();
			list.add(innerList);
			while (!currentStack.isEmpty()) {
				TreeNode node = (TreeNode) currentStack.pop();
				if (left2Right) {
					innerList.add(node.val);
					if (node.left != null) {
						stacks[i].addFirst(node.left);
					}
					if (node.right != null) {
						stacks[i].addFirst(node.right);
					}
				} else {
					innerList.add(node.val);
					if (node.right != null) {
						stacks[i].push(node.right);
					}
					if (node.left != null) {
						stacks[i].push(node.left);
					}
				}
			}
			left2Right = !left2Right;
		}

		return list;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(-1);
		root.left.left.left = new TreeNode(5);
		root.left.left.right = new TreeNode(1);
		root.right.left.left = new TreeNode(6);
		root.right.right.left = new TreeNode(8);

		System.out.println(zigzagLevelOrder(root));
	}
}