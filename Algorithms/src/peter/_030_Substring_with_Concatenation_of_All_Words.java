package peter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * You are given a string, S, and a list of words, L, that are all of the same
 * length. Find all starting indices of substring(s) in S that is a
 * concatenation of each word in L exactly once and without any intervening
 * characters.
 * 
 * For example, given: S: "barfoothefoobarman" L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 * 
 * @author peter Mar 26, 2015
 * 
 */
public class _030_Substring_with_Concatenation_of_All_Words {

	public List<Integer> findSubstring_fast(String s, String[] words) {
		List<Integer> list = new ArrayList<Integer>();
		if (words.length == 0)
			return list;
		int wLen = words[0].length();
		int len = s.length();
		if (len < wLen * words.length)
			return list;
		Map<String, Integer> origMap = new HashMap<String, Integer>();
		for (String word : words)
			origMap.put(word, origMap.containsKey(word) ? origMap.get(word) + 1
					: 1);

		for (int start = 0; start < wLen; start++) {
			int pos = start;
			int tStart = -1;
			Map<String, Integer> mapT = new HashMap<String, Integer>(origMap);
			while (pos + wLen <= len) {
				String cand = s.substring(pos, pos + wLen);
				if (!origMap.containsKey(cand)) {
					if (tStart != -1)
						mapT = new HashMap<String, Integer>(origMap);
					tStart = -1;
				} else if (mapT.containsKey(cand)) {
					tStart = tStart == -1 ? pos : tStart;
					if (mapT.get(cand) == 1)
						mapT.remove(cand);
					else
						mapT.put(cand, mapT.get(cand) - 1);
					if (mapT.isEmpty())
						list.add(tStart);
				} else {
					while (tStart < pos) {
						// here is the key efficient point

						/**
						 * aaaaaa aa aa for aafoobarfoo & foo & bar case. when
						 * we get foobar matches, then foo is in the map, trace
						 * back again, foo index of 2 matches 2nd foo. which
						 * means barfoo matches, no need to check the bar part
						 * again
						 */

						String rCand = s.substring(tStart, tStart + wLen);
						if (cand.equals(rCand)) {
							tStart += wLen;
							if (mapT.isEmpty())
								list.add(tStart);
							break;
						}
						tStart += wLen;
						mapT.put(rCand,
								mapT.containsKey(rCand) ? mapT.get(rCand) + 1
										: 1);
					}
				}
				pos += wLen;
			}
		}
		return list;
	}

	public List<Integer> findSubstring_Slow(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || words == null || words.length == 0
				|| s.length() < words[0].length() * words.length) {
			return result;
		}

		Set<String> set = permute(words);
		int totalLen = words[0].length() * words.length;
		int end = s.length() - totalLen;
		for (int i = 0; i <= end; i++) {
			if (set.contains(s.substring(i, i + totalLen))) {
				result.add(i);
			}
		}
		return result;
	}

	private Set<String> permute(String[] num) {
		Set<String> list = new HashSet<String>();

		perm(list, 0, num.length - 1, num);
		// list.addAll(set);
		return list;
	}

	private void perm(Set<String> list, int start, int end, String[] num) {
		if (start == end) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < num.length; j++) {
				sb.append(num[j]);
			}
			list.add(sb.toString());
			return;
		}

		for (int i = start; i <= end; i++) {
			String tmp = num[start];
			num[start] = num[i];
			num[i] = tmp;

			perm(list, start + 1, end, num);

			num[i] = num[start];
			num[start] = tmp;

		}
	}

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || words == null || words.length == 0
				|| s.length() < words[0].length() * words.length) {
			return result;
		}

		int wordLen = words[0].length();
		int end = s.length() - words[0].length() * words.length;

		Map<String, Integer> myMap = buildMap(words);

		for (int start = 0; start <= end; start++) {
			int counter = 0;
			if (myMap.get(s.substring(start, start + wordLen)) == null) {
				continue;
			}
			Map<String, Integer> map = new HashMap<String, Integer>(myMap);
			for (int i = start; i <= s.length() - wordLen; i += wordLen) {
				String word = s.substring(i, i + wordLen);
				Integer counts = map.get(word);
				if (counts == null) {
					break;
				} else {
					if (counts == 1) {
						map.remove(word);
					} else {
						map.put(word, counts - 1);
					}
					counter++;
				}
			}
			if (counter == words.length) {
				result.add(start);
			}
		}

		return result;

	}

	private Map<String, Integer> buildMap(String[] L) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : L) {
			int number = 1;
			if (map.get(word) != null) {
				number = map.get(word) + 1;
			}
			map.put(word, number);
		}
		return map;
	}

	public static void main(String[] args) {
		String[] L = { "foo", "bar" };
		// System.out.println(new
		// _030_Substring_with_Concatenation_of_All_Words()
		// .findSubstring_fast("barfoobar", L));
		// System.out.println(new
		// _030_Substring_with_Concatenation_of_All_Words()
		// .findSubstring_fast("barfoothefoobarman", L));
		// L = new String[] { "fooo", "barr", "wing", "ding", "wing" };
		// System.out.println(new
		// _030_Substring_with_Concatenation_of_All_Words()
		// .findSubstring_fast(
		// "lingmindraboofooowingdingbarrwingmonkeypoundcake", L));
		L = new String[] { "aa", "aa", "aa" };
		System.out.println(new _030_Substring_with_Concatenation_of_All_Words()
				.findSubstring_fast("aaaaaaaa", L));
		L = new String[] { "a" };
		System.out.println(new _030_Substring_with_Concatenation_of_All_Words()
				.findSubstring_fast("a", L));
	}
}