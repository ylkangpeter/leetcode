package peter;

import util.Util;
import util.Util.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by ylkang on 7/13/15.
 */
public class _236_Lowest_Common_Ancestor_of_a_Binary_Tree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            // found p or q or touch the ground
            return root;

        // search p and q from left and right
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            // from root's left & right we found both p and q, so root is the LCA
            return root;
        else
            // left is not null means from left's left & right we found both q and q
            // so left is the LCA, otherwise, right is the answer
            return left != null ? left : right;
    }

    public static void main(String[] args) {
        _236_Lowest_Common_Ancestor_of_a_Binary_Tree c = new _236_Lowest_Common_Ancestor_of_a_Binary_Tree();
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
