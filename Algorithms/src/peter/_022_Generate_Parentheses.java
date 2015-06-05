package peter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author ylkang Feb 5, 2015
 */
public class _022_Generate_Parentheses {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<String> generateParenthesis(int n) {
		if (n == 0) {
			return new ArrayList<String>();
		}

		HashSet[] list = new HashSet[2];
		list[0] = new HashSet<String>();
		list[0].add("()");
		list[1] = new HashSet<String>();

		String insert = "()";

		int i = 0;
		for (; i < n - 1; i++) {
			for (Object ss : list[i % 2]) {
				String str = (String) ss;
				for (int k = 0; k < str.length(); k++) {
					list[(i + 1) % 2].add(str.substring(0, k) + insert
							+ str.substring(k, str.length()));
				}
			}
			list[i % 2].clear();
		}

		List<String> re = new ArrayList<String>();
		re.addAll(list[i % 2]);
		return re;

	}

}