package peter;

/**
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10?或?11)来表示。
 * <p>
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 * <p>
 * 示例?1:
 * <p>
 * 输入:
 * bits = [1, 0, 0]
 * 输出: True
 * 解释:
 * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 * <p>
 * <p>
 * 示例?2:
 * <p>
 * 输入:
 * bits = [1, 1, 1, 0]
 * 输出: False
 * 解释:
 * 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
 * <p>
 * <p>
 * 注意:
 * <p>
 * <p>
 * 1 <= len(bits) <= 1000.
 * bits[i] 总是0 或?1.
 * <p>
 * https://leetcode-cn.com/problems/1-bit-and-2-bit-characters
 */
public class _717_1_bit_and_2_bit_Characters {

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length) {
            if (i == bits.length - 1) {
                if (bits[i] == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (bits[i] == 0) {
                    i++;
                    continue;
                } else {
                    i += 2;
                }
            }
        }
        return false;
    }
}