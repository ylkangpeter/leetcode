package peter;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author ylkang Feb 5, 2015
 */
public class _136_Single_Number {
	
	public int singleNumber(int[] A) {
		int n1 = 0;
		for (int i = 0; i < A.length; ++i) {
			n1 ^= A[i];
		}
		return n1;
	}
}
