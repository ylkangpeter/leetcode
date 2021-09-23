/**
 * project info: leetcode-peter
 */

package peter;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 * <p>
 * Return the maximum possible length of s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 * Example 2:
 * <p>
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * Example 3:
 * <p>
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lower case English letters.
 */
public class _1239_Maximum_Length_of_a_Concatenated_String_with_Unique_Characters {
    int max = 0;

    public int maxLength(List<String> arr) {
        List<Integer> bitSet = new ArrayList();
        for (String str : arr) {
            int v = 0;
            boolean isOk = true;
            for (char c : str.toCharArray()) {
                int val = 2 << (c - 'a');
                if ((v & val) == 0) {
                    v |= val;
                } else {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                bitSet.add(v);
            }
        }

        recursion(bitSet, 0, 0);
        return max;
    }

    // a, b, c, d makes abcd=4
    // a, ab,c,ad makes abc or acd =3
    private void recursion(List<Integer> bitSet, int inx, int currentMask) {
        if (inx == bitSet.size()) {
            max = Math.max(max, Integer.bitCount(currentMask));
        } else {
            if ((bitSet.get(inx) & currentMask) == 0) {
                recursion(bitSet, inx + 1, currentMask | bitSet.get(inx));
            }
            recursion(bitSet, inx + 1, currentMask);
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("yy");
        new _1239_Maximum_Length_of_a_Concatenated_String_with_Unique_Characters().maxLength(list);
    }
}
