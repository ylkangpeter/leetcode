package peter;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _125_Valid_Palindrome {

	public boolean isPalindrome(String s) {
		if (s.equals("")) {
			return true;
		}
		int start = 0;
		int end = s.length() - 1;
		try {
			while (start < end) {

				while (true) {
					char c = s.charAt(start);
					if ((c - 97 < 26 && c >= 97) || (c - 65 < 26 && c >= 65)
							|| (c >= 48 && c <= 57)) {
						break;
					}
					start++;
				}

				while (true) {
					char c = s.charAt(end);
					if ((c - 97 < 26 && c >= 97) || (c - 65 < 26 && c >= 65)
							|| (c >= 48 && c <= 57)) {
						break;
					}
					end--;
				}

				int val = s.charAt(start) - s.charAt(end);
				if (val == 0 || val == 32 || val == -32) {
					start++;
					end--;
					continue;
				}
				return false;
			}
		} catch (Exception e) {
			return true;
		}
		return true;
	}

}