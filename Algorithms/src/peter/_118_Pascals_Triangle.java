package peter;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 * 
 * @author ylkang Feb 5, 2015
 */
public class _118_Pascals_Triangle {
	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();

		if (numRows == 0) {
			return list;
		}
		List<Integer> _1st = new ArrayList<Integer>();
		_1st.add(1);
		list.add(_1st);

		for (int i = 1; i < numRows; i++) {
			List<Integer> tmp = new ArrayList<Integer>();
			List<Integer> pre = list.get(i - 1);
			tmp.add(1);
			for (int j = 0; j < pre.size() - 1; j++) {
				tmp.add(pre.get(j) + pre.get(j + 1));
			}
			tmp.add(1);
			list.add(tmp);
		}
		return list;
	}
}