package peter;

/**
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * <p>
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == nums.length
 * 1 <= k <= n <= 105
 * -104 <= nums[i] <= 104
 * <p>
 * https://leetcode-cn.com/problems/maximum-average-subarray-i
 */
public class _643_Maximum_Average_Subarray_I {

    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        double curSum = 0;
        for (int i = 0; i < k; i++) {
            curSum += nums[i];
        }
        double max = curSum;

        for (int i = k; i < nums.length; i++) {
            curSum -= nums[i - k];
            curSum += nums[i];
            max = Math.max(curSum, max);

        }
        return max / k;
    }

    public static void main(String[] args) {
        new _643_Maximum_Average_Subarray_I().findMaxAverage(new int[]{0, 4, 0, 3, 2}, 1);
    }
}