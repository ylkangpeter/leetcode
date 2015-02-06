package peter;

/**
 * 
 * @author ylkang Feb 5, 2015
 */
public class _053_Maximum_Subarray {

	public int maxSubArray(int[] A) {
		int max = Integer.MIN_VALUE;
		int total = 0;

		for (int i = 0; i < A.length; i++) {
			if (total < 0) {
				total = A[i];
			} else {
				total += A[i];
			}
			if (total > max) {
				max = total;
			}
		}
		return max;
	}

}