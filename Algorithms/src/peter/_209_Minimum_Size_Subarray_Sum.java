package peter;

/**
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a subarray of which the sum ≥ s. If there isn't one, return
 * 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has
 * the minimal length under the problem constraint.
 * 
 * click to show more practice.
 * 
 * More practice: If you have figured out the O(n) solution, try coding another
 * solution of which the time complexity is O(n log n).
 * 
 * @author ylkang May 12, 2015
 */
public class _209_Minimum_Size_Subarray_Sum {

	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int startInx = 0;
		int length = Integer.MAX_VALUE;

		int total = 0;
		for (int i = 0; i < nums.length; i++) {
			total += nums[i];
			if (total >= s) {
				while (total >= s) {
					length = Math.min(length, i - startInx + 1);
					total -= nums[startInx];
					startInx++;
				}
			}
		}

		return length == Integer.MAX_VALUE ? 0 : length;
	}

	public static void main(String[] args) {

		System.out.println(new _209_Minimum_Size_Subarray_Sum().minSubArrayLen(
				7, new int[] { 2, 3, 1, 2, 4, 3 }));
		System.out.println(new _209_Minimum_Size_Subarray_Sum().minSubArrayLen(
				11, new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(new _209_Minimum_Size_Subarray_Sum().minSubArrayLen(
				17, new int[] { 2, 3, 1, 2, 4, 3, 7 }));
	}
}
