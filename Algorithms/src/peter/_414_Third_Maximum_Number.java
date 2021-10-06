/**
 * project info: leetcode-peter
 */

package peter;

import java.util.BitSet;

/**
 * Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not
 * exist, return the maximum number.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2.
 * The third distinct maximum is 1.
 * Example 2:
 * <p>
 * Input: nums = [1,2]
 * Output: 2
 * Explanation:
 * The first distinct maximum is 2.
 * The second distinct maximum is 1.
 * The third distinct maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * <p>
 * Input: nums = [2,2,3,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2 (both 2's are counted together since they have the same value).
 * The third distinct maximum is 1.
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *  
 * <p>
 * Follow up: Can you find an O(n) solution?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _414_Third_Maximum_Number {


    public int thirdMax(int[] nums) {
        long big = Long.MIN_VALUE;
        long middle = Long.MIN_VALUE;
        long small = Long.MIN_VALUE;

        for (int num : nums) {
            if (num > big) {
                small = middle;
                middle = big;
                big = num;
            } else if (num > middle && big > num) {
                small = middle;
                middle = num;
            } else if (num > small && middle > num) {
                small = num;
            }
        }
        if (small != Long.MIN_VALUE) {
            return (int) small;
        } else {
            return (int) big;
        }
    }

    public static void main(String[] args) {
        new _414_Third_Maximum_Number().thirdMax(new int[]{3, 2, 1});
    }
}
