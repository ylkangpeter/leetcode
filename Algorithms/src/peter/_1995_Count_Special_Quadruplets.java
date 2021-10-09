/**
 * project info: leetcode-peter
 */

package peter;

/**
 * Given a 0-indexed integer array nums, return the number of distinct quadruplets (a, b, c, d) such that:
 * <p>
 * nums[a] + nums[b] + nums[c] == nums[d], and
 * a < b < c < d
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,6]
 * Output: 1
 * Explanation: The only quadruplet that satisfies the requirement is (0, 1, 2, 3) because 1 + 2 + 3 == 6.
 * Example 2:
 * <p>
 * Input: nums = [3,3,6,4,5]
 * Output: 0
 * Explanation: There are no such quadruplets in [3,3,6,4,5].
 * Example 3:
 * <p>
 * Input: nums = [1,1,1,3,5]
 * Output: 4
 * Explanation: The 4 quadruplets that satisfy the requirement are:
 * - (0, 1, 2, 3): 1 + 1 + 1 == 3
 * - (0, 1, 3, 4): 1 + 1 + 3 == 5
 * - (0, 2, 3, 4): 1 + 1 + 3 == 5
 * - (1, 2, 3, 4): 1 + 1 + 3 == 5
 *  
 * <p>
 * Constraints:
 * <p>
 * 4 <= nums.length <= 50
 * 1 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-special-quadruplets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1995_Count_Special_Quadruplets {

    public int countQuadruplets(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int n = k + 1; n < nums.length; n++) {
                        if (nums[i] + nums[j] + nums[k] == nums[n]) {
                            counter++;
                        }
                    }
                }
            }
        }
        return counter;

    }
}
