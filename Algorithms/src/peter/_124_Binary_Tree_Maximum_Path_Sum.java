package peter;

import util.Util.TreeNode;

/**
 * 
 * @author ylkang Apr 14, 2015
 */
public class _124_Binary_Tree_Maximum_Path_Sum {

	private static int max = Integer.MIN_VALUE;

	public static int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		calc(root);
		return max;
	}

	private static int calc(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int left = calc(root.left);
			int right = calc(root.right);
			if (left < 0) {
				left = 0;
			}
			if (right < 0) {
				right = 0;
			}
			int tmp = root.val + right + left;
			max = Math.max(max, tmp);
			return root.val + Math.max(right, left);
		}

	}
}