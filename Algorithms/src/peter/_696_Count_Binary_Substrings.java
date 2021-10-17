package peter;

/**
 * 给定一个字符串?s，计算具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是连续的。
 * <p>
 * 重复出现的子串要计算它们出现的次数。
 * <p>
 * ?
 * <p>
 * 示例 1 :
 * <p>
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 * <p>
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * <p>
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 * <p>
 * <p>
 * 示例 2 :
 * <p>
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * s.length?在1到50,000之间。
 * s?只包含“0”或“1”字符。
 * <p>
 * https://leetcode-cn.com/problems/count-binary-substrings
 */
public class _696_Count_Binary_Substrings {

    public int countBinarySubstrings(String s) {
        int last = 0, cur = 0;
        int total = 0;
        char preChar = ' ';
        for (char c : s.toCharArray()) {
            if (c == preChar) {
                cur++;
            } else {
                preChar = c;
                last = cur;
                cur = 1;
            }
            if (cur <= last) {
                total++;
            }
        }
        return total;
    }
}