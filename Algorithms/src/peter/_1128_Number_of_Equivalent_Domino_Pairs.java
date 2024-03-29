package peter;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个由一些多米诺骨牌组成的列表?dominoes。
 * <p>
 * 如果其中某一张多米诺骨牌可以通过旋转 0?度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 * <p>
 * 形式上，dominoes[i] = [a, b]?和?dominoes[j] = [c, d]?等价的前提是?a==c?且?b==d，或是?a==d 且?b==c。
 * <p>
 * 在?0 <= i < j < dominoes.length?的前提下，找出满足?dominoes[i] 和?dominoes[j]?等价的骨牌对 (i, j) 的数量。
 * <p>
 * ?
 * <p>
 * 示例：
 * <p>
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 * <p>
 * https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
 */
public class _1128_Number_of_Equivalent_Domino_Pairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < dominoes.length; i++) {
            int a = dominoes[i][0];
            int b = dominoes[i][1];
            int v = a > b ? a * 10 + b : a + b * 10;
            int val = map.getOrDefault(v, 0);
            map.put(v, ++val);
        }

        int result = 0;
        for (int v : map.values()) {
            result += v * (v - 1) / 2;
        }
        return result;
    }
}