/**
 * project info: leetcode-peter
 */

package peter;


import java.util.Stack;

import static util.Util.*;

/**
 * Given the root of a binary tree, return the sum of all left leaves.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 24
 * Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
 * Example 2:
 * <p>
 * Input: root = [1]
 * Output: 0
 *  
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 1000].
 * -1000 <= Node.val <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _404_Sum_of_Left_Leaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        return calc(root.right, false) + calc(root.left, true);
    }


    public int calc(TreeNode node, boolean left) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            if (left) {
                return node.val;
            } else {
                return 0;
            }
        } else {
            return calc(node.left, true) + calc(node.right, false);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"3", "9", "20", "-1", "-1", "15", "7"};
        TreeNode n = new TreeNode(0);
//        fromArray(arr, 0, n);
        System.out.println(n.val);
        new _404_Sum_of_Left_Leaves().sumOfLeftLeaves(n);
    }
}
