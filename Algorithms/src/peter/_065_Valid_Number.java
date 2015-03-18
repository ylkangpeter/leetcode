package peter;

import java.util.HashSet;
import java.util.Set;

/**
 * Validate if a given string is numeric.
 * 
 * <pre>
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * </pre>
 * 
 * Note: It is intended for the problem statement to be ambiguous. You should
 * gather all requirements up front before implementing one.
 * 
 * @author peter Mar 18, 2015
 * 
 */
// FIXME this problem is disgusting!!
public class _065_Valid_Number {
	public boolean isNumber(String s) {
		String ss = s.trim();
		int state = 1;
		boolean canSymbolAppear = true;
		boolean valid = false;
		boolean canPointAppear = true;
		for (int i = 0; i < ss.length(); i++) {
			char c = ss.charAt(i);
			if ((c == '+' || c == '-') && canSymbolAppear) {
				canSymbolAppear = false;
				continue;
			}
			switch (state) {
			case 1:
				if (isDigit(c)) {
					valid = true;
					canSymbolAppear = false;
					continue;
				} else if (isPoint(c) && canPointAppear) {
					canPointAppear = false;
					canSymbolAppear = false;
					continue;
				} else if (isE(c) && valid) {
					state = 2;
					canSymbolAppear = true;
					valid = false;
					continue;
				} else
					return false;

			case 2:
				if (isDigit(c)) {
					valid = true;
					canSymbolAppear = false;
					continue;
				} else
					return false;
			default:
				return false;
			}

		}
		if (valid)
			return true;
		else
			return false;

	}

	public boolean isDigit(char s) {
		return (s >= '0' && s <= '9');
	}

	public boolean isPoint(char s) {
		return s == '.';
	}

	public boolean isE(char s) {
		return (s == 'e' || s == 'E');
	}

	public static boolean isOk(String s) {

		if (s == null || s.trim().isEmpty()) {
			return false;
		}

		s = s.trim();
		char c = s.charAt(0);
		int offset = 0;

		if (c == '-' || c == '+') {
			offset++;
		}

		boolean hasNumber = false;
		boolean is8Radix = false;
		boolean is16Radix = false;
		boolean isFloat = false;
		boolean isScientificNum = false;

		if (s.substring(offset).startsWith("0x")) {
			is16Radix = true;
			offset += 2;
		} else if (s.substring(offset).startsWith("O")) {
			is8Radix = true;
			offset += 1;
		}

		s = s.substring(offset);

		if (s.isEmpty()) {
			return false;
		}

		char shouldMatch = ' ';

		offset = 0;
		if (s.charAt(0) == '0') {
			shouldMatch = '.';
			offset++;
		}

		final char FLOAT_NUM = '1';
		final char SCI_NUM = '2';
		final Set<Character> _16_SET = new HashSet<Character>();
		_16_SET.add('a');
		_16_SET.add('b');
		_16_SET.add('c');
		_16_SET.add('d');
		_16_SET.add('e');
		_16_SET.add('f');

		// 0 ascii 48, 1 ascii 49, .. 9 ascii 57
		for (; offset < s.length(); offset++) {
			char ch = s.charAt(offset);
			if (shouldMatch != ' ') {
				if (shouldMatch == '.') {
					if (ch != '.') {
						return false;
					} else {
						shouldMatch = FLOAT_NUM;
					}
				} // .X or eX
				else if (shouldMatch == FLOAT_NUM || shouldMatch == SCI_NUM) {
					if (ch == '0') {
						continue;
					} else if (is16Radix) {
						if (!_16_SET.contains(ch)) {
							return false;
						}
					} else if (is8Radix) {
						if (ch < 48 || ch > 55) {
							return false;
						}
					} else if (ch >= 48 && ch <= 57) {
					} else {
						return false;
					}
					shouldMatch = ' ';
				}
			} else {
				if (48 <= ch && ch <= 55) {
					hasNumber = true;
				} else if (ch == 56 || ch == 57) {
					if (is8Radix) {
						return false;
					}
					hasNumber = true;
				} else {
					switch (ch) {
					case '.':
						if (isFloat || isScientificNum) {
							return false;
						} else {
							isFloat = true;
							shouldMatch = FLOAT_NUM;
						}
						break;
					case 'a':
					case 'b':
					case 'c':
					case 'd':
					case 'f':
						if (!is16Radix) {
							return false;
						}
						hasNumber = true;
						break;
					case 'e':
						if (is16Radix) {
							hasNumber = true;
							break;
						} else {
							if (isScientificNum) {
								return false;
							} else {
								isScientificNum = true;
								shouldMatch = SCI_NUM;
							}
							break;
						}
					default:
						return false;
					}
				}

			}

		}

		if (shouldMatch != ' ') {
			if (shouldMatch == '1' && hasNumber
					&& s.charAt(s.length() - 1) == '.') {
				return true;
			} else if (s.equals("0")) {
				return true;
			}
			return false;
		}

		if (isScientificNum && s.charAt(0) == 'e') {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {

		System.out.println(isOk("0"));
		System.out.println(isOk("."));
		System.out.println(isOk("3."));
		System.out.println(isOk("2e10"));
		System.out.println(isOk(".1"));
		System.out.println(isOk("-00.1"));
		System.out.println(isOk("-00.1e10"));
		System.out.println(isOk("-00.1f10"));
		System.out.println(isOk("065"));
		System.out.println(isOk("e9"));
		System.out.println(isOk("1e9"));
	}
}