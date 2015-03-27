package peter;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * [ ["aa","b"], ["a","a","b"] ]
 * 
 * @author ylkang Feb 26, 2015
 */
public class _131_Palindrome_Partitioning {

	public static List<List<String>> partition(String s) {

		List<List<String>> list = new ArrayList<List<String>>();
		if (s == null || s.isEmpty()) {
			return list;
		}
		calc(new ArrayList<String>(), list, 0, s);
		return list;
	}

	private static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}

	private static void calc(List<String> tmpList, List<List<String>> result,
			int offset, String s) {
		if (offset == s.length()) {
			result.add(tmpList);
		} else {
			for (int i = offset + 1; i <= s.length(); i++) {
				String sub = s.substring(offset, i);
				if (isPalindrome(sub)) {
					List<String> myList = new ArrayList<String>();
					myList.addAll(tmpList);
					myList.add(sub);
					calc(myList, result, i, s);
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(partition("aab"));
		System.out.println(partition("aaaa"));
		System.out.println(partition("aabbbaa"));
	}
}