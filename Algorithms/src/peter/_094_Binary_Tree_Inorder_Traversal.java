package peter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import util.Util.TreeNode;

/**
 * 
 * @author ylkang Feb 5, 2015
 */
public class _094_Binary_Tree_Inorder_Traversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return list;
	}

}