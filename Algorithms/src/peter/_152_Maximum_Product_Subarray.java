package peter;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _152_Maximum_Product_Subarray {

	public int maxProduct(int[] A) {

		int max = A[0];
		int min = A[0];
		int result = max;

		for (int i = 1; i < A.length; i++) {
			if (A[i] > 0) {
				max = Math.max(max * A[i], A[i]);
				min = Math.min(min * A[i], A[i]);
			} else {
				int tmp = max;
				max = Math.max(min * A[i], A[i]);
				min = Math.min(tmp * A[i], A[i]);
			}
			result = Math.max(max, result);
		}
		return result;

	}

}