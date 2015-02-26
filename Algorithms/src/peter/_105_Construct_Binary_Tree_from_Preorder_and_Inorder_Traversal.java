package peter;

import util.Util.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * @author ylkang Feb 25, 2015
 */
public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

	private static int inorderInx = 0;
	private static int preorderInx = 1;

	private static TreeNode root;

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder == null || inorder.length == 0) {
			return null;
		}
		root = new TreeNode(preorder[0]);
		buildTree(inorder, preorder, root);
		return root;
	}

	public static void buildTree(int[] inorder, int[] preorder, TreeNode root) {

		while (preorderInx < preorder.length) {

			if (inorder[inorderInx] == preorder[preorderInx]) {
				root.left = new TreeNode(inorder[inorderInx]);
				inorderInx++;
				preorderInx++;
				while (inorderInx < inorder.length
						&& preorderInx < preorder.length
						&& inorder[inorderInx] == preorder[preorderInx]) {
					TreeNode tmp = new TreeNode(inorder[inorderInx]);
					root.right = tmp;
					root = root.right;
					inorderInx++;
					preorderInx++;
				}
			} else {
				TreeNode tmp = new TreeNode(preorder[preorderInx]);
				if (root.left != null) {
					root.right = tmp;
				} else {
					root.left = tmp;
				}
				preorderInx++;
				buildTree(inorder, preorder, tmp);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(buildTree(new int[] { 6, 2, 1, 4, 3, 5, 7, 9, 8 },
				new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
	}

}