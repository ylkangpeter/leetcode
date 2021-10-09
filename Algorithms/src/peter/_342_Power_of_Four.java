/**
 * project info: leetcode-peter
 */

package peter;

/**
 * Given an integer n, return true if it is a power of four. Otherwise, return false.
 * <p>
 * An integer n is a power of four, if there exists an integer x such that n == 4x.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: n = 16
 * Output: true
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: false
 * Example 3:
 * <p>
 * Input: n = 1
 * Output: true
 *  
 * <p>
 * Constraints:
 * <p>
 * -231 <= n <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _342_Power_of_Four {
    public boolean isPowerOfFour(int n) {
        int counter = 0;
        while (n > 0) {
            if ((n & 1) == 0) {
                counter++;
                n = n >> 1;
            } else {
                break;
            }
        }
        return counter > 0 && counter % 2 == 0;
    }

    public static void main(String[] args) {
        new _342_Power_of_Four().isPowerOfFour(12);
    }
}
