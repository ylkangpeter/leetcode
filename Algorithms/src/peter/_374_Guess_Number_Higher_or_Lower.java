/**
 * project info: leetcode-peter
 */

package peter;

/**
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 * <p>
 * You call a pre-defined API int guess(int num), which returns 3 possible results:
 * <p>
 * -1: The number I picked is lower than your guess (i.e. pick < num).
 * 1: The number I picked is higher than your guess (i.e. pick > num).
 * 0: The number I picked is equal to your guess (i.e. pick == num).
 * Return the number that I picked.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: n = 10, pick = 6
 * Output: 6
 * Example 2:
 * <p>
 * Input: n = 1, pick = 1
 * Output: 1
 * Example 3:
 * <p>
 * Input: n = 2, pick = 1
 * Output: 1
 * Example 4:
 * <p>
 * Input: n = 2, pick = 2
 * Output: 2
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 231 - 1
 * 1 <= pick <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _374_Guess_Number_Higher_or_Lower {

    public int guess(int n) {
        return n;
    }

    public int guessNumber(int n) {
        int max = n;
        int min = 0;
        while (true) {
            n = (max + min) >>> 1;
            int v = guess(n);
            if (v == 0) {
                return n;
            } else if (v > 0) {
                min = n + 1;
            } else {
                max = n - 1;
            }
        }
    }
}
