/**
 * project info: leetcode-peter
 */

package peter;

/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest
 * palindrome that can be built with those letters.
 * <p>
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * Example 2:
 * <p>
 * Input: s = "a"
 * Output: 1
 * Example 3:
 * <p>
 * Input: s = "bb"
 * Output: 2
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _409_Longest_Palindrome {

    public int longestPalindrome(String s) {
        int[] arr = new int[52];
        for (char c : s.toCharArray()) {
            if (c > 96) {
                arr[c - 71]++;
            } else {
                arr[c - 65]++;
            }
        }
        boolean isOdd = false;
        int result = 0;
        for (int i : arr) {
            if ((i % 2) != 0) {
                isOdd = true;
            }
            result += i / 2;
        }
        return isOdd ? result * 2 + 1 : result * 2;
    }

    public static void main(String[] args) {
        new _409_Longest_Palindrome().longestPalindrome("aA");
    }

}
