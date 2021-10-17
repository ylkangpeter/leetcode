package peter;

import java.util.*;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * <p>
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * <p>
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：最长的和谐子序列是 [3,2,2,2,3]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：2
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,1]
 * 输出：0
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -109 <= nums[i] <= 109
 * <p>
 * https://leetcode-cn.com/problems/longest-harmonious-subsequence
 */
public class _594_Longest_Harmonious_Subsequence {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int v = map.getOrDefault(num, 0);
            v++;
            map.put(num, v);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int max = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) == 1) {
                max = Math.max(max, map.get(list.get(i)) + map.get(list.get(i + 1)));
            }
        }
        return max;
    }
}