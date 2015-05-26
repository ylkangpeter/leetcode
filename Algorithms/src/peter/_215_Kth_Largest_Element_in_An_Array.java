package peter;

/**
 * ind the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * For example, Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 * @author ylkang May 25, 2015
 */
public class _215_Kth_Largest_Element_in_An_Array {

	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		return divide(0, nums.length, nums, nums.length + 1 - k);
	}

	private int divide(int start, int end, int[] nums, int k) {
		int middle = nums[(start + end) >> 1];
		int middleNum = 0;
		int s = 0;
		int e = end - start;
		int[] newNums = new int[end - start];

		for (int i = start; i < end; i++) {
			if (nums[i] < middle) {
				newNums[s] = nums[i];
				s++;
			} else if (nums[i] == middle) {
				middleNum++;
			} else {
				newNums[e - 1] = nums[i];
				e--;
			}
		}

		int len1 = s;
		int len2 = middleNum;

		if (k <= len1) {
			return divide(0, len1, newNums, k);
		} else if (k > len1 + len2) {
			return divide(len1 + len2, end - start, newNums, k - len1 - len2);
		} else {
			return middle;
		}

	}

	public static void main(String[] args) {
		System.out.println(new _215_Kth_Largest_Element_in_An_Array()
				.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4, 1, 2, 3, 3, 3, 3,
						3 }, 2));
	}
}
