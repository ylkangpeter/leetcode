/**
 * project info: leetcode-peter
 */

package peter;

/**
 * There is a special typewriter with lowercase English letters 'a' to 'z' arranged in a circle with a pointer. A
 * character can only be typed if the pointer is pointing to that character. The pointer is initially pointing to the
 * character 'a'.
 * <p>
 * <p>
 * Each second, you may perform one of the following operations:
 * <p>
 * Move the pointer one character counterclockwise or clockwise.
 * Type the character the pointer is currently on.
 * Given a string word, return the minimum number of seconds to type out the characters in word.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: word = "abc"
 * Output: 5
 * Explanation:
 * The characters are printed as follows:
 * - Type the character 'a' in 1 second since the pointer is initially on 'a'.
 * - Move the pointer clockwise to 'b' in 1 second.
 * - Type the character 'b' in 1 second.
 * - Move the pointer clockwise to 'c' in 1 second.
 * - Type the character 'c' in 1 second.
 * Example 2:
 * <p>
 * Input: word = "bza"
 * Output: 7
 * Explanation:
 * The characters are printed as follows:
 * - Move the pointer clockwise to 'b' in 1 second.
 * - Type the character 'b' in 1 second.
 * - Move the pointer counterclockwise to 'z' in 2 seconds.
 * - Type the character 'z' in 1 second.
 * - Move the pointer clockwise to 'a' in 1 second.
 * - Type the character 'a' in 1 second.
 * Example 3:
 * <p>
 * Input: word = "zjpc"
 * Output: 34
 * Explanation:
 * The characters are printed as follows:
 * - Move the pointer counterclockwise to 'z' in 1 second.
 * - Type the character 'z' in 1 second.
 * - Move the pointer clockwise to 'j' in 10 seconds.
 * - Type the character 'j' in 1 second.
 * - Move the pointer clockwise to 'p' in 6 seconds.
 * - Type the character 'p' in 1 second.
 * - Move the pointer counterclockwise to 'c' in 13 seconds.
 * - Type the character 'c' in 1 second.
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= word.length <= 100
 * word consists of lowercase English letters.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-time-to-type-word-using-special-typewriter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1974_Minimum_Time_to_Type_Word_Using_Special_Typewriter {

    public int minTimeToType(String word) {
        char cur = 'a';
        int counter = 0;
        for (char c : word.toCharArray()) {
            if (cur == c) {
                counter++;
            } else {
                counter += Math.min(Math.abs(c - cur), 26 - Math.abs(c - cur));
                counter++;
                cur = c;
            }
        }
        return counter;
    }

}
