package peter;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, return true if and only if there
 * are two distinct indices i and j in the array such that nums[i] = nums[j] and
 * the difference between i and j is at most k.
 * 
 * @author ylkang May 29, 2015
 */

public class _219_Contains_Duplicate_II {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		// check to avoid nullpointexception
		if (nums == null) {
			return false;
		}
		Map<Integer, Integer> check = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (check.containsKey(nums[i])) {
				if (i - check.get(nums[i]) <= k) {
					return true;
				}
			}
			check.put(nums[i], i);
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new _219_Contains_Duplicate_II()
				.containsNearbyDuplicate(new int[] { 1, 2, 3, 4 }, 4));
		System.out.println(new _219_Contains_Duplicate_II()
				.containsNearbyDuplicate(new int[] { 1, 2, 3, 4, 4 }, 4));

		System.out.println(new _219_Contains_Duplicate_II()
				.containsNearbyDuplicate(new int[] { 1, 2, 3, 3, 4, 4 }, 3));
		System.out.println(new _219_Contains_Duplicate_II()
				.containsNearbyDuplicate(new int[] { 1, 2, 3, 4, 4 }, 1));
	}
}
