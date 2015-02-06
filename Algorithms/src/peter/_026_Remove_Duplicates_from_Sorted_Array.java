package peter;

public class _026_Remove_Duplicates_from_Sorted_Array {

	public int removeDuplicates(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}

		int inx = 1;

		for (int i = 1; i < A.length; i++) {
			if (A[i] == A[inx - 1]) {
				continue;
			}
			A[inx] = A[i];
			inx++;
		}
		return inx;

	}

}