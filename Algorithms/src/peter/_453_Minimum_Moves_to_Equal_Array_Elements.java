/**
 * project info: leetcode-peter
 */

package peter;

/**
 * Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
 * <p>
 * In one move, you can increment n - 1 elements of the array by 1.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: 3
 * Explanation: Only three moves are needed (remember each move increments two elements):
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * Example 2:
 * <p>
 * Input: nums = [1,1,1]
 * Output: 0
 *  
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * The answer is guaranteed to fit in a 32-bit integer.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _453_Minimum_Moves_to_Equal_Array_Elements {

    public int minMoves(int[] nums) {
        int total = 0;
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
        }
        for (int i : nums) {
            total += (i - min);
        }
        return total;
    }

    public static void main(String[] args) {
        new _453_Minimum_Moves_to_Equal_Array_Elements().minMoves(new int[]{1, 2, 3});
    }
}
