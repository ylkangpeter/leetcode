package peter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个数组，arr1 和?arr2，
 * <p>
 * <p>
 * arr2?中的元素各不相同
 * arr2 中的每个元素都出现在?arr1?中
 * <p>
 * <p>
 * 对 arr1?中的元素进行排序，使 arr1 中项的相对顺序和?arr2?中的相对顺序相同。未在?arr2?中出现过的元素需要按照升序放在?arr1?的末尾。
 * <p>
 * ?
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2?中的元素?arr2[i]?各不相同
 * arr2 中的每个元素?arr2[i]?都出现在?arr1?中
 * <p>
 * https://leetcode-cn.com/problems/relative-sort-array
 */
public class _1122_Relative_Sort_Array {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        Integer[] arr = new Integer[arr1.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr1[i];
        }
        Arrays.sort(arr, (Comparator) (o1, o2) -> {
            Integer v1 = map.get(o1);
            Integer v2 = map.get(o2);
            if (v1 == null && v2 == null) {
                return ((Integer) o1).compareTo((Integer) o2);
            } else if (v1 == null) {
                return 1;
            } else if (v2 == null) {
                return -1;
            } else {
                return v1.compareTo(v2);
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }
        return arr1;
    }
}