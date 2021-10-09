/**
 * project info: leetcode-peter
 */

package peter;

/**
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number
 * of 1's in the binary representation of i.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *  
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 105
 *  
 * <p>
 * Follow up:
 * <p>
 * It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and
 * possibly in a single pass?
 * Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _338_Counting_Bits {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int tmp = i;
            int counter = 0;
            while (tmp > 0) {
                if ((tmp & 1) == 1) {
                    counter++;
                }
                tmp = tmp >> 1;
            }
            result[i] = counter;
        }
        return result;
    }

    public static void main(String[] args) {
        new _338_Counting_Bits().countBits(5);
    }
}
