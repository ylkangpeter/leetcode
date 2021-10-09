/**
 * project info: leetcode-peter
 */

package peter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return the number of pairs (i, j) where i < j such that |nums[i] -
 * nums[j]| == k.
 * <p>
 * The value of |x| is defined as:
 * <p>
 * x if x >= 0.
 * -x if x < 0.
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,2,1], k = 1
 * Output: 4
 * Explanation: The pairs with an absolute difference of 1 are:
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * Example 2:
 * <p>
 * Input: nums = [1,3], k = 3
 * Output: 0
 * Explanation: There are no pairs with an absolute difference of 3.
 * Example 3:
 * <p>
 * Input: nums = [3,2,1,5,4], k = 2
 * Output: 3
 * Explanation: The pairs with an absolute difference of 2 are:
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * 1 <= k <= 99
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-pairs-with-absolute-difference-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _2006_Count_Number_of_Pairs_With_Absolute_Difference_K {

    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        int counter = 0;
        for (int num : map.keySet()) {
            int _1_num = map.get(num);
            Integer _2_num = map.get(num + k);
            if (_2_num != null) {
                counter += _1_num * _2_num;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        new _2006_Count_Number_of_Pairs_With_Absolute_Difference_K().countKDifference(new int[]{1, 2, 2, 1}, 1);
    }
}
