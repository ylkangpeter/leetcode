package peter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd",
 * "ce", "cf"].
 * 
 * Note: Although the above answer is in lexicographical order, your answer
 * could be in any order you want.
 * 
 * @author ylkang Mar 2, 2011
 */
public class _017_Letter_Combinations_of_a_Phone_Number {

	private static Map<Integer, String> m = new HashMap<Integer, String>();

	static {
		m.put(0, " ");
		m.put(2, "abc");
		m.put(3, "def");
		m.put(4, "ghi");
		m.put(5, "jkl");
		m.put(6, "mno");
		m.put(7, "pqrs");
		m.put(8, "tuv");
		m.put(9, "wxyz");
	}

	public static List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return list;
		}
		fill(digits.length(), 0, digits, list, "");
		return list;
	}

	private static void fill(int len, int cur, String digits,
			List<String> list, String curStr) {
		if (cur == len) {
			list.add(curStr);
		} else {
			String chars = m.get(digits.charAt(cur) - 48);
			for (char c : chars.toCharArray()) {
				fill(len, cur + 1, digits, list, curStr + c);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("0023"));
	}
}