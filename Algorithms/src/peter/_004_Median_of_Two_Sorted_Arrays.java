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
		int startA = 0;
		int endA = A.length - 1;

		int startB = 0;
		int endB = B.length - 1;

		int targetInx = (endB + endA) >>> 1;
		int offset = 0;

		while (offset < targetInx) {
			int midA = (startA + endA) >>> 1;
			int midB = (startB + endB) >>> 1;

			if (A[midA] == B[midB]) {
				while (offset < targetInx) {
					if (A[midA] >= B[midB]) {
						midA++;
					} else {
						midB++;
					}
					offset++;
				}
			} else if (A[midA] < B[midB]) {
				offset = midA + startB;
				startA = midA + 1;
				endB = midB - 1;
			} else {
				offset = midB + startA;
				startB = midB + 1;
				endA = midA - 1 > startA ? midA - 1 : startA;
			}

		}

		if (startA == endA) {

		}
		return 0;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] B = { 1, 4, 9, 9, 11, 11, 22, 33 };
		System.out.println(findMedianSortedArrays(A, B));
	}
}