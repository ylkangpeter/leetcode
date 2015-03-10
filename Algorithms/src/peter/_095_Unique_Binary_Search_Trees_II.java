package peter;

import java.util.ArrayList;
import java.util.List;

import util.Util.TreeNode;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that
 * store values 1...n.
 * 
 * For example, Given n = 3, your program should return all 5 unique BST's shown
 * below.
 * 
 * <pre>
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * </pre>
 * 
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized
 * on OJ.
 * 
 * @author ylkang Mar 10, 2015
 */
public class _095_Unique_Binary_Search_Trees_II {

	public static List<TreeNode> generateTrees(int n) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		if (n == 0) {
			list.add(null);
			return list;
		}
		for (int i = 1; i <= n; i++) {
			list.addAll(generateTrees(1, n, i));
		}
		return list;
	}

	public static List<TreeNode> generateTrees(int start, int end, int rootVal) {
		List<TreeNode> list = new ArrayList<TreeNode>();

		List<TreeNode> leftList = new ArrayList<TreeNode>();
		for (int leftStart = start; leftStart < rootVal; leftStart++) {
			leftList.addAll(generateTrees(start, rootVal - 1, leftStart));
		}

		List<TreeNode> rightList = new ArrayList<TreeNode>();
		for (int rightStart = rootVal + 1; rightStart <= end; rightStart++) {
			rightList.addAll(generateTrees(rootVal + 1, end, rightStart));
		}

		if (leftList.isEmpty() && rightList.isEmpty()) {
			TreeNode root = new TreeNode(rootVal);
			list.add(root);
		} else if (!leftList.isEmpty() && !rightList.isEmpty()) {
			for (int k = 0; k < leftList.size(); k++) {
				for (int j = 0; j < rightList.size(); j++) {
					TreeNode root = new TreeNode(rootVal);
					list.add(root);
					root.left = leftList.get(k);
					root.right = rightList.get(j);
				}
			}
		} else if (!leftList.isEmpty()) {
			for (int j = 0; j < leftList.size(); j++) {
				TreeNode root = new TreeNode(rootVal);
				list.add(root);
				root.left = leftList.get(j);
			}
		} else {
			for (int j = 0; j < rightList.size(); j++) {
				TreeNode root = new TreeNode(rootVal);
				list.add(root);
				root.right = rightList.get(j);
			}
		}

		return list;
	}

	public static void main(String[] args) {
		System.out.println(generateTrees(0));
	}
}