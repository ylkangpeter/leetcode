/**
 * project info: leetcode-peter
 */

package peter;

/**
 * You are given a string s consisting of n characters which are either 'X' or 'O'.
 * <p>
 * A move is defined as selecting three consecutive characters of s and converting them to 'O'. Note that if a move
 * is applied to the character 'O', it will stay the same.
 * <p>
 * Return the minimum number of moves required so that all the characters of s are converted to 'O'.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: s = "XXX"
 * Output: 1
 * Explanation: XXX -> OOO
 * We select all the 3 characters and convert them in one move.
 * Example 2:
 * <p>
 * Input: s = "XXOX"
 * Output: 2
 * Explanation: XXOX -> OOOX -> OOOO
 * We select the first 3 characters in the first move, and convert them to 'O'.
 * Then we select the last 3 characters and convert them so that the final string contains all 'O's.
 * Example 3:
 * <p>
 * Input: s = "OOOO"
 * Output: 0
 * Explanation: There are no 'X's in s to convert.
 *  
 * <p>
 * Constraints:
 * <p>
 * 3 <= s.length <= 1000
 * s[i] is either 'X' or 'O'.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-convert-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class _2027_Minimum_Moves_to_Convert_String {

    public int minimumMoves(String s) {
        int counter = 0;

        int start = s.indexOf('X');
        while (start >= 0) {
            counter++;
            start = s.indexOf('X', start + 3);
        }

        return counter;
    }

    public static void main(String[] args) {
        new _2027_Minimum_Moves_to_Convert_String().minimumMoves("XXXOOXXX");
    }
}
