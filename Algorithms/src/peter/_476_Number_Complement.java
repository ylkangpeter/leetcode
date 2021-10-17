package peter;

/**
 * 给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。
 * <p>
 * ?
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 给定的整数 num 保证在 32 位带符号整数的范围内。
 * num >= 1
 * 你可以假定二进制数不包含前导零位。
 * 本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同
 * <p>
 * https://leetcode-cn.com/problems/number-complement
 */
public class _476_Number_Complement {

    public int findComplement(int num) {
        int result = 0;
        int round = 0;
        while (num != 0) {
            if ((num & 1) == 0) {
                result |= (1 << round);
            }
            round++;
            num >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        //1011000
        new _476_Number_Complement().findComplement(88);
    }
}