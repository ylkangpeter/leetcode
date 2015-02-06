package peter;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _013_Roman_to_Integer {

	private static Map<Character, Integer> map = new HashMap<Character, Integer>();

	static {
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
	}

	public int romanToInt(String s) {
		int value = 0;

		int pre = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			int val = map.get(s.charAt(i));
			if (val >= pre) {
				value += val;
			} else {
				value = value - val;
			}
			pre = val;
		}
		return value;
	}

}