/**
 * project info: leetcode-peter
 */

package peter;

/**
 * Given a 0-indexed integer array nums, find the leftmost middleIndex (i.e., the smallest amongst all the possible
 * ones).
 * <p>
 * A middleIndex is an index where nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] +
 * nums[middleIndex+2] + ... + nums[nums.length-1].
 * <p>
 * If middleIndex == 0, the left side sum is considered to be 0. Similarly, if middleIndex == nums.length - 1, the
 * right side sum is considered to be 0.
 * <p>
 * Return the leftmost middleIndex that satisfies the condition, or -1 if there is no such index.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,-1,8,4]
 * Output: 3
 * Explanation:
 * The sum of the numbers before index 3 is: 2 + 3 + -1 = 4
 * The sum of the numbers after index 3 is: 4 = 4
 * Example 2:
 * <p>
 * Input: nums = [1,-1,4]
 * Output: 2
 * Explanation:
 * The sum of the numbers before index 2 is: 1 + -1 = 0
 * The sum of the numbers after index 2 is: 0
 * Example 3:
 * <p>
 * Input: nums = [2,5]
 * Output: -1
 * Explanation:
 * There is no valid middleIndex.
 * Example 4:
 * <p>
 * Input: nums = [1]
 * Output: 0
 * Explantion:
 * The sum of the numbers before index 0 is: 0
 * The sum of the numbers after index 0 is: 0
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * -1000 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-middle-index-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1991_Find_the_Middle_Index_in_Array {

    public int findMiddleIndex(int[] nums) {

        long leftSum = 0;
        long rightSum = 0;

        int inx = 0;

        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }

        while (inx < nums.length - 1) {
            if (leftSum == rightSum) {
                return inx;
            } else {
                leftSum += nums[inx];
                rightSum -= nums[inx + 1];
                inx++;
            }
        }
        if (leftSum == rightSum) {
            return inx;
        }
        return -1;
    }

    public static void main(String[] args) {
        new _1991_Find_the_Middle_Index_in_Array().findMiddleIndex(new int[]{
                1, -1, 4});
    }
}
