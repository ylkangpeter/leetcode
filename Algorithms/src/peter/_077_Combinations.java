package peter;

import java.util.ArrayList;
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

	private static List<List<Integer>> list = new ArrayList<List<Integer>>();

	public static List<List<Integer>> combine(int n, int k) {
		if (k == 0 || n == 0 || n < k) {
			return list;
		}
		List<Integer> tmp = new ArrayList<Integer>();
		fill(0, k, 0, n, tmp);

		return list;
	}

	private static void fill(int curSelectNum, int totalSelectNum, int cur,
			int totalNumbers, List<Integer> tmpList) {
		if (curSelectNum == totalSelectNum) {
			list.add(tmpList);
		} else {
			for (int i = cur + 1; i <= totalNumbers; i++) {
				List<Integer> ll = new ArrayList<Integer>();
				ll.addAll(tmpList);
				ll.add(i);
				fill(curSelectNum + 1, totalSelectNum, i, totalNumbers, ll);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(combine(2, 1));
	}

}