package peter;

import util.Util.TreeNode;

/**
 * 
 * @author ylkang Feb 5, 2015
 */
public class _101_Symmetric_Tree {

	public boolean isSymmetric(TreeNode root) {
		if (root != null) {
			return isSymm(root.left, root.right);
		}
		return true;
	}

	private boolean isSymm(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		if (left.val == right.val) {
			return isSymm(left.left, right.right)
					&& isSymm(left.right, right.left);
		}
		return false;
	}

}