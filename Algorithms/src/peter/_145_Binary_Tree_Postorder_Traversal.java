package peter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.Util.TreeNode;

public class _145_Binary_Tree_Postorder_Traversal{

    public List<Integer> postorderTraversal(TreeNode root) {
        
		if (root == null) {
			return new ArrayList<Integer>();
		}
		List<Integer> result = new ArrayList<Integer>();

		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (root != null) {
			stack.push(root);
			root = root.left;
		}

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.right != null) {
				TreeNode tmp = node.right;
				node.right = null;
				stack.push(node);
				stack.push(tmp);
				tmp = tmp.left;
				while (tmp != null) {
					stack.push(tmp);
					tmp = tmp.left;
				}
			} else {
				result.add(node.val);
			}
		}
		return result;
	
    }

}