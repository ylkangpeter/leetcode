package peter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct
 * a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand",
 * "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * @author ylkang Apr 10, 2015
 */
public class _140_Word_Break_II {
	
	HashMap<Integer, List<String>> cache = new HashMap<Integer, List<String>>();

	public List<String> dfs(ArrayList<ArrayList<Integer>> DP, String str,
			int startidx) {
		if (cache.containsKey(startidx))
			return cache.get(startidx);
		ArrayList<Integer> dplist = DP.get(startidx);
		ArrayList<String> retlist = new ArrayList<String>();
		for (int i = 0; i < dplist.size(); i++) {
			int j = dplist.get(i);
			String substr = str.substring(startidx, j);
			if (j == str.length())
				retlist.add(substr);
			else {
				List<String> temp = dfs(DP, str, j);
				for (int k = 0; k < temp.size(); k++)
					retlist.add(substr + " " + temp.get(k));
			}
		}
		if (cache.containsKey(startidx) == false) {
			cache.put(startidx, retlist);
		}
		return retlist;
	}

	public List<String> wordBreak(String s, Set<String> dict) {
		ArrayList<ArrayList<Integer>> DP = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < s.length(); i++) {
			ArrayList<Integer> dplist = new ArrayList<Integer>();
			for (int j = i + 1; j <= s.length(); j++)
				if (dict.contains(s.substring(i, j))) {
					dplist.add(j);
				}
			DP.add(dplist);
		}
		return this.dfs(DP, s, 0);
	}

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		System.out.println(new _140_Word_Break_II().wordBreak("catsanddog",
				dict));
		// dict.add("a");
		// dict.add("aa");
		// dict.add("aaa");
		// dict.add("aaaa");
		// dict.add("aaaaa");
		// dict.add("aaaaaa");
		// dict.add("aaaaaaa");
		// dict.add("aaaaaaaa");
		// dict.add("aaaaaaaaa");
		// dict.add("aaaaaaaaaa");
		System.out.println(new _140_Word_Break_II().wordBreak("aaaaaaaaaab",
				dict));
		System.out.println();
	}
}