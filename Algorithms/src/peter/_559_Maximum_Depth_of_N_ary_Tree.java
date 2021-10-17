package peter;

import util.Util.Node;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：5
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树的深度不会超过?1000 。
 * 树的节点数目位于 [0,?104] 之间。
 * <p>
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 */
public class _559_Maximum_Depth_of_N_ary_Tree {


    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children == null) {
            return 1;
        } else {
            int max = 0;
            for (Node node : root.children) {
                max = Math.max(max, maxDepth(node));
            }
            return max + 1;
        }

    }
//    int result = 1;
//
//    public int maxDepth(Node root) {
//        if (root == null) {
//            return 0;
//        } else {
//            for (Node n : root.children) {
//                depth(n, 1);
//            }
//            return result;
//        }
//    }
//
//    private void depth(Node node, int preLevel) {
//        System.out.println(node.val + "\t" + preLevel);
//        if (node.children == null) {
//            result = Math.max(result, preLevel + 1);
//        } else {
//            for (Node n : node.children) {
//                depth(n, preLevel + 1);
//            }
//        }
//    }

    public static void main(String[] args) {
        Node n = util.Util.fromArray(new String[]{"1", null, "2", "3", "4", "5", null, null, "6", "7", null, "8",
                        null, "9", "10", null, null, "11", null, "12", null, "13", null, null, "14"}
//        		new String[]{"1", null, "3", "2", "4", null, "5", "6"}
        );
        System.out.println(new _559_Maximum_Depth_of_N_ary_Tree().maxDepth(n));
    }
}