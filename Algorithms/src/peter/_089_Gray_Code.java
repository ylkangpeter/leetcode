package peter;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * <pre>
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * </pre>
 * 
 * Note: For a given n, a gray code sequence is not uniquely defined.
 * 
 * For example, [0,2,3,1] is also a valid gray code sequence according to the
 * above definition.
 * 
 * For now, the judge is able to judge based on one instance of gray code
 * sequence. Sorry about that.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _089_Gray_Code {

	public List<Integer> grayCode(int n) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(0);

		for (int i = 0; i < n; i++) {
			int val = (1 << i);
			int size = list.size();
			for (int j = size - 1; j >= 0; j--) {
				list.add(val + list.get(j));
			}
		}
		return list;
	}

}