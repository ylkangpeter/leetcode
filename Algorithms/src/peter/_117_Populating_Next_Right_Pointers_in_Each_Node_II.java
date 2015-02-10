package peter;

import java.util.LinkedList;

import util.Util.TreeLinkNode;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution
 * still work?
 * 
 * Note:
 * 
 * You may only use constant extra space. For example, Given the following
 * binary tree,
 * 
 * <pre>
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 * </pre>
 * 
 * <pre>
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 * </pre>
 * 
 * @author ylkang Feb 6, 2015
 */
public class _117_Populating_Next_Right_Pointers_in_Each_Node_II {

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
			int total = i;
			i = 0;
			while (counter++ < total) {
				TreeLinkNode cur = list.pop();
				cur.next = tmp;
				tmp = cur;
				if (cur.right != null) {
					list.add(cur.right);
					i++;
				}
				if (cur.left != null) {
					list.add(cur.left);
					i++;
				}
			}
		}

	}

}