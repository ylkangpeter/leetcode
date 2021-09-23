/**
 * project info: leetcode-peter
 */

package peter;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 * <p>
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: n = 27
 * Output: true
 * Example 2:
 * <p>
 * Input: n = 0
 * Output: false
 * Example 3:
 * <p>
 * Input: n = 9
 * Output: true
 * Example 4:
 * <p>
 * Input: n = 45
 * Output: false
 *  
 * <p>
 * Constraints:
 * <p>
 * -231 <= n <= 231 - 1
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _326_Power_of_Three {
    Set<Integer> set = new HashSet<>();

    {
        set.add(1);
        set.add(3);
        set.add(9);
        set.add(27);
        set.add(81);
        set.add(243);
        set.add(729);
        set.add(2187);
        set.add(6561);
        set.add(19683);
        set.add(59049);
        set.add(177147);
        set.add(531441);
        set.add(1594323);
        set.add(4782969);
        set.add(14348907);
        set.add(43046721);
        set.add(129140163);
        set.add(387420489);
        set.add(1162261467);
    }

    public boolean isPowerOfThree(int n) {

        return set.contains(n);
    }
}
