package peter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * For example, Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * 
 * @author ylkang Apr 29, 2015
 */
public class _205_Isomorphic_Strings {

	private Set<Character> mappedSet = new HashSet<Character>();
	private Set<Character> cantChangeSet = new HashSet<Character>();
	private Map<Character, Character> m = new HashMap<Character, Character>();

	public boolean isIsomorphic(String s, String t) {
		if (s == null || s.length() == 0) {
			return true;
		}

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				// map to itself
				if (cantChangeSet.contains(s.charAt(i))) {
					return false;
				}

				if (m.get(s.charAt(i)) == null) {
					if (cantChangeSet.contains(t.charAt(i))
							|| mappedSet.contains(t.charAt(i))) {
						return false;
					}
					m.put(s.charAt(i), t.charAt(i));
					mappedSet.add(t.charAt(i));
				} else {
					if (m.get(s.charAt(i)) != t.charAt(i)) {
						return false;
					}
				}
			} else {
				if (m.containsKey(s.charAt(i))
						|| mappedSet.contains(t.charAt(i))) {
					return false;
				}
				cantChangeSet.add(s.charAt(i));
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new _205_Isomorphic_Strings().isIsomorphic("bar",
				"foo"));
		System.out.println(new _205_Isomorphic_Strings().isIsomorphic("ab",
				"aa"));
		System.out.println(new _205_Isomorphic_Strings().isIsomorphic("aa",
				"ab"));
		System.out.println(new _205_Isomorphic_Strings().isIsomorphic("egg",
				"add"));
		System.out.println(new _205_Isomorphic_Strings().isIsomorphic("foo",
				"bar"));
		System.out.println(new _205_Isomorphic_Strings().isIsomorphic("paper",
				"title"));
		System.out.println(new _205_Isomorphic_Strings().isIsomorphic("aaa",
				"baa"));
	}
}
