package peter;

/**
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：false
 * 解释：7 的二进制表示是：111.
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 11
 * 输出：false
 * 解释：11 的二进制表示是：1011.
 * <p>
 * 示例 4：
 * <p>
 * 输入：n = 10
 * 输出：true
 * 解释：10 的二进制表示是：1010.
 * <p>
 * 示例 5：
 * <p>
 * 输入：n = 3
 * 输出：false
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 231 - 1
 * <p>
 * https://leetcode-cn.com/problems/binary-number-with-alternating-bits
 */
public class _693_Binary_Number_with_Alternating_Bits {

    public boolean hasAlternatingBits(int n) {
        long v = n;
        return ((v << 2) + 2) == v || ((v << 2) + 1) == v;
    }

    public static void main(String[] args) {
        new _693_Binary_Number_with_Alternating_Bits().hasAlternatingBits(5);
    }
}