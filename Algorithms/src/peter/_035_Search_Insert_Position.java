package peter;

public class _035_Search_Insert_Position {

	public int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0) {
			return 0;
		}

		if (A[0] >= target) {
			return 0;
		} else if (A[A.length - 1] < target) {
			return A.length;
		} else if (A[A.length - 1] == target) {
			return A.length - 1;
		}

		int start = 0;
		int end = A.length - 1;
		int middle = (end >> 1) + (start >> 1) + ((end & 1) & (start & 1));
		while (start < end - 1) {
			if (A[middle] == target) {
				return middle;
			} else if (A[middle] > target) {
				end = middle;
			} else {
				start = middle;
			}
			middle = (end >> 1) + (start >> 1) + ((end & 1) & (start & 1));
		}
		if (A[middle] > target) {
			return middle;
		} else {
			return middle + 1;
		}

	}

}