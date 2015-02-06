package peter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import util.Util.TreeNode;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3},
 * 
 * <pre>
 *    1
 *     \
 *      2
 *     /
 *    3
 * </pre>
 * 
 * return [1,2,3].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author ylkang Feb 5, 2015
 */
public class _144_Binary_Tree_Preorder_Traversal {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node != null) {
				list.add(node.val);

				if (node.right != null) {
					stack.push(node.right);
				}
				if (node.left != null) {
					stack.push(node.left);
				}
			}
		}
		return list;
	}

}
