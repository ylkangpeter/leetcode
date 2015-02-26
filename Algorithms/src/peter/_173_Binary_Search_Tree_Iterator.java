package peter;

import util.Util.TreeNode;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * @author ylkang Feb 13, 2015
 */
public class _173_Binary_Search_Tree_Iterator {

	/**
	 * 
	 * Morris traversal
	 * 
	 * 1. if (cur.left==null) print cur;cur=cur.right;
	 * 
	 * 2. if(cur.left!=null) preNode = findPreInOrderNode(cur);
	 * 
	 * a) if(preNode.right==null) preNode.right=cur; cur=cur.left;
	 * 
	 * b) if(preNode.right==cur) preNode.right=null;cur=cur.right
	 * 
	 * 3. repeat 1,2,3 until cur==null。
	 * 
	 * @param root
	 */

	/** @return the next smallest number */
	public int next() {
		if (!hasNext()) {
			return 0;
		}

		while (cur != null) {
			if (cur.left == null) {
				int val = cur.val;
				cur = cur.right;
				return val;
			}

			TreeNode preInOrderNode = cur.left;
			while (preInOrderNode.right != null && preInOrderNode.right != cur) {
				preInOrderNode = preInOrderNode.right;
			}

			if (preInOrderNode.right == null) {
				preInOrderNode.right = cur;
				cur = cur.left;
			} else {
				int val = cur.val;
				cur = cur.right;
				preInOrderNode.right = null;

				return val;
			}
		}

		return 0;
	}

	private TreeNode cur;

	public _173_Binary_Search_Tree_Iterator(TreeNode root) {
		cur = root;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if (cur == null) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(4);
		node.left = new TreeNode(2);
		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(3);
		node.right = new TreeNode(6);
		node.right.left = new TreeNode(5);
		node.right.right = new TreeNode(8);
		node.right.left = new TreeNode(7);
		_173_Binary_Search_Tree_Iterator tree = new _173_Binary_Search_Tree_Iterator(
				node);
		while (tree.hasNext()) {
			System.out.println(tree.next());
		}
	}

}