package peter;

/**
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 * 
 * @author ylkang Feb 5, 2015
 */
public class _004_Median_of_Two_Sorted_Arrays {

	public static double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length + B.length;
		if (m % 2 == 0) {
			int mid = findKth(A, B, 0, 0, m / 2)
					+ findKth(A, B, 0, 0, m / 2 + 1);
			return mid / 2.0;
		} else {
			return findKth(A, B, 0, 0, (m + 1) / 2);
		}
	}

	private static int findKth(int[] A, int[] B, int aOffset, int bOffset, int k) {
		if (A.length == aOffset)
			return B[bOffset + k - 1];
		if (B.length == bOffset)
			return A[aOffset + k - 1];
		if (k == 1)
			return Math.min(A[aOffset], B[bOffset]);

		int cut = min(A.length - aOffset - 1, B.length - bOffset - 1, k / 2 - 1);
		if (A[aOffset + cut] < B[bOffset + cut]) {
			aOffset = aOffset + cut + 1;
		} else {
			bOffset = bOffset + cut + 1;
		}
		k = k - cut - 1;

		return findKth(A, B, aOffset, bOffset, k);
	}

	private static int min(int a, int b, int c) {
		if (a < b) {
			return a < c ? a : c;
		} else {
			return b < c ? b : c;
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] B = { 1, 4, 9, 9, 11, 11, 22, 33 };
		System.out.println(findMedianSortedArrays(A, B));
	}
}