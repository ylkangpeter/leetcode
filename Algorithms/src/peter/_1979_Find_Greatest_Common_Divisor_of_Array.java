/**
 * project info: leetcode-peter
 */

package peter;

/**
 * Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.
 * <p>
 * The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,6,9,10]
 * Output: 2
 * Explanation:
 * The smallest number in nums is 2.
 * The largest number in nums is 10.
 * The greatest common divisor of 2 and 10 is 2.
 * Example 2:
 * <p>
 * Input: nums = [7,5,6,8,3]
 * Output: 1
 * Explanation:
 * The smallest number in nums is 3.
 * The largest number in nums is 8.
 * The greatest common divisor of 3 and 8 is 1.
 * Example 3:
 * <p>
 * Input: nums = [3,3]
 * Output: 3
 * Explanation:
 * The smallest number in nums is 3.
 * The largest number in nums is 3.
 * The greatest common divisor of 3 and 3 is 3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-greatest-common-divisor-of-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1979_Find_Greatest_Common_Divisor_of_Array {

    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return gcdByEuclidsAlgorithm(min, max);
    }

    private static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
}
