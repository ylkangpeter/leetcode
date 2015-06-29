package peter;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 * 
 * @author ylkang Jun 29, 2015
 */
public class _230_Majority_Element_II {

	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		int a = 0, b = 0, ac = 0, bc = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == a) {
				ac++;
			} else if (nums[i] == b) {
				bc++;
			} else {
				ac--;
				bc--;
			}
			if (ac < 0) {
				a = nums[i];
				ac = 1;
			} else if (bc < 0) {
				b = nums[i];
				bc = 1;
			}
		}
		ac = bc = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == a)
				ac++;
			if (nums[i] == b)
				bc++;
		}
		if (ac > nums.length / 3)
			result.add(a);
		if (bc > nums.length / 3 && b != a)
			result.add(b);
		return result;
	}
}
