package peter;

import java.util.ArrayList;
import java.util.List;

import util.Util.TreeNode;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * For example: Given the following binary tree,
 * 
 * <pre>
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * </pre>
 * 
 * You should return [1, 3, 4].
 * 
 * @author ylkang Apr 7, 2015
 */
public class _199_Binary_Tree_Right_Side_View {

	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		parse(root, list, 1);
		return list;
	}

	private static void parse(TreeNode root, List<Integer> list, int level) {
		if (root == null) {
			return;
		}
		if (list.size() < level) {
			list.add(root.val);
		}
		parse(root.right, list, level + 1);
		parse(root.left, list, level + 1);
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(0);
		node.left = new TreeNode(1);
		node.right = new TreeNode(2);
		node.left.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right.right = new TreeNode(5);
		node.right.right = new TreeNode(6);
		System.out.println(rightSideView(node));
	}
}
