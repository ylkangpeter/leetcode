package peter;

import util.Util.TreeNode;

public class _110_Balanced_Binary_Tree {

	public boolean isBalanced(TreeNode root) {
		return root == null || balance(root, 1) > 0;
	}

	private int balance(TreeNode node, int level) {
		int l = node.left != null ? balance(node.left, level + 1) : level;
		int r = node.right != null ? balance(node.right, level + 1) : level;
		if (l == -1 || r == -1 || Math.abs(r - l) > 1)
			return -1;
		return Math.max(l, r);
	}

}