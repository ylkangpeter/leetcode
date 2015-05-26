package peter;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * Ensure that numbers within the set are sorted in ascending order.
 * 
 * <pre>
 * Example 1:
 * 
 * Input: k = 3, n = 7
 * 
 * Output:
 * 
 * [[1,2,4]]
 * 
 * Example 2:
 * 
 * Input: k = 3, n = 9
 * 
 * Output:
 * 
 * [[1,2,6], [1,3,5], [2,3,4]]
 * </pre>
 * 
 * @author ylkang May 25, 2015
 */
public class _216_Combination_Sum_III {

	public List<List<Integer>> combinationSum3(int k, int n) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();

		if (k < 0 || n < 0) {
			return list;
		}

		int[] candidates = new int[k];
		for (int i = 1; i <= k; i++) {
			candidates[i - 1] = i;
		}

		List<Integer> tmpList = new ArrayList<Integer>();
		doIt(list, tmpList, n, 1, k);
		return list;

	}

	private static void doIt(List<List<Integer>> list, List<Integer> tmpList,
			int target, int currentNum, int numberLeft) {

		if (target == 0) {
			if (numberLeft == 0) {
				list.add(tmpList);
			}
		} else if (numberLeft == 0) {
			return;
		} else {
			for (int i = currentNum; i <= 9; i++) {
				List<Integer> aList = new ArrayList<Integer>();
				aList.addAll(tmpList);
				aList.add(i);
				if (target < currentNum) {
					return;
				}
				doIt(list, aList, target - i, i + 1, numberLeft - 1);
			}
		}
	}

	public static void main(String[] args) {
		System.out
				.println(new _216_Combination_Sum_III().combinationSum3(3, 9));
		System.out
				.println(new _216_Combination_Sum_III().combinationSum3(3, 7));
	}
}
