package peter;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * @author ylkang Feb 5, 2015
 */
public class _007_Reverse_Integer {

	public int reverse(int x) {
		if (x == 0) {
			return 0;
		}
		boolean isPos = x > 0 ? true : false;

		if (!isPos) {
			x = -x;
		}
		int total = 0;
		while (x > 0) {
			if (total > Integer.MAX_VALUE / 10) {
				return 0;
			}
			int mod = x % 10;
			x = x / 10;
			total = total * 10 + mod;
		}
		if (!isPos) {
			return -1 * total;
		}
		return total;

	}

}