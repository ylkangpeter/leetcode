/**
 * project info: test-com
 */

package peter;

/**
 * There is only one character 'A' on the screen of a notepad. You can perform two operations on this notepad for
 * each step:
 * <p>
 * Copy All: You can copy all the characters present on the screen (a partial copy is not allowed).
 * Paste: You can paste the characters which are copied last time.
 * Given an integer n, return the minimum number of operations to get the character 'A' exactly n times on the screen.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: 3
 * Explanation: Intitally, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: 0
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/2-keys-keyboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _650_2_Keys_Keyboard {

    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }


}
