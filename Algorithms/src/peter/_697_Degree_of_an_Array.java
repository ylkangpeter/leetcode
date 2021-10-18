package peter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非空且只包含非负数的整数数组?nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是在 nums 中找到与?nums?拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * nums.length?在1到 50,000 区间范围内。
 * nums[i]?是一个在 0 到 49,999 范围内的整数。
 * <p>
 * https://leetcode-cn.com/problems/degree-of-an-array
 */
public class _697_Degree_of_an_Array {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> tmp = map.getOrDefault(nums[i], new ArrayList<>());
            tmp.add(i);
            map.put(nums[i], tmp);
        }

        int max = 0;
        List<Integer> maxList = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() > max) {
                maxList.clear();
                maxList.add(entry.getKey());
                max = entry.getValue().size();
            } else if (entry.getValue().size() == max) {
                maxList.add(entry.getKey());
            }
        }

        //
        int min = Integer.MAX_VALUE;
        for (int k : maxList) {
            List<Integer> vs = map.get(k);
            min = Math.min(vs.get(vs.size() - 1) - vs.get(0) + 1, min);
        }
        return min;
    }

    public static void main(String[] args) {
        new _697_Degree_of_an_Array().findShortestSubArray(new int[]{
                1, 2, 2, 3, 1});
    }
}