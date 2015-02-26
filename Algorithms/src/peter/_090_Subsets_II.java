package peter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of integers that might contain duplicates, S, return all
 * possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,2], a solution
 * is:
 * 
 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * 
 * @author ylkang Feb 17, 2015
 */
public class _090_Subsets_II {

	private static Set<String> set = new HashSet<String>(1000);

	public static List<List<Integer>> subsetsWithDup(int[] num) {

		Arrays.sort(num);

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		subsets(num, new ArrayList<Integer>(), "", list, 0);
		return list;
	}

	private static void subsets(int[] S, List<Integer> prefixList, String str,
			List<List<Integer>> list, int inx) {
		if (S == null) {
			return;
		}
		List<Integer> tmp = new ArrayList<Integer>();
		tmp.addAll(prefixList);
		if (inx == S.length) {
			if (!set.contains(str)) {
				set.add(str);
				Collections.sort(tmp);
				list.add(tmp);
			}
			return;
		}

		subsets(S, prefixList, str, list, inx + 1);
		tmp.add(S[inx]);
		subsets(S, tmp, str + S[inx], list, inx + 1);

	}

	public static void main(String[] args) {
		System.out.println(subsetsWithDup(new int[] { 1, 2, 2 }));
	}

}