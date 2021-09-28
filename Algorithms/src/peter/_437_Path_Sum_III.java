/**
 * project info: test-com
 */

package peter;

/**
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the
 * values along the path equals targetSum.
 * <p>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from
 * parent nodes to child nodes).
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * Example 2:
 * <p>
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 *  
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 1000].
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _437_Path_Sum_III {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int rootSum(TreeNode root, int targetSum) {
        int result = 0;
        if (root == null) {
            return result;
        } else {
            if (root.val == targetSum) {
                result++;
            }

            result += rootSum(root.left, targetSum - root.val);
            result += rootSum(root.right, targetSum - root.val);
        }
        return result;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        } else {
            int result = rootSum(root, targetSum);
            result += pathSum(root.left, targetSum);
            result += pathSum(root.right, targetSum);
            return result;
        }
    }

    private TreeNode createTreeFromArray(int[] num, int inx) {
        TreeNode node = null;
        if (inx < num.length) {
            node = new TreeNode(num[inx]);
            node.left = createTreeFromArray(num, 2 * inx + 1);
            node.right = createTreeFromArray(num, 2 * inx + 2);
        }

        return node;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, -3, 3, 2, 0, 11, 3, -2, 0, 1};
        TreeNode node = new _437_Path_Sum_III().createTreeFromArray(arr, 0);
        System.out.println(node.val);
    }
}
