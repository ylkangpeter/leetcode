package peter;

import java.util.Stack;

import util.Util.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _104_Maximum_Depth_of_Binary_Tree {

	/**
	 * Definition for binary tree public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	public class Solution {
		public int maxDepth(TreeNode root) {

			if (root == null) {
				return 0;
			}

			int total = 0;
			Stack[] stack = new Stack[2];
			stack[0] = new Stack<TreeNode>();
			stack[1] = new Stack<TreeNode>();

			stack[0].push(root);

			int currentStack = 0;
			while (!stack[currentStack].isEmpty()
					|| !stack[(currentStack + 1) % 2].isEmpty()) {
				currentStack = total % 2;
				TreeNode node = null;
				while (!stack[currentStack].isEmpty()) {
					node = (TreeNode) (stack[currentStack].pop());
					if (node.right != null) {
						stack[(currentStack + 1) % 2].push(node.right);
					}
					if (node.left != null) {
						stack[(currentStack + 1) % 2].push(node.left);
					}
				}
				total++;

			}
			return total;

		}
	}
}
