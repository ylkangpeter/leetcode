package peter;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _058_Length_of_Last_Word {

	public int lengthOfLastWord(String s) {
		if (s == null || s.equals("")) {
			return 0;
		}
		int i = s.length() - 1;
		for (; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				break;
			}
		}

		int len = 0;
		for (; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				return len;
			}
			len++;
		}
		return len;
	}

}