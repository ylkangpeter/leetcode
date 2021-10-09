/**
 * project info: leetcode-peter
 */

package peter;

/**
 * Given an array of strings patterns and a string word, return the number of strings in patterns that exist as a
 * substring in word.
 * <p>
 * A substring is a contiguous sequence of characters within a string.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: patterns = ["a","abc","bc","d"], word = "abc"
 * Output: 3
 * Explanation:
 * - "a" appears as a substring in "abc".
 * - "abc" appears as a substring in "abc".
 * - "bc" appears as a substring in "abc".
 * - "d" does not appear as a substring in "abc".
 * 3 of the strings in patterns appear as a substring in word.
 * Example 2:
 * <p>
 * Input: patterns = ["a","b","c"], word = "aaaaabbbbb"
 * Output: 2
 * Explanation:
 * - "a" appears as a substring in "aaaaabbbbb".
 * - "b" appears as a substring in "aaaaabbbbb".
 * - "c" does not appear as a substring in "aaaaabbbbb".
 * 2 of the strings in patterns appear as a substring in word.
 * Example 3:
 * <p>
 * Input: patterns = ["a","a","a"], word = "ab"
 * Output: 3
 * Explanation: Each of the patterns appears as a substring in word "ab".
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= patterns.length <= 100
 * 1 <= patterns[i].length <= 100
 * 1 <= word.length <= 100
 * patterns[i] and word consist of lowercase English letters.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-strings-that-appear-as-substrings-in-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1967_Number_of_Strings_That_Appear_as_Substrings_in_Word {

    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (int i = 0; i < patterns.length; i++) {
            if (word.contains(patterns[i])) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new _1967_Number_of_Strings_That_Appear_as_Substrings_in_Word().numOfStrings(new String[]{"dojsf", "v",
                "hetnovaoigv",
                "ksvqfdojsf",
                "hetnovaoig", "yskjs", "sfr", "msurztkvppptsluk",
                "ndxffbkkvejuakduhdcfsdbgbt", "znhdgtwzbnh", "h", "ocaualfiscmbpnfalypmtdppymw", "w", "o", "sfjksvqfdo",
                "odqvzuc", "bozawheajcmlewptgssueylcxhx", "bno", "jhmarzsphxduvdktzqjiz", "j", "sfrjhetnov", "vxv",
                "ksvqfd",
                "ognwvqtadalmav", "yqbspvfwmvhycmghabigl", "qyfaiazgdqaw", "ojsfrj", "ojsfrjhetn", "fdojs", "do",
                "ovaoig", "k", "vrh", "jsfrjhetnovaoigvgk"}, "csfjksvqfdojsfrjhetnovaoigvgk");

    }
}
