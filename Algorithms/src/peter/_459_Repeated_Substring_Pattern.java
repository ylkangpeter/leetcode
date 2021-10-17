package peter;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abab"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: "aba"
 * <p>
 * 输出: False
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * 输入: "abcabcabcabc"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * <p>
 * https://leetcode-cn.com/problems/repeated-substring-pattern
 */
public class _459_Repeated_Substring_Pattern {

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i != 0) {
                continue;
            } else {
                int times = s.length() / i;
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < times; j++) {
                    sb.append(s.substring(0, i));
                }
                if (s.equals(sb.toString())) {
                    return true;
                }
            }
        }
        return false;
    }
}