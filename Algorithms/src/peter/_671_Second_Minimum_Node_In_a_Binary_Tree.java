package peter;

import util.Util;
import util.Util.TreeNode;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为?2?或?0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * <p>
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * <p>
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点数目在范围 [1, 25] 内
 * 1 <= Node.val <= 231 - 1
 * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
 * <p>
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 */
public class _671_Second_Minimum_Node_In_a_Binary_Tree {

    long _1st = Long.MAX_VALUE;
    long _2nd = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        getV(root.val);
        if (root.left != null) {
            int val = Math.min(root.right.val, root.left.val);
            getV(val);
            findSecondMinimumValue(root.left);
            findSecondMinimumValue(root.right);
        }
        if (_2nd == Long.MAX_VALUE) {
            return -1;
        } else {
            return (int) _2nd;
        }
    }

    private void getV(int val) {
        if (_1st > val) {
            _2nd = _1st;
            _1st = val;
        } else if (_2nd > val && _1st != val) {
            _2nd = val;
        }
    }

    public static void main(String[] args) {
        new _671_Second_Minimum_Node_In_a_Binary_Tree().findSecondMinimumValue(Util.fromArray(new String[]{"5", "5",
                        "6"}
                , 0));
    }
}