package peter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个整数数组?arr，请你帮忙统计数组中每个数的出现次数。
 * <p>
 * 如果每个数的出现次数都是独一无二的，就返回?true；否则返回 false。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [1,2]
 * 输出：false
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr.length?<= 1000
 * -1000 <= arr[i] <= 1000
 * <p>
 * https://leetcode-cn.com/problems/unique-number-of-occurrences
 */
public class _1207_Unique_Number_of_Occurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            int v = map.getOrDefault(a, 0);
            map.put(a, ++v);
        }
        Set<Integer> set = new HashSet<>();
        for (int v : map.values()) {
            set.add(v);
        }
        return set.size() == map.size();
    }
}