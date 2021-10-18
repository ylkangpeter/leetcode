package peter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 泰波那契序列?Tn?定义如下：?
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0?的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数?n，请返回第 n 个泰波那契数?Tn 的值。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即?answer <= 2^31 - 1。
 * <p>
 * https://leetcode-cn.com/problems/n-th-tribonacci-number
 */
public class _1137_Nth_Tribonacci_Number {

    Map<Integer, Integer> map = new HashMap<>();

    public int tribonacci(int n) {
        if (map.get(n) != null) {
            return map.get(n);
        }
        if (n == 0) {
            map.put(n, 0);
            return 0;
        } else if (n == 1) {
            map.put(n, 1);
            return 1;
        } else if (n == 2) {
            map.put(n, 1);
            return 1;
        } else {
            int v = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
            map.put(n, v);
            return v;
        }
    }
}