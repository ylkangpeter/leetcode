package peter;

import util.Util;

import java.util.*;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 * <p>
 * 例如：
 * 给定 BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * <p>
 * <p>
 * 返回[2].
 * <p>
 * 提示：如果众数超过1个，不需考虑输出顺序
 * <p>
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * <p>
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 */
public class _501_Find_Mode_in_Binary_Search_Tree {

    public int[] findMode(Util.TreeNode root) {

        List<Integer> list = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        traverse(root, map);
        int max = Integer.MIN_VALUE;
        for (int v : map.values()) {
            max = Math.max(v, max);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void traverse(Util.TreeNode root, Map<Integer, Integer> map) {
        if (root != null) {
            int v = map.getOrDefault(root.val, 0);
            map.put(root.val, ++v);
            traverse(root.left, map);
            traverse(root.right, map);
        }
    }


}