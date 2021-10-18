package peter;

/**
 * 给你一个长度固定的整数数组?arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。
 * <p>
 * 要求：请对输入的数组?就地?进行上述修改，不要从函数返回任何东西。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 * <p>
 * https://leetcode-cn.com/problems/duplicate-zeros
 */
public class _1089_Duplicate_Zeros {

    public void duplicateZeros(int[] arr) {
        int[] result = new int[arr.length];
        int resultInx = 0;
        for (int i = 0; i < arr.length && resultInx < arr.length; i++) {
            if (arr[i] == 0) {
                result[resultInx] = 0;
                resultInx++;
                if (resultInx >= arr.length) {
                    break;
                }
                result[resultInx] = 0;
            } else {
                result[resultInx] = arr[i];
            }
            resultInx++;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }

    public static void main(String[] args) {
        new _1089_Duplicate_Zeros().duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
    }
}