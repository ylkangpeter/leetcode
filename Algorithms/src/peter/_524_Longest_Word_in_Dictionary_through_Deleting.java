/**
 * project info: leetcode-peter
 */

package peter;

import java.util.*;

/**
 * Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by
 * deleting some of the given string characters. If there is more than one possible result, return the longest word
 * with the smallest lexicographical order. If there is no possible result, return the empty string.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * Output: "apple"
 * Example 2:
 * <p>
 * Input: s = "abpcplea", dictionary = ["a","b","c"]
 * Output: "a"
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s and dictionary[i] consist of lowercase English letters.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _524_Longest_Word_in_Dictionary_through_Deleting {

    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, (o1, o2) -> {
            if (o1.length() > o2.length()) {
                return -1;
            } else if (o1.length() < o2.length()) {
                return 1;
            } else {
                return o1.compareTo(o2);
            }
        });

        for (String string : dictionary) {
            if (matches(s, string)) {
                return string;
            }
        }
        return "";
    }

    private boolean matches(String tile, String string) {
        int wordInx = 0;
        int tileInx = 0;

        while (tileInx < tile.length() && wordInx < string.length()) {
            if (tile.charAt(tileInx) == string.charAt(wordInx)) {
                wordInx++;
                tileInx++;
            } else {
                wordInx++;
            }
        }

        if (wordInx == string.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        String[] arr = new String[]);
        List<String> list = Arrays.asList(new String[]{"ale", "apple", "monkey", "plea"});
        new _524_Longest_Word_in_Dictionary_through_Deleting().findLongestWord("abpcplea", list);

    }
}
