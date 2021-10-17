package peter;

import sun.reflect.generics.tree.Tree;
import util.Util.TreeNode;

/**
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * 输出：false
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * root 树上的节点数量范围是 [1, 2000]
 * subRoot 树上的节点数量范围是 [1, 1000]
 * -104 <= root.val <= 104
 * -104 <= subRoot.val <= 104
 * <p>
 * https://leetcode-cn.com/problems/subtree-of-another-tree
 */
public class _572_Subtree_of_Another_Tree {

    public boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else {
            if (root == null) {
                return false;
            } else if (subRoot == null) {
                return false;
            } else if (root.val != subRoot.val) {
                return false;
            } else {
                return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
            }
        }
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        } else {
            return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = util.Util.fromArray(new String[]{"1", null, "1", null, "1", null, "1", null, "1", null, "1",
                null, "1", null,
                "1", null, "1", null, "1", null, "1", "2"}, 0);
        TreeNode t2 = util.Util.fromArray(new String[]{
                "1", null, "1", null, "1", null, "1", null,
                "1", null, "1", "2"
        }, 0);
        new _572_Subtree_of_Another_Tree().isSubtree(t1, t2);
    }


}