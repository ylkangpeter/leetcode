package peter;

import util.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 节点值的范围在32位有符号整数范围内。
 * <p>
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 */
public class _637_Average_of_Levels_in_Binary_Tree {

    public List<Double> averageOfLevels(TreeNode root) {


        List<Double> list = new ArrayList<Double>();

        if (root == null) {
            return new ArrayList<>();
        }

        int layer = 0;
        ArrayList[] stack = new ArrayList[2];
        stack[0] = new ArrayList();
        stack[1] = new ArrayList();

        stack[0].add(root);

        int currentStack = 0;

        while (!stack[currentStack].isEmpty()
                || !stack[(currentStack + 1) % 2].isEmpty()) {
            currentStack = layer % 2;
            TreeNode node = null;
            int num = 0;
            double total = 0;
            while (!stack[currentStack].isEmpty()) {
                node = (TreeNode) (stack[currentStack].remove(0));
                total += node.val;
                num++;
                if (node.left != null) {
                    stack[(currentStack + 1) % 2].add(node.left);
                }
                if (node.right != null) {
                    stack[(currentStack + 1) % 2].add(node.right);
                }

            }
            list.add(total / num);
            layer++;

        }
        return list;
    }
}