package peter;

import java.util.HashSet;

/**
 * Given an array of integers, find if the array contains any duplicates. Your
 * function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 * 
 * @author ylkang May 25, 2015
 */
public class _217_Contains_Duplicate {
	
	public boolean containsDuplicate(int[] nums) {
		if (nums.length == 0)
			return false;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return true;
			else {
				set.add(nums[i]);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new _217_Contains_Duplicate()
				.containsDuplicate(new int[] { 1, 2, 3, 4 }));
		System.out.println(new _217_Contains_Duplicate()
				.containsDuplicate(new int[] { 3, 3 }));
		System.out.println(new _217_Contains_Duplicate()
				.containsDuplicate(new int[] { 1, 2, 3, 1 }));
		System.out.println(new _217_Contains_Duplicate()
				.containsDuplicate(new int[] { 1, 2 }));
		System.out.println(new _217_Contains_Duplicate()
				.containsDuplicate(new int[] { 1, 1 }));
		System.out.println(new _217_Contains_Duplicate()
				.containsDuplicate(new int[] { 0 }));
	}
}
