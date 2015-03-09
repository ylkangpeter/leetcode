package peter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * like 39,just no duplicate emelements
 * 
 * @author ylkang Mar 5, 2015
 */
public class _040_Combination_Sum_II {

	private static Set<String> set = new HashSet<String>();

	public static List<List<Integer>> combinationSum2(int[] candidates,
			int target) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();

		if (candidates == null) {
			return list;
		}
		Arrays.sort(candidates);

		List<Integer> tmpList = new ArrayList<Integer>();
		doIt(list, tmpList, candidates, target, 0, "");
		return list;
	}

	private static void doIt(List<List<Integer>> list, List<Integer> tmpList,
			int[] candidates, int target, int numberInx, String str) {
		if (target == 0) {
			if (!set.contains(str)) {
				list.add(tmpList);
				set.add(str);
			}
		} else if (numberInx >= candidates.length
				|| candidates[numberInx] > target) {
			return;
		} else {
			List<Integer> aList = new ArrayList<Integer>();
			aList.addAll(tmpList);
			aList.add(candidates[numberInx]);
			doIt(list, aList, candidates, target - candidates[numberInx],
					numberInx + 1, str + candidates[numberInx]);
			for (int i = numberInx + 1; i < candidates.length
					&& target >= candidates[i]; i++) {

				List<Integer> ll = new ArrayList<Integer>();
				ll.addAll(tmpList);
				ll.add(candidates[i]);
				doIt(list, ll, candidates, target - candidates[i], i + 1, str
						+ candidates[i]);
			}
		}
	}

	public static void main(String[] args) {
		int tar = 7;
		int[] can = { 1, 2, 2, 2, 3, 5, 7 };
		System.out.println(combinationSum2(can, tar));
	}
}