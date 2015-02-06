package peter;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * 
 * For example:
 * 
 * <pre>
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 * </pre>
 * 
 * @author ylkang Feb 5, 2015
 */
public class _171_Excel_Sheet_Column_Number {

	static private Map<Character, Integer> m = new HashMap<Character, Integer>();
	static {
		m.put('A', 1);
		m.put('B', 2);
		m.put('C', 3);
		m.put('D', 4);
		m.put('E', 5);
		m.put('F', 6);
		m.put('G', 7);
		m.put('H', 8);
		m.put('I', 9);
		m.put('J', 10);
		m.put('K', 11);
		m.put('L', 12);
		m.put('M', 13);
		m.put('N', 14);
		m.put('O', 15);
		m.put('P', 16);
		m.put('Q', 17);
		m.put('R', 18);
		m.put('S', 19);
		m.put('T', 20);
		m.put('U', 21);
		m.put('V', 22);
		m.put('W', 23);
		m.put('X', 24);
		m.put('Y', 25);
		m.put('Z', 26);
	}

	public int titleToNumber(String s) {
		int number = 0;
		for (int i = 0; i < s.length(); i++) {
			number = number + m.get(s.charAt(i))
					* ((int) Math.pow(26, s.length() - i - 1));

		}
		return number;
	}

}
