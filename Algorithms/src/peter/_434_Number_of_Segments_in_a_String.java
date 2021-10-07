/**
 * project info: leetcode-peter
 */

package peter;

/**
 * You are given a string s, return the number of segments in the string. 
 * <p>
 * A segment is defined to be a contiguous sequence of non-space characters.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: s = "Hello, my name is John"
 * Output: 5
 * Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
 * Example 2:
 * <p>
 * Input: s = "Hello"
 * Output: 1
 * Example 3:
 * <p>
 * Input: s = "love live! mu'sic forever"
 * Output: 4
 * Example 4:
 * <p>
 * Input: s = ""
 * Output: 0
 *  
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 300
 * s consists of lower-case and upper-case English letters, digits or one of the following characters "!@#$%^&*()
 * _+-=',.:".
 * The only space character in s is ' '.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _434_Number_of_Segments_in_a_String {

    public int countSegments(String s) {
        if (s.trim().equals("")) {
            return 0;
        }
        int counter = 0;
        char preChar = '1';
        for (char c : s.trim().toCharArray()) {
            if (c == ' ' && preChar != ' ') {
                counter++;
            }
            preChar = c;
        }
        return counter + 1;
    }

}
