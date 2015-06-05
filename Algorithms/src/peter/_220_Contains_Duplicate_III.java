package peter;

import java.util.LinkedHashMap;

/**
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the difference between nums[i] and nums[j] is at
 * most t and the difference between i and j is at most k.
 * 
 * @author ylkang Jun 1, 2015
 */

public class _220_Contains_Duplicate_III {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		if (nums == null || nums.length == 0 || k == 0 || t < 0) {
			return false;
		}
		t = Math.abs(t);
		k = Math.abs(k);

		final int SIZE = k;
		@SuppressWarnings("serial")
		LinkedHashMap<Long, Long> map = new LinkedHashMap<Long, Long>(SIZE) {
			@Override
			protected boolean removeEldestEntry(
					java.util.Map.Entry<Long, Long> eldest) {
				if (size() > SIZE) {
					return true;
				}
				return false;
			}
		};
		for (int i = 0; i < nums.length; i++) {
			long j = t == 0 ? nums[i] : nums[i] / t;
			if (map.get(j) != null
					|| (map.get(j - 1) != null && Math.abs(map.get(j - 1)
							- nums[i]) <= t)
					|| (map.get(j + 1) != null && Math.abs(map.get(j + 1)
							- nums[i]) <= t)) {
				return true;
			}
			map.put(j, (long) nums[i]);
		}
		return false;

		// if (k < 1 || t < 0)
		// return false;

		// LinkedList<Long> window = new LinkedList<>();
		// Map<Long, Long> map = new HashMap<>();
		//
		// for (int i = 0; i < nums.length; i++) {
		// long j = t == 0 ? nums[i] : ((long) nums[i] / t);
		// if (map.containsKey(j)
		// || (map.containsKey(j - 1) && Math.abs(map.get(j - 1)
		// - nums[i]) <= t)
		// || (map.containsKey(j + 1) && Math.abs(map.get(j + 1)
		// - nums[i]) <= t))
		// return true;
		// map.put(j, (long) nums[i]);
		// if (window.size() == k)
		// map.remove(t == 0 ? window.pollFirst()
		// : (window.pollFirst() / t));
		// window.add((long) nums[i]);
		// }
		// return false;
	}

	public static void main(String[] args) {
		System.out.println(new _220_Contains_Duplicate_III()
				.containsNearbyAlmostDuplicate(new int[] { -1, -1 }, 1, -1));
		System.out.println(new _220_Contains_Duplicate_III()
				.containsNearbyAlmostDuplicate(new int[] { 1, 3, 5, 7 }, 3, 2));
	}
}
