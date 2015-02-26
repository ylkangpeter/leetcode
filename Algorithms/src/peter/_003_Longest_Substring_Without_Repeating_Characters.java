package peter;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 * @author ylkang Feb 15, 2015
 */
public class _003_Longest_Substring_Without_Repeating_Characters {

	public static int lengthOfLongestSubstring(String s) {

		int max = 0;

		if (s == null || s.length() == 0) {
			return max;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int subStrStartInx = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.get(c) != null) {
				int inx = map.get(c);
				subStrStartInx = Math.max(subStrStartInx, inx);
			}
			map.put(c, i + 1);
			max = Math.max(max, i - subStrStartInx + 1);
		}

		return max;

	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abba"));
	}
}