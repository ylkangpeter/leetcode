package peter;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * @author ylkang Feb 11, 2015
 */
public class _041_First_Missing_Positive {

	public static int firstMissingPositive(int[] A) {

		if (A == null || A.length == 0) {
			return 1;
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] < A.length && A[i] > 0) {
				if (A[i] - 1 == i) {
					continue;
				}
				Set<Integer> s = new HashSet<Integer>();
				int inx = A[i];
				while (!s.contains(inx) && inx > 0 && inx <= A.length) {
					s.add(inx);
					int tmp = A[inx - 1];
					A[inx - 1] = inx;
					inx = tmp;
				}
			}
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] <= 0) {
				return i + 1;
			} else if (A[i] - 1 != i) {
				return i + 1;
			}
		}
		return A.length + 1;
	}

	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[] { 2, 1 }));
	}
}