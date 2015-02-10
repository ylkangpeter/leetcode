package peter;

/**
 * Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why? Suppose a sorted
 * array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * @author ylkang Feb 10, 2015
 */
public class _154_Find_Minimum_in_Rotated_Sorted_Array_II {

	public static int findMin(int[] num) {

		// if (num == null || num.length == 0) {
		// return 0;
		// }
		//
		// if (num[0] < num[num.length - 1]) {
		// return num[0];
		// }
		//
		// int start = 0;
		// int end = num.length - 1;
		// int middle = 0;
		//
		// while (start < end) {
		// middle = (start + end) >>> 1;
		// if (middle == start) {
		// return num[end];
		// }
		// if (middle == end) {
		// return num[start];
		// }
		// if (num[start] < num[middle]) {
		// start = middle;
		// } else {
		// end = middle;
		// }
		// }
		// return num[middle];

		if (num[0] < num[num.length - 1]) {
			return num[0];
		}

		int start = 0;
		int end = num.length - 1;

		// 3,3,4,5,1,1,2,2,3
		while (start < end) {
			if (num[start] >= num[end]) {
				start++;
			} else {
				end--;
			}
		}
		return num[start] > num[end] ? num[end] : num[start];

	}

	public static void main(String[] args) {
		System.out.println(findMin(new int[] { 1, 2, 1 }));
	}
}