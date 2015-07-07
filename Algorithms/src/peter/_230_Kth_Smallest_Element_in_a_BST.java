package peter;

import util.Util.TreeNode;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 * Follow up: What if the BST is modified (insert/delete operations) often and
 * you need to find the kth smallest frequently? How would you optimize the
 * kthSmallest routine?
 * 
 * Hint:
 * 
 * Try to utilize the property of a BST. What if you could modify the BST node's
 * structure? The optimal runtime complexity is O(height of BST).
 * 
 * @author ylkang Jul 3, 2015
 */
public class _230_Kth_Smallest_Element_in_a_BST {

	public int kthSmallest(TreeNode root, int k) {
		if (root == null)
			return 0;

		int counter = count(root.left);
		if (counter >= k) {
			return kthSmallest(root.left, k);
		} else if (k > counter + 1) {
			return kthSmallest(root.right, k - counter - 1);
		}
		return root.val;
	}

	private int count(TreeNode left) {
		if (left == null) {
			return 0;
		}
		return 1 + count(left.left) + count(left.right);
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		_230_Kth_Smallest_Element_in_a_BST a = new _230_Kth_Smallest_Element_in_a_BST();
		a.kthSmallest(node, 1);
	}
}
