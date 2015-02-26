package peter;

/**
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be; bool isMatch(const char *s, const char *p)
 * 
 * <pre>
 * Some examples;
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * </pre>
 * 
 * *
 * 
 * @author ylkang Feb 15, 2015
 */
public class _010_Regular_Expression_Matching {

	public static boolean isMatch(String s, String p) {
		if (s == null || s.isEmpty()) {
			return true;
		}
		if (p == null || p.isEmpty()) {
			return false;
		}

		int strCur = 0;
		int patternCur = 0;
		int basePatternCur = 0;
		char preceding = ' ';

		return true;
	}

	public static void main(String[] args) {
		// System.out.println(isMatch("aa", "a"));
		// System.out.println(isMatch("aa", "a"));
		// System.out.println(isMatch("aa", "aa"));
		// System.out.println(isMatch("aaa", "cccaabbaaac"));
		// System.out.println(isMatch("aa", "a*"));
		// System.out.println(isMatch("aa", ".*"));
		// System.out.println(isMatch("ab", ".*"));
		// System.out.println(isMatch("aab", "c*a*b"));
		System.out.println(isMatch("daa", "d*ada*"));
		System.out.println(isMatch("daa", "d*aa"));
	}
}