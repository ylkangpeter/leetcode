package peter;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author ylkang Feb 6, 2015
 */
public class _137_Single_Number_II {

	public int singleNumber(int[] A) {
		int result = 0;
		for (int j = 0; j < 32; j++) {
			int counter = 0;
			int val = 1 << j;
			for (int i = 0; i < A.length; i++) {
				if ((A[i] & val) == val) {
					counter++;
				}
			}
			if (counter % 3 != 0) {
				result |= val;
			}
		}
		return result;
	}

}