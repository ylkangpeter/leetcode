package peter;

import java.util.Arrays;

/**
 * 请你帮忙给从 1 到 n?的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
 * <p>
 * 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
 * <p>
 * 由于答案可能会很大，所以请你返回答案 模 mod?10^9 + 7?之后的结果即可。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：12
 * 解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 100
 * 输出：682289015
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 100
 * <p>
 * https://leetcode-cn.com/problems/prime-arrangements
 */
public class _1175_Prime_Arrangements {

    int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

    public int numPrimeArrangements(int n) {
        int primeNums = Arrays.binarySearch(primes, n);
        if (primeNums < 0) {
            primeNums = -primeNums - 1;
        } else {
            primeNums++;
        }
        return (int) (arranges(n - primeNums) * arranges(primeNums) % 1000000007);
    }

    public long arranges(int bottom) {
        long result = 1;
        while (bottom >= 1) {
            result = (result * bottom) % 1000000007;
            bottom--;
        }
        return result;
    }

    public static void main(String[] args) {
        new _1175_Prime_Arrangements().numPrimeArrangements(100);
    }
}