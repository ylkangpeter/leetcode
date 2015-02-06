package peter;

public class _153_Find_Minimum_in_Rotated_Sorted_Array {

	public int findMin(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}

		if (num[0] < num[num.length - 1]) {
			return num[0];
		}

		int start = 0;
		int end = num.length - 1;
		int middle = start / 2 + end / 2 + ((start & 1) + (end & 1)) / 2;

		while (start < end) {
			if (middle == start) {
				return num[end];
			}
			if (middle == end) {
				return num[start];
			}
			if (num[start] < num[middle]) {
				start = middle;
				middle = start / 2 + end / 2 + ((start & 1) + (end & 1)) / 2;
			} else {
				end = middle;
				middle = start / 2 + end / 2 + ((start & 1) + (end & 1)) / 2;
			}
		}
		return num[middle];
	}

}