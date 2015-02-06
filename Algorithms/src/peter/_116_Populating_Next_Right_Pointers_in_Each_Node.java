package peter;

import java.util.LinkedList;

import util.Util.TreeLinkNode;

/**
 * Given a binary tree
 * 
 * struct TreeLinkNode { TreeLinkNode *left; TreeLinkNode *right; TreeLinkNode
 * *next; } Populate each next pointer to point to its next right node. If there
 * is no next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * You may only use constant extra space. You may assume that it is a perfect
 * binary tree (ie, all leaves are at the same level, and every parent has two
 * children). For example, Given the following perfect binary tree,
 * 
 * <pre>
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 * </pre>
 * 
 * After calling your function, the tree should look like:
 * 
 * <pre>
 * 1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 * </pre>
 * 
 * @author ylkang Feb 5, 2015
 */
public class _116_Populating_Next_Right_Pointers_in_Each_Node {

	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		int i = 1;

		LinkedList<TreeLinkNode> list = new LinkedList<TreeLinkNode>();
		list.add(root);
		while (!list.isEmpty()) {
			int counter = 0;
			TreeLinkNode tmp = null;
			while (counter++ < i) {
				TreeLinkNode cur = list.pop();
				cur.next = tmp;
				tmp = cur;
				if (cur.left != null) {
					list.add(cur.right);
					list.add(cur.left);
				}
			}
			i *= 2;
		}
	}

}