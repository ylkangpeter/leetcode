package peter;

import java.util.Arrays;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * @author ylkang Feb 12, 2015
 */
public class _034_Search_for_a_Range {

	public static int[] searchRange(int[] A, int target) {
		if (A == null) {
			return new int[] { -1, -1 };
		}
		int inx = Arrays.binarySearch(A, target);
		if (inx < 0) {
			return new int[] { -1, -1 };
		}

		int start = inx;
		int end = inx;
		while (A[start] == target && start >= 0) {
			start--;
		}
		start++;
		while (A[end] == target && end < A.length) {
			end++;
		}
		end--;
		return new int[] { start, end };
	}

	public static void main(String[] args) {
		System.out.println(searchRange(new int[] { 8 }, 8));
	}
}