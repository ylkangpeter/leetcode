package peter;

/**
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 * <p>
 * ?
 * <p>
 * 示例：
 * <p>
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 输入的数组只包含?0 和 1 。
 * 输入数组的长度是正整数，且不超过 10,000。
 * <p>
 * https://leetcode-cn.com/problems/max-consecutive-ones
 */
public class _485_Max_Consecutive_Ones {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;
        for (int num : nums) {
            if (num == 1) {
                cur++;
            } else {
                max = Math.max(cur, max);
                cur = 0;
            }
        }
        max = Math.max(cur, max);
        return max;
    }
}