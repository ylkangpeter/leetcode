package peter;

/**
 * 给定一个非空字符串?s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * ?
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "aba"
 * 输出: true
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "abca"
 * 输出: true
 * 解释: 你可以删除c字符。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入: s = "abc"
 * 输出: false
 * <p>
 * ?
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 * <p>
 * https://leetcode-cn.com/problems/valid-palindrome-ii
 */
public class _680_Valid_Palindrome_II {

    public boolean validPalindrome(String s) {
        return validPalindrome(s, false, 0, s.length());
    }

    public boolean validPalindrome(String s, boolean isUsed, int start, int end) {
        int i = start, e = end;
        while (i < e) {
            if (s.charAt(i) != s.charAt(end - 1 - i + start)) {
                if (isUsed) {
                    return false;
                } else {
                    return validPalindrome(s, true, i + 1, e) ||
                            validPalindrome(s, true, i, e - 1);
                }
            }
            i++;
            e--;
        }
        return true;
    }

    public static void main(String[] args) {
        new _680_Valid_Palindrome_II().validPalindrome("abca");
    }
}