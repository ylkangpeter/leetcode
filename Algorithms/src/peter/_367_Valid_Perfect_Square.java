/**
 * project info: leetcode-peter
 */

package peter;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * <p>
 * Follow up: Do not use any built-in library function such as sqrt.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: num = 16
 * Output: true
 * Example 2:
 * <p>
 * Input: num = 14
 * Output: false
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= num <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _367_Valid_Perfect_Square {

    public boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }
        int left = 0;
        int right = num / 2;
        while (left <= right) {
            long mid = (left + right) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                right = (int) mid - 1;
            } else {
                left = (int) mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new _367_Valid_Perfect_Square().isPerfectSquare(808201);
    }
}
