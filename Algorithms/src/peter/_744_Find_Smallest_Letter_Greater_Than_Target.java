package peter;

/**
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母?target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * <p>
 * 在比较时，字母是依序循环出现的。举个例子：
 * <p>
 * <p>
 * 如果目标字母 target = 'z' 并且字符列表为?letters = ['a', 'b']，则答案返回?'a'
 * <p>
 * <p>
 * ?
 * <p>
 * 示例：
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "g"
 * 输出: "j"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "j"
 * 输出: "c"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * letters长度范围在[2, 10000]区间内。
 * letters 仅由小写字母组成，最少包含两个不同的字母。
 * 目标字母target 是一个小写字母。
 * <p>
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
 */
public class _744_Find_Smallest_Letter_Greater_Than_Target {

    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[letters.length - 1] <= target) {
            return letters[0];
        }
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int middle = (start + end) >>> 1;
            if (letters[middle] <= target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return letters[start];
    }
}