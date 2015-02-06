package peter;

/**
 * Compare two version numbers version1 and version1. If version1 > version2
 * return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character. The . character does not represent a decimal point and
 * is used to separate number sequences. For instance, 2.5 is not
 * "two and a half" or "half way to version three", it is the fifth second-level
 * revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * @author ylkang Feb 5, 2015
 */
public class _165_Compare_Version_Numbers {

	public int compareVersion(String version1, String version2) {
		String[] tmp1 = version1.split("\\.");
		String[] tmp2 = version2.split("\\.");
		for (int i = 0; i < tmp1.length; i++) {
			tmp1[i] = strip(tmp1[i]);
		}
		for (int i = 0; i < tmp2.length; i++) {
			tmp2[i] = strip(tmp2[i]);
		}

		int returnV = 0;
		if (tmp1.length > tmp2.length) {
			for (int i = tmp2.length; i < tmp1.length; i++) {
				if (!tmp1[i].equals("0")) {
					returnV = 1;
					break;
				}
			}
		} else if (tmp1.length < tmp2.length) {
			for (int i = tmp1.length; i < tmp2.length; i++) {
				if (!tmp2[i].equals("0")) {
					returnV = -1;
					break;
				}
			}
		}

		int len = tmp1.length > tmp2.length ? tmp2.length : tmp1.length;

		for (int i = 0; i < len; i++) {
			if (tmp1[i].length() > tmp2[i].length()) {
				return 1;
			} else if (tmp1[i].length() < tmp2[i].length()) {
				return -1;
			} else if (tmp1[i].compareTo(tmp2[i]) == 0) {
				continue;
			} else {
				if (tmp1[i].compareTo(tmp2[i]) > 0) {
					return 1;
				} else if (tmp1[i].compareTo(tmp2[i]) < 0) {
					return -1;
				}
				return 0;
			}
		}
		return returnV;
	}

	private static String strip(String value) {
		int j = 0;
		for (j = 0; j < value.length(); j++) {
			if (value.charAt(j) == '0') {
				continue;
			}
			break;
		}
		if (j == value.length()) {
			return value.substring(value.length() - 1);
		}
		return value.substring(j);
	}

}