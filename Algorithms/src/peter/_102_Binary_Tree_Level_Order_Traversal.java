package peter;

import java.util.ArrayList;
import java.util.List;

import util.Util.TreeNode;

/**
 * 
 * @author ylkang Feb 5, 2015
 */
public class _102_Binary_Tree_Level_Order_Traversal {

	/*
	 * 2 queue here? emmm, cause it's from another function.. so just reuse it
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();

		if (root == null) {
			return list;
		}

		int layer = 0;
		ArrayList[] stack = new ArrayList[2];
		stack[0] = new ArrayList();
		stack[1] = new ArrayList();

		stack[0].add(root);

		int currentStack = 0;

		while (!stack[currentStack].isEmpty()
				|| !stack[(currentStack + 1) % 2].isEmpty()) {
			currentStack = layer % 2;
			TreeNode node = null;
			List<Integer> innerList = new ArrayList<Integer>();
			while (!stack[currentStack].isEmpty()) {
				node = (TreeNode) (stack[currentStack].remove(0));
				innerList.add(node.val);

				if (node.left != null) {
					stack[(currentStack + 1) % 2].add(node.left);
				}
				if (node.right != null) {
					stack[(currentStack + 1) % 2].add(node.right);
				}

			}
			if (!innerList.isEmpty()) {
				list.add(innerList);
			}
			layer++;

		}
		return list;

	}

}