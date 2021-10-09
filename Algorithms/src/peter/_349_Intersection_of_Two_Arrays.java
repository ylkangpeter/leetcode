/**
 * project info: leetcode-peter
 */

package peter;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be
 * unique and you may return the result in any order.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _349_Intersection_of_Two_Arrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums1) {
            set.add(n);
        }
        Set<Integer> list = new HashSet();
        for (int n : nums2) {
            if (set.contains(n)) {
                list.add(n);
            }
        }
        int[] result = new int[list.size()];
        Integer[] arr = list.toArray(new Integer[list.size()]);
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}
