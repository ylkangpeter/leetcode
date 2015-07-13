package peter;

import util.Util.TreeNode;

/**
 * Created by ylkang on 7/13/15.
 */
public class _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        int rootVal = root.val;
        if (rootVal == p.val || rootVal == q.val) {
            return root;
        } else if (rootVal > p.val && rootVal > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (rootVal < p.val && rootVal < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree c = new _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.left = new TreeNode(9);

        System.out.print(c.lowestCommonAncestor(root, new TreeNode(0), new TreeNode(3)));
    }
}
