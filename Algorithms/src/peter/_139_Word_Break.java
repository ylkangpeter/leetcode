package peter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author ylkang Feb 5, 2015
 */
public class _139_Word_Break {

	Map<String, Boolean> set = new HashMap<String, Boolean>();

	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.equals("")) {
			return false;
		} else if (dict.contains(s)
				|| (set.get(s) != null && set.get(s) == true)) {
			return true;
		} else if (set.get(s) != null && set.get(s) == false) {
			return false;
		} else {
			System.out.println(s);
			for (int i = 1; i < s.length(); i++) {
				if (wordBreak(s.substring(0, i), dict)) {
					set.put(s.substring(0, i), true);
					if (wordBreak(s.substring(i, s.length()), dict)) {
						return true;
					}
				} else {
					set.put(s.substring(0, i), false);
				}
			}
			set.put(s, false);
			return false;
		}
	}

}