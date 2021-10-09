/**
 * project info: leetcode-peter
 */

package peter;

/**
 * You are given two strings s and t.
 * <p>
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 * <p>
 * Return the letter that was added to t.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcd", t = "abcde"
 * Output: "e"
 * Explanation: 'e' is the letter that was added.
 * Example 2:
 * <p>
 * Input: s = "", t = "y"
 * Output: "y"
 * Example 3:
 * <p>
 * Input: s = "a", t = "aa"
 * Output: "a"
 * Example 4:
 * <p>
 * Input: s = "ae", t = "aea"
 * Output: "a"
 *  
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s and t consist of lower-case English letters.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _389_Find_the_Difference {

    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 97]++;
        }
        for (char c : t.toCharArray()) {
            if (--arr[c - 97] < 0) {
                return c;
            }
        }
        return ' ';
    }
}
