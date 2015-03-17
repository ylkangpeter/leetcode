package peter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 * 
 * @author peter Mar 17, 2015
 * 
 */
public class _049_Anagrams {

	public static List<String> anagrams(String[] strs) {
		List<String> result = new ArrayList<String>();
		if (strs == null) {
			return result;
		}

		Map<String, Value> map = new HashMap<String, Value>();
		for (String str : strs) {
			String key = calc(str);
			Value tmp = map.get(key);
			if (tmp == null) {
				map.put(key, new Value(str, false));
			} else {
				if (tmp.isDummy) {
					result.add(str);
				} else {
					result.add(str);
					result.add(tmp.key);
					tmp.isDummy = true;
				}
			}
		}

		return result;
	}

	private static class Value {
		String key;
		boolean isDummy = false;

		Value(String key, boolean isDummy) {
			this.key = key;
			this.isDummy = isDummy;
		}
	}

	private static String calc(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			Integer counter = m.get(c);
			if (counter == null) {
				counter = 0;
			}
			counter++;
			m.put(c, counter);
		}
		List<Character> ll = new ArrayList<Character>();
		ll.addAll(m.keySet());
		Collections.sort(ll);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ll.size(); i++) {
			sb.append(ll.get(i)).append("_").append(m.get(ll.get(i)))
					.append("|");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] strs = { "", "", null, null, "123", "321", "222", "233",
				"aaa", "a1a", "1aa" };
		System.out.println(anagrams(strs));
	}
}