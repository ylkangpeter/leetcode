package peter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * <pre>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * </pre>
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 * @author ylkang May 13, 2015
 */
public class _076_Minimum_Window_Substring {

	public String minWindow(String s, String t) {
		if (s == null || s.length() == 0 || t == null || t.length() == 0
				|| s.length() < t.length()) {
			return "";
		}

		Map<Character, Integer> patternMap = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			char key = t.charAt(i);
			patternMap.put(key,
					patternMap.get(key) == null ? 1 : patternMap.get(key) + 1);
		}

		int totalChars = 0;
		Map<Character, LinkedList<Integer>> map = new HashMap<Character, LinkedList<Integer>>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Integer counts = patternMap.get(c);
			if (counts != null) {
				LinkedList<Integer> list = map.get(c);
				if (list == null) {
					list = new LinkedList<Integer>();
					map.put(c, list);
					totalChars++;
				} else {
					if (counts == 1) {
						list.clear();
					} else {
						if (list.size() >= counts) {
							list.removeFirst();
						}
					}
					map.remove(c);
					map.put(c, list);
				}
				list.add(i);
			}
		}

		int min = s.length();
		int max = 0;
		for (LinkedList<Integer> list : map.values()) {
			for (int inter : list) {
				min = Math.min(inter, min);
				max = Math.max(inter, max);
			}
		}
		if (totalChars != t.length()) {
			return "";
		}
		return s.substring(min, max + 1);
	}

	public static void main(String[] args) {
		System.out.println(new _076_Minimum_Window_Substring().minWindow(
				"cabwefgewcwaefgcf", "cae"));
		System.out.println(new _076_Minimum_Window_Substring().minWindow("aa",
				"aa"));
		System.out.println(new _076_Minimum_Window_Substring().minWindow(
				"ADOBECODEBANC", "ABC"));
	}
}