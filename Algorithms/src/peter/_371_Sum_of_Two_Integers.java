/**
 * project info: leetcode-peter
 */

package peter;

/**
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 * <p>
 * Input: a = 2, b = 3
 * Output: 5
 *  
 * <p>
 * Constraints:
 * <p>
 * -1000 <= a, b <= 1000
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _371_Sum_of_Two_Integers {

    public int getSum(int a, int b) {
        int sum = a ^ b;
        int carry = (a & b) << 1;
        while (carry != 0) {
            int a1 = sum;
            int b1 = carry;
            sum = a1 ^ b1;
            carry = (a1 & b1) << 1;
        }
        return sum;
    }
}
