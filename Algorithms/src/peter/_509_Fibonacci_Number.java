package peter;

/**
 * 斐波那契数，通常用?F(n) 表示，形成的序列称为 斐波那契数列 。该数列由?0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1)?= 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * <p>
 * <p>
 * 给你 n ，请计算 F(n) 。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= n <= 30
 * <p>
 * https://leetcode-cn.com/problems/fibonacci-number
 */
public class _509_Fibonacci_Number {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}