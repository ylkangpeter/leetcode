/**
 * project info: leetcode-peter
 */

package peter;

/**
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 * <p>
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
 * You must also not convert the inputs to integers directly.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 * Example 2:
 * <p>
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 * Example 3:
 * <p>
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= num1.length, num2.length <= 104
 * num1 and num2 consist of only digits.
 * num1 and num2 don't have any leading zeros except for the zero itself.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _415_Add_Strings {

    public String addStrings(String num1, String num2) {
        return num1.length() > num2.length() ? add(num1, num2) : add(num2, num1);
    }

    public String add(String l, String s) {
        int[] value = new int[l.length()];
        for (int i = 0; i < s.length(); i++) {
            value[i] = l.charAt(l.length() - 1 - i) + s.charAt(s.length() - 1 - i) - 96;
        }
        for (int i = s.length(); i < l.length(); i++) {
            value[i] = l.charAt(l.length() - 1 - i) - 48;
        }

        StringBuffer sb = new StringBuffer();
        int addUp = 0;
        for (int i = 0; i < value.length; i++) {
            int v = addUp + value[i];
            addUp = v / 10;
            int left = v % 10;
            sb.append(left);
        }
        if (addUp > 0) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println('0' - 0);
        System.out.println('9' - 0);
        new _415_Add_Strings().addStrings("11", "123");
    }
}
