package peter;

import java.util.ArrayList;
import java.util.List;

import util.Util.TreeNode;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * For example: Given the below binary tree and sum = 22,
 * 
 * <pre>
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * </pre>
 * 
 * *
 * 
 * @author ylkang Feb 17, 2015
 */
public class _113_Path_Sum_II {

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		calc(root, sum, list, new ArrayList<Integer>());
		return list;
	}

	private static void calc(TreeNode root, int sum, List<List<Integer>> list,
			List<Integer> tmp) {
		if (root == null) {
			return;
		} else if (root.val == sum && root.left == null && root.right == null) {
			tmp.add(root.val);
			list.add(tmp);
			return;
		} else {
			tmp.add(root.val);
			List<Integer> newTmp = new ArrayList<Integer>();
			newTmp.addAll(tmp);
			calc(root.left, sum - root.val, list, tmp);
			calc(root.right, sum - root.val, list, newTmp);
		}
	}

	public static void main(String[] args) {
		int sum = 22;
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);

		root.right = new TreeNode(8);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);

		System.out.println(pathSum(root, sum));
	}
}