/**
 * project info: leetcode-peter
 */

package peter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must
 * appear as many times as it shows in both arrays and you may return the result in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 * <p>
 * Follow up:
 * <p>
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements
 * into the memory at once?
 */

public class _350_Intersection_of_Two_Arrays_II {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] smalls = nums1;
        int[] bigs = nums2;
        if (nums1.length > nums2.length) {
            smalls = nums2;
            bigs = nums1;
        }

        for (int num : smalls) {
            Integer v = map.get(num);
            if (v == null) {
                v = 0;
            }
            map.put(num, ++v);
        }

        LinkedList<Integer> result = new LinkedList<>();
        for (int num : bigs) {
            Integer v = map.get(num);
            if (v != null && v != 0) {
                result.add(num);
                map.put(num, --v);
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;

    }
}
