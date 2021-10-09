/**
 * project info: leetcode-peter
 */

package peter;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the
 * range [1, n] that do not appear in nums.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * Example 2:
 * <p>
 * Input: nums = [1,1]
 * Output: [2]
 *  
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 *  
 * <p>
 * Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not
 * count as extra space.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _448_Find_All_Numbers_Disappeared_in_an_Array {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        new _448_Find_All_Numbers_Disappeared_in_an_Array().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }
}
