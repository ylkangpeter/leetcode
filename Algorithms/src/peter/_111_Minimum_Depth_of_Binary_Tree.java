package peter;

import java.util.Stack;

import util.Util.TreeNode;

/**
 * 
 * @author ylkang Feb 5, 2015
 */
public class _111_Minimum_Depth_of_Binary_Tree {

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int total = 1;
		@SuppressWarnings("unchecked")
		Stack<TreeNode>[] stack = new Stack[2];
		stack[0] = new Stack<TreeNode>();
		stack[1] = new Stack<TreeNode>();

		stack[0].push(root);

		while (true) {
			int currentStack = (total + 1) % 2;
			TreeNode node = null;
			try {
				while (true) {
					node = (TreeNode) (stack[currentStack].pop());
					if (node.right == null && node.left == null) {
						return total;
					}
					if (node.right != null) {
						stack[(currentStack + 1) % 2].push(node.right);
					}
					if (node.left != null) {
						stack[(currentStack + 1) % 2].push(node.left);
					}
				}
			} catch (Exception e) {
			}
			total++;

		}
	}

}