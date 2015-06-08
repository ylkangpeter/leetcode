package peter;

import util.Util.TreeNode;

/**
 * 
 * @author ylkang Jun 8, 2015
 */
public class _224_Count_Complete_Tree_Nodes {

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null) {
			return 1;
		}

		int height = height(root);
		int totalLastLevel = nodes(root, height);
		return (int) Math.pow(2, height - 1) + totalLastLevel;
	}

	private int nodes(TreeNode node, int height) {
		if (node == null) {
			return 0;
		}
		if (height(node.right) == height - 1) {
			return (int) Math.pow(2, height - 2)
					+ nodes(node.right, height - 1);
		} else {
			return nodes(node.left, height - 1);
		}
	}

	private int height(TreeNode node) {
		int height = 0;
		TreeNode tmp = node;
		while (tmp != null) {
			tmp = tmp.left;
			height++;
		}
		return height;
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
//		node.left.left = new TreeNode(3);
//		node.left.right = new TreeNode(4);
//		node.right = new TreeNode(5);
//		node.right.left = new TreeNode(1);
		// node.left= new TreeNode(1);
		// node.left= new TreeNode(1);
		System.out.println(new _224_Count_Complete_Tree_Nodes()
				.countNodes(node));
	}
}
