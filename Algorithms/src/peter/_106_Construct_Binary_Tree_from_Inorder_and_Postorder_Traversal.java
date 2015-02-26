package peter;

import util.Util.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * @author ylkang Feb 25, 2015
 */
public class _106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

	private static int inorderInx = 0;
	private static int postorderInx = 0;

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || inorder.length == 0) {
			return null;
		}

		TreeNode node = buildTree(inorder, postorder,
				postorder[postorder.length - 1]);

		if (node == null || node.val != postorder[postorder.length - 1]) {
			TreeNode root = new TreeNode(postorder[postorder.length - 1]);
			root.left = node;
			return root;
		}
		return node;
	}

	public static TreeNode buildTree(int[] inorder, int[] postorder, int rootVal) {

		TreeNode subRoot = null;

		while (inorderInx < inorder.length
				|| postorderInx < postorder.length + postorderInx - inorderInx) {
			if (postorder[postorderInx] == rootVal) {
				postorderInx++;
				break;
			}

			int iPoint = inorder[inorderInx];
			if (inorder[inorderInx] == postorder[postorderInx]) {
				while (inorderInx < inorder.length
						&& postorderInx < postorder.length + postorderInx
								- inorderInx
						&& inorder[inorderInx] == postorder[postorderInx]
						&& inorder[inorderInx] != rootVal) {
					TreeNode tmp = subRoot;
					subRoot = new TreeNode(inorder[inorderInx]);
					subRoot.left = tmp;
					inorderInx++;
					postorderInx++;
				}
			} else {
				// has right leaf
				// iPoint is left most leaf of the right leaf
				// pPoint is right most leaf of the right leaf
				TreeNode tmp = subRoot;
				subRoot = new TreeNode(inorder[inorderInx]);
				subRoot.left = tmp;
				inorderInx++;
				subRoot.right = buildTree(inorder, postorder, iPoint);
			}
		}

		return subRoot;
	}

	public static void main(String[] args) {
		System.out.println(buildTree(new int[] { -1 }, new int[] { -1 }));
	}
}