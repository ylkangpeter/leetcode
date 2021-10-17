package peter;

import java.util.LinkedList;
import java.util.List;

/**
 * 对于一个?正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * <p>
 * 给定一个?整数?n，?如果是完美数，返回 true，否则返回 false
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：28
 * 输出：True
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 * <p>
 * 示例 2：
 * <p>
 * 输入：num = 6
 * 输出：true
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：num = 496
 * 输出：true
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：num = 8128
 * 输出：true
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * 输入：num = 2
 * 输出：false
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= num <= 108
 * <p>
 * https://leetcode-cn.com/problems/perfect-number
 */
public class _507_Perfect_Number {

    public boolean checkPerfectNumber(int num) {
        switch (num) {
            case 6:
            case 28:
            case 496:
            case 8128:
            case 33550336:
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new _507_Perfect_Number().checkPerfectNumber(28);
    }
}