/**
 * project info: leetcode-peter
 */

package peter;

/**
 * You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the
 * ith row has exactly i coins. The last row of the staircase may be incomplete.
 * <p>
 * Given the integer n, return the number of complete rows of the staircase you will build.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 5
 * Output: 2
 * Explanation: Because the 3rd row is incomplete, we return 2.
 * Example 2:
 * <p>
 * <p>
 * Input: n = 8
 * Output: 3
 * Explanation: Because the 4th row is incomplete, we return 3.
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arranging-coins
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _441_Arranging_Coins {
    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(2.0 * n + 0.25) - 0.5);
    }

    public static void main(String[] args) {

        System.out.println(Math.pow(2, 16));
    }
}
