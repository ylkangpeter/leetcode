/**
 * project info: leetcode-peter
 */

package peter;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * <p>
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *  
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.
 *  
 * <p>
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by
 * one to see if t has its subsequence. In this scenario, how would you change your code?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _392_Is_Subsequence {

    public boolean isSubsequence(String s, String t) {
        int s_start = 0;
        int t_start = 0;
        while (t_start != t.length()) {
            if (s_start == s.length()) {
                return true;
            } else {
                if (s.charAt(s_start) == t.charAt(t_start)) {
                    s_start++;
                    t_start++;
                } else {
                    t_start++;
                }
            }
        }
        if (s_start == s.length()) {
            return true;
        }
        return false;
    }
}
