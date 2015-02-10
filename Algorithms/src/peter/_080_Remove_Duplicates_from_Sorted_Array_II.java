package peter;

/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * @author ylkang Feb 10, 2015
 */
public class _080_Remove_Duplicates_from_Sorted_Array_II {

	public static int removeDuplicates(int[] A) {
		if (A == null) {
			return 0;
		}
		if (A.length == 0 || A.length == 1) {
			return A.length;
		}

		int inx = 1;
		int pre = A[0];
		int counter = 1;

		for (int i = 1; i < A.length; i++) {
			if (A[i] == pre) {
				counter++;
				if (counter > 2) {
					continue;
				}
			} else {
				counter = 1;
				pre = A[i];
			}
			A[inx] = A[i];
			inx++;
		}
		return inx;
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] { 1, 2, 2, 2, 3, 3, 4 }));
	}
}