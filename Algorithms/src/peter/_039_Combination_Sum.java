package peter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. Elements in a
 * combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤
 * … ≤ ak). The solution set must not contain duplicate combinations. For
 * example, given candidate set 2,3,6,7 and target 7, A solution set is:
 * 
 * <pre>
 * [7] 
 * [2, 2, 3]
 * </pre>
 * 
 * @author ylkang Mar 5, 2015
 */
public class _039_Combination_Sum {

	public static List<List<Integer>> combinationSum(int[] candidates,
			int target) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();

		if (candidates == null) {
			return list;
		}
		Arrays.sort(candidates);

		List<Integer> tmpList = new ArrayList<Integer>();
		doIt(list, tmpList, candidates, target, 0);
		return list;
	}

	private static void doIt(List<List<Integer>> list, List<Integer> tmpList,
			int[] candidates, int target, int numberInx) {
		if (target == 0) {
			list.add(tmpList);
		} else if (candidates[numberInx] > target) {
			return;
		} else {
			List<Integer> aList = new ArrayList<Integer>();
			aList.addAll(tmpList);
			aList.add(candidates[numberInx]);
			doIt(list, aList, candidates, target - candidates[numberInx],
					numberInx);
			int pre = candidates[numberInx];
			for (int i = numberInx + 1; i < candidates.length
					&& target >= candidates[i]; i++) {
				if (candidates[i] == pre) {
					continue;
				}
				pre = candidates[i];
				List<Integer> ll = new ArrayList<Integer>();
				ll.addAll(tmpList);
				ll.add(candidates[i]);
				doIt(list, ll, candidates, target - candidates[i], i);
			}
		}
	}

	public static void main(String[] args) {
		int tar = 7;
		int[] can = { 1, 6, 2, 3 };
		System.out.println(combinationSum(can, tar));
	}
}