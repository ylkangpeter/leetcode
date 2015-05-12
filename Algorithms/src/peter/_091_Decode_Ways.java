package peter;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * @author ylkang May 8, 2015
 */
public class _091_Decode_Ways {

	/**
	 * <pre>
	 * <li>1. 1234: p(n)=p(n-1)+p(n-2)</li>
	 * <li>2. 1201: p(n)=p(n-1)</li>
	 * <li>3. 120: p(n)=p(n-1)</li>
	 * <li>4. 100: -1</li>
	 * 
	 * <.pre>
	 * @param s
	 * @return
	 */
	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}

		int[] vals = new int[s.length()];
		vals[0] = 1;
		vals[1] = 2;

		int preVal = 1;

		if (s.charAt(1) == '0') {
			if (s.charAt(0) != '1' && s.charAt(0) != '2') {
				return 0;
			}
			vals[1] = 1;
		} else {
			int val = Integer.parseInt(s.substring(0, 2));
			if (val > 26) {
				vals[1] = 1;
			}
		}
		preVal = Character.digit(s.charAt(1), 10);

		for (int i = 2; i < s.length(); i++) {

			if (s.charAt(i) == '0') {
				if (preVal == 0
						|| (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2')) {
					return 0;
				}
				preVal = 0;
				vals[i] = vals[i - 2];
			} else {
				if (preVal == 0) {
					preVal = s.charAt(i);
					vals[i] = vals[i - 1];
				} else {
					int val = Integer.parseInt(s.substring(i - 1, i + 1));
					if (val > 26) {
						vals[i] = vals[i - 1];
					} else {
						vals[i] = vals[i - 1] + vals[i - 2];
					}
				}
			}
		}
		return vals[s.length() - 1];
	}

	public static void main(String[] args) {
		System.out.println(new _091_Decode_Ways().numDecodings("20"));
		System.out.println(new _091_Decode_Ways().numDecodings("12120"));
		System.out.println(new _091_Decode_Ways().numDecodings("110"));
		System.out.println(new _091_Decode_Ways().numDecodings("27"));
		System.out.println(new _091_Decode_Ways().numDecodings("12"));
		System.out.println(new _091_Decode_Ways().numDecodings("10"));
		System.out.println(new _091_Decode_Ways().numDecodings("100"));
		System.out.println(new _091_Decode_Ways().numDecodings("50"));
		System.out.println(new _091_Decode_Ways().numDecodings("1010"));
		System.out.println(new _091_Decode_Ways().numDecodings("1011"));
	}
}