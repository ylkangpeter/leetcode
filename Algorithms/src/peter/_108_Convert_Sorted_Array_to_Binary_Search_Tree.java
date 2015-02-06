package peter;

import util.Util.TreeNode;

/**
 * 
 * @author ylkang Feb 5, 2015
 */
public class _108_Convert_Sorted_Array_to_Binary_Search_Tree {

	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0)
			return null;
		return sortedArrayToBST(num, 0, num.length - 1);
	}

	private TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (start == end) {
			return new TreeNode(num[start]);
		}
		int middle = (int) (((long) end + start) / 2);
		TreeNode node = new TreeNode(num[middle]);
		if (middle > start) {
			node.left = sortedArrayToBST(num, start, middle - 1);
		}
		if (middle < end) {
			node.right = sortedArrayToBST(num, middle + 1, end);
		}
		return node;
	}

}