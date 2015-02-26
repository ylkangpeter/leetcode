package peter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * For example, If n = 4 and k = 2, a solution is:
 * 
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 
 * @author ylkang Feb 12, 2015
 */
public class _077_Combinations {

	public List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (k > n) {
			return result;
		}

		int start = 0;
		List<Integer> tmpList = new ArrayList<Integer>();
		for (int numbers = 0; numbers < k; numbers++) {
			for (int i = 0; i < n - k; i++) {
				tmpList.add(start++);
			}
		}

		return result;
	}

	public void selectOne(int start, int selectNumbers, int totalNumbers,
			List<Integer> tmpList) {
		for (int numbers = 0; numbers < totalNumbers; numbers++) {
			for (int i = start; i < -totalNumbers - selectNumbers; i++) {
				tmpList.add(start++);
			}
		}
	}

	public List<List<Integer>> combine1(int n, int k) {
		if (k == 0 || n == 0 || k > n)
			return Collections.emptyList();
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		for (int i = 1; i <= n; i++)
			combs.add(Arrays.asList(i));
		
		for (int i = 2; i <= k; i++) {
			List<List<Integer>> newCombs = new ArrayList<List<Integer>>();
			for (int j = i; j <= n; j++) {
				for (List<Integer> comb : combs) {
					if (comb.get(comb.size() - 1) < j) {
						List<Integer> newComb = new ArrayList<Integer>(comb);
						newComb.add(j);
						newCombs.add(newComb);
					}
				}
			}
			combs = newCombs;
		}
		return combs;
	}
}