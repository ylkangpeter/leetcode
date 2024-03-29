package peter;

import util.Util.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>
 * ?
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * <p>
 * 返回?3, 它的长度是路径 [4,2,1,3] 或者?[5,2,1,3]。
 * <p>
 * ?
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * <p>
 * https://leetcode-cn.com/problems/diameter-of-binary-tree
 */
public class _543_Diameter_of_Binary_Tree {

    private int max = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return depth(root) - 1;
        }
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int L = depth(node.left);
            int R = depth(node.right);
            max = Math.max(max, L + R + 1);
            return Math.max(L, R) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode node = util.Util.fromArray(new String[]{"1", "2", "3", "4", "5"}, 0);
        new _543_Diameter_of_Binary_Tree().diameterOfBinaryTree(node);
    }
}