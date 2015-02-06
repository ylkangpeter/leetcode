package peter;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _008_String_to_Integer_atoi {

	public int atoi(String str) {

		int MAX = Integer.MAX_VALUE / 10;

		if (str == null || str.length() == 0) {
			return 0;
		}
		if (str.length() == 1 && (str.charAt(0) == '-' || str.charAt(0) == '+')) {
			return 0;
		}

		int startInx = 0;

		for (; startInx < str.length(); startInx++) {
			if (str.charAt(startInx) == ' ') {
				continue;
			}
			break;
		}
		if (startInx == str.length()) {
			return 0;
		}
		str = str.substring(startInx);

		int endInx = str.length() - 1;
		for (; endInx >= 0; endInx--) {
			if (str.charAt(endInx) == ' ') {
				continue;
			}
			break;
		}
		if (endInx < 0) {
			return 0;
		}
		str = str.substring(0, endInx + 1);

		/*
		 * begin normal processing
		 */

		// check 1st none zero
		boolean isPos = true;
		if (str.charAt(0) == '-') {
			isPos = false;
			str = str.substring(1);
		} else if (str.charAt(0) == '+') {
			str = str.substring(1);
		}

		// check
		int value = 0;

		if (isPos) {
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c > '9' || c < '0') {
					return value;
				}
				if (value >= MAX) {
					if (value > MAX) {
						return Integer.MAX_VALUE;
					}
					if ((c - 48) > 7) {
						return Integer.MAX_VALUE;
					}

				}
				value = value * 10 + (c - 48);
			}
		} else {
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c > '9' || c < '0') {
					return value;
				}
				if (value <= -1 * MAX) {
					if (value < -1 * MAX) {
						return Integer.MIN_VALUE;
					}
					if ((c - 48) > 8) {
						return Integer.MIN_VALUE;
					}
				}
				value = value * 10 - (c - 48);
			}
		}
		return value;

	}

}