package peter;

import java.util.LinkedList;
import java.util.List;

/**
 * 自除数?是指可以被它包含的每一位数除尽的数。
 * <p>
 * 例如，128 是一个自除数，因为?128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * <p>
 * 还有，自除数不允许包含 0 。
 * <p>
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * <p>
 * <p>
 * 注意：
 * <p>
 * <p>
 * 每个输入参数的边界满足?1 <= left <= right <= 10000。
 * <p>
 * https://leetcode-cn.com/problems/self-dividing-numbers
 */
public class _728_Self_Dividing_Numbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            int v = i;
            boolean isOK = true;
            while (v != 0) {
                if (v % 10 == 0 || i % (v % 10) != 0) {
                    isOK = false;
                    break;
                }
                v = v / 10;
            }
            if (isOK) {
                list.add(i);
            }
        }
        return list;
    }
}