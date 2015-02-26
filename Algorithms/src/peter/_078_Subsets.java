package peter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set
 * must not contain duplicate subsets. For example, If S = [1,2,3], a solution
 * is:
 * 
 * <pre>
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * </pre>
 * 
 * *
 * 
 * @author ylkang Feb 11, 2015
 */
public class _078_Subsets {

	public static List<List<Integer>> subsets(int[] S) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		subsets(S, new ArrayList<Integer>(), list, 0);
		return list;
	}

	private static void subsets(int[] S, List<Integer> prefixList,
			List<List<Integer>> list, int inx) {
		if (S == null) {
			return;
		}
		List<Integer> tmp = new ArrayList<Integer>();
		tmp.addAll(prefixList);
		if (inx == S.length) {
			Collections.sort(tmp);
			list.add(tmp);
			return;
		}

		subsets(S, prefixList, list, inx + 1);
		tmp.add(S[inx]);
		subsets(S, tmp, list, inx + 1);

	}

	public static void main(String[] args) {
		System.out.println(subsets(new int[] { 1, 2 }));
	}
}