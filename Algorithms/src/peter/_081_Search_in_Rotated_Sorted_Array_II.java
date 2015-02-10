package peter;

import java.util.Arrays;

/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * @author ylkang Feb 10, 2015
 */
public class _081_Search_in_Rotated_Sorted_Array_II {

	public static boolean search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return false;
		}

		if (A[0] < A[A.length - 1]) {
			int inx = Arrays.binarySearch(A, target);
			return inx >= 0 ? true : false;
		}

		int start = 0;
		int end = A.length - 1;

		while (start <= end) {
			if (A[start] == target || A[end] == target) {
				return true;
			} else if (A[start] < target) {
				start++;
			} else {
				end--;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] { 1 }, 1));
		System.out.println(search(new int[] { 2, 2, 2, 2, 3, 4, 4, 4, 0, 0, 0,
				1, 1, 2, 2 }, 0));
		System.out.println(search(new int[] { 2, 2, 2, 2, 3, 4, 4, 4, 0, 0, 0,
				1, 1, 2, 2 }, 2));
	}
}