package peter;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _066_Plus_One {

	public int[] plusOne(int[] digits) {
		List<Integer> list = new ArrayList<Integer>();
		int promotion = 0;
		if (digits == null) {
			return new int[] { 0 };
		}
		int val = digits[digits.length - 1] + 1;
		digits[digits.length - 1] = val % 10;
		promotion = val / 10;

		if (promotion > 0) {
			for (int i = digits.length - 2; i >= 0; i--) {
				val = digits[i] + promotion;
				digits[i] = val % 10;
				promotion = val / 10;
			}
			if (promotion > 0) {
				int[] vals = new int[digits.length + 1];
				System.arraycopy(digits, 0, vals, 1, digits.length);
				vals[0] = promotion;
				return vals;
			}

		}
		return digits;

	}

}