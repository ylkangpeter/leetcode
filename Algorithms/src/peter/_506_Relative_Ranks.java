package peter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给出?N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 * <p>
 * (注：分数越高的选手，排名越靠前。)
 * <p>
 * 示例 1:
 * <p>
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 * <p>
 * 提示:
 * <p>
 * <p>
 * N 是一个正整数并且不会超过?10000。
 * 所有运动员的成绩都不相同。
 * <p>
 * https://leetcode-cn.com/problems/relative-ranks
 */
public class _506_Relative_Ranks {

    public String[] findRelativeRanks(int[] score) {
        String[] res = new String[score.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }
        Arrays.sort(score);
        for (int j = score.length - 1; j >= 0; j--) {
            if (j == score.length - 1) {
                res[map.get(score[j])] = "Gold Medal";
            } else if (j == score.length - 2) {
                res[map.get(score[j])] = "Silver Medal";
            } else if (j == score.length - 3) {
                res[map.get(score[j])] = "Bronze Medal";
            } else {
                res[map.get(score[j])] = score.length - j - 2 + "";
            }
        }
        return res;
    }
}