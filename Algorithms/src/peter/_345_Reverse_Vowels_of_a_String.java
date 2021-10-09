/**
 * project info: leetcode-peter
 */

package peter;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 * <p>
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: s = "hello"
 * Output: "holle"
 * Example 2:
 * <p>
 * Input: s = "leetcode"
 * Output: "leotcede"
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 3 * 105
 * s consist of printable ASCII characters.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _345_Reverse_Vowels_of_a_String {

    public String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (!isVowel(s.charAt(start))) {
                start++;
            } else if (!isVowel(s.charAt(end))) {
                end--;
            } else {
                s = s.substring(0, start) + s.charAt(end) + s.substring(start + 1, end) + s.charAt(start) + s.substring(end + 1);
                start++;
                end--;
            }
        }
        return s;
    }

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        new _345_Reverse_Vowels_of_a_String().reverseVowels("aA");
    }
}
