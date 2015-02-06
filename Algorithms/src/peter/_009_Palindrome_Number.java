package peter;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _009_Palindrome_Number {

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		long reverse = 0;

		int v = x;
		while (v != 0) {
			reverse = reverse * 10 + v % 10;
			v = v / 10;
			if (reverse >= Integer.MAX_VALUE) {
				return false;
			}
		}

		if (reverse == x) {
			return true;
		}
		return false;
	}

}