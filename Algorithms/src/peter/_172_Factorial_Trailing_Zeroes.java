package peter;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _172_Factorial_Trailing_Zeroes {
	
	public int trailingZeroes(int n) {
		int rest = n / 5;
		if (rest > 0) {
			return rest + trailingZeroes(rest);
		}
		return 0;
	}
}