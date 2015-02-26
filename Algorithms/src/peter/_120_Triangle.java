package peter;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * <pre>
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * </pre>
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note: Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 * 
 * @author ylkang Feb 17, 2015
 */
public class _120_Triangle {

	public static int minimumTotal(List<List<Integer>> triangle) {

		if (triangle == null || triangle.isEmpty() || triangle.get(0).isEmpty()) {
			return 0;
		}

		if (triangle.size() == 1) {
			return triangle.get(0).get(0);
		}

		for (int i = triangle.size() - 1; i >= 1; i--) {
			List<Integer> lower = triangle.get(i);
			List<Integer> higher = triangle.get(i - 1);
			for (int j = 0; j < higher.size(); j++) {
				higher.set(
						j,
						higher.get(j)
								+ Math.min(lower.get(j), lower.get(j + 1)));
			}
		}

		return triangle.get(0).get(0);

	}

	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		List<Integer> b = new ArrayList<Integer>();
		b.add(2);
		b.add(3);
		triangle.add(a);
		triangle.add(b);
		System.out.println(minimumTotal(triangle));
	}
}