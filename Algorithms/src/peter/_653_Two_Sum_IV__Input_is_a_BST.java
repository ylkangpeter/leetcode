package peter;

import util.Util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], k = 28
 * 输出: false
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入: root = [2,1,3], k = 4
 * 输出: true
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入: root = [2,1,3], k = 1
 * 输出: false
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * 输入: root = [2,1,3], k = 3
 * 输出: true
 * <p>
 * <p>
 * ?
 * <p>
 * 提示:
 * <p>
 * <p>
 * 二叉树的节点个数的范围是??[1, 104].
 * -104?<= Node.val <= 104
 * root?为二叉搜索树
 * -105?<= k <= 105
 * <p>
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
 */
public class _653_Two_Sum_IV__Input_is_a_BST {

    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        traverse(map, root);
        for (int key : map.keySet()) {
            if (map.get(k - key) != null) {
                if (k == key * 2) {
                    if (map.get(key) > 1) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private void traverse(Map<Integer, Integer> map, TreeNode node) {
        if (node != null) {
            int v = map.getOrDefault(node.val, 0);
            map.put(node.val, ++v);
            traverse(map, node.left);
            traverse(map, node.right);
        }
    }
}