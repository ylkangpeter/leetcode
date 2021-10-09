/**
 * project info: leetcode-peter
 */

package peter;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 * <p>
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 * <p>
 * Input: s = "aabb"
 * Output: -1
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _387_First_Unique_Character_in_a_String {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        int[] inx = new int[26];

        for (int i = 0; i < arr.length; i++) {
            inx[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 97] == 0) {
                arr[s.charAt(i) - 97] = 1;
                inx[s.charAt(i) - 97] = i;
            } else {
                inx[s.charAt(i) - 97] = -1;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < inx.length; i++) {
            if (inx[i] >= 0) {
                min = min > inx[i] ? inx[i] : min;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        } else {
            return min;
        }
    }

    public static void main(String[] args) {
        new _387_First_Unique_Character_in_a_String().firstUniqChar("leetcode");
    }
}
