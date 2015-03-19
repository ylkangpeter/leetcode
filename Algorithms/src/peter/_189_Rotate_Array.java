package peter;

import java.util.Arrays;

/**
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 * 
 * Note: Try to come up as many solutions as you can, there are at least 3
 * different ways to solve this problem.
 * 
 * [show hint]
 * 
 * Hint: Could you do it in-place with O(1) extra space? Credits: Special thanks
 * to @Freezen for adding this problem and creating all test cases.
 * 
 * @author ylkang Feb 25, 2015
 */
public class _189_Rotate_Array {

	public static void rotate_1(int[] nums, int k) {
		if (k % nums.length == 0) {
			return;
		}

		k = k % nums.length;

		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);

	}

	private static void reverse(int[] nums, int start, int end) {
		for (int i = start; i <= (start + end) / 2; i++) {
			int tmp = nums[i];
			nums[i] = nums[end - i + start];
			nums[end - i + start] = tmp;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		rotate_1(nums, 1);
		System.out.println(Arrays.toString(nums));
		nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		rotate_1(nums, 2);
		System.out.println(Arrays.toString(nums));
		nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		rotate_1(nums, 3);
		System.out.println(Arrays.toString(nums));
		nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		rotate_1(nums, 4);
		System.out.println(Arrays.toString(nums));
		nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		rotate_1(nums, 5);
		System.out.println(Arrays.toString(nums));
		nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		rotate_1(nums, 6);
		System.out.println(Arrays.toString(nums));
		nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		rotate_1(nums, 7);
		System.out.println(Arrays.toString(nums));
		nums = new int[] { 1 };
		rotate_1(nums, 1);
		System.out.println(Arrays.toString(nums));

	}
}
