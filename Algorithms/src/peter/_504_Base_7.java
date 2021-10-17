package peter;

/**
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 * <p>
 * ?
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = 100
 * 输出: "202"
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: num = -7
 * 输出: "-10"
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * -107?<= num <= 107
 * <p>
 * https://leetcode-cn.com/problems/base-7
 */
public class _504_Base_7 {

    public String convertToBase7(int num) {

//
//        return Integer.toString(num, 7);
        boolean neg = false;
        if (num < 0) {
            neg = true;
            num = -num;
        } else if (num == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        while (num > 0) {
            sb.insert(0, num % 7);
            num /= 7;
        }
        return neg ? "-" + sb.toString() : sb.toString();
    }
}