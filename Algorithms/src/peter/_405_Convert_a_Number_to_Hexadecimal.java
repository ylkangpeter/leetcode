/**
 * project info: leetcode-peter
 */

package peter;

/**
 * Given an integer num, return a string representing its hexadecimal representation. For negative integers, two’s
 * complement method is used.
 * <p>
 * All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in
 * the answer except for the zero itself.
 * <p>
 * Note: You are not allowed to use any built-in library method to directly solve this problem.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: num = 26
 * Output: "1a"
 * Example 2:
 * <p>
 * Input: num = -1
 * Output: "ffffffff"
 *  
 * <p>
 * Constraints:
 * <p>
 * -231 <= num <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _405_Convert_a_Number_to_Hexadecimal {

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] hexs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuffer sb = new StringBuffer();
        while (num != 0) {
            sb.append(hexs[num & 0xf]);
            num = num >>> 4;
        }
        return sb.reverse().toString();
    }

}
