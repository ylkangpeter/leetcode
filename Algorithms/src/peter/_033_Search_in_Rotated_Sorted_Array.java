package peter;

import java.util.Arrays;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author ylkang Feb 6, 2015
 */
public class _033_Search_in_Rotated_Sorted_Array {

	public static int search(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;

		if (A[start] < A[end]) {
			int inx = Arrays.binarySearch(A, target);
			if (inx < 0) {
				return -1;
			} else {
				return inx;
			}
		}
		return search(A, target, start, end);
	}

	private static int search(int[] A, int target, int start, int end) {
		if (A[end] > A[start]) {
			int inx = Arrays.binarySearch(A, start, end, target);
			if (inx < 0) {
				return -1;
			} else {
				return inx;
			}
		}

		if (A[start] == target) {
			return start;
		} else if (A[end] == target) {
			return end;
		}

		int middle = (int) (((long) start + end) / 2);

		if (middle == start) {
			return -1;
		}

		if (A[start] == target) {
			return start;
		} else if (A[start] < target) {
			if (A[middle] > target) {
				return search(A, target, start, middle);
			} else if (A[middle] == target) {
				return middle;
			} else {
				if (A[middle] >= A[end]) {
					return search(A, target, middle, end);
				} else {
					return search(A, target, start, middle);
				}
			}
		} else {
			if (A[middle] == target) {
				return middle;
			} else if (A[middle] < target) {
				return search(A, target, middle, end);
			} else {
				if (A[end] >= A[middle]) {
					return search(A, target, start, middle);
				} else {
					return search(A, target, middle, end);
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 1));
	}
}