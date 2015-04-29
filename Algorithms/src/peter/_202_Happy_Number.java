package peter;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 
 * <pre>
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * </pre>
 * 
 * @author peter Apr 29, 2015
 * 
 */
public class _202_Happy_Number {

	private Set<Integer> set = new HashSet<Integer>();

	public boolean isHappy(int n) {
		while (n != 1) {
			if (set.contains(n)) {
				return false;
			}
			set.add(n);
			n = calc(n);
		}
		return true;
	}

	private int calc(int n) {
		String val = String.valueOf(n);
		int result = 0;
		for (int i = 0; i < val.length(); i++) {
			int tmp = Character.getNumericValue(val.charAt(i));
			result += tmp * tmp;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new _202_Happy_Number().isHappy(19));
	}

}
