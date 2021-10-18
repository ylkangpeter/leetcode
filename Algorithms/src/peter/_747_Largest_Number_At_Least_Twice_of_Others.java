package peter;

/**
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * <p>
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,1,0]
 * 输出：1
 * 解释：6 是最大的整数，对于数组中的其他整数，6 大于数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：-1
 * 解释：4 没有超过 3 的两倍大，所以返回 -1 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 * 解释：因为不存在其他数字，所以认为现有数字 1 至少是其他数字的两倍。
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 50
 * 0 <= nums[i] <= 100
 * nums 中的最大元素是唯一的
 * <p>
 * https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
 */
public class _747_Largest_Number_At_Least_Twice_of_Others {

    public int dominantIndex(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        } else if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] >= 2 * (long) nums[1] ? 0 : -1 : nums[1] >= 2 * (long) nums[0] ? 1 : -1;
        }
        int max = 0, second = 0;
        if (nums[0] > nums[1]) {
            max = 0;
            second = 1;
        } else {
            max = 1;
            second = 0;
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                second = max;
                max = i;
            } else if (nums[i] == nums[max]) {
            } else if (nums[i] > nums[second]) {
                second = i;
            }
        }
        if (nums[max] >= (long) nums[second] * 2) {
            return max;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        new _747_Largest_Number_At_Least_Twice_of_Others().dominantIndex(new int[]{1, 2, 3, 4});
    }
}