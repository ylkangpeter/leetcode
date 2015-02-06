package peter;

import java.math.BigInteger;
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
public class _119_Pascals_Triangle_II {

	private int calc(int base, int up) {
		if (up == 0 || up == base) {
			return 1;
		}
		return (calc2(new BigInteger(String.valueOf(base)), new BigInteger(
				String.valueOf(base - up + 1))).divide(calc2(new BigInteger(
				String.valueOf(up)), new BigInteger(String.valueOf(1)))))
				.intValue();

	}

	private BigInteger calc2(BigInteger start, BigInteger end) {
		if (start.equals(end)) {
			return end;
		}
		return start.multiply(calc2(start.add(new BigInteger("-1")), end));
	}

	public List<Integer> getRow(int rowIndex) {

		List<Integer> list = new ArrayList<Integer>();

		if (rowIndex == 0) {
			list.add(1);
			return list;
		}

		int totalSize = rowIndex + 1;
		for (int i = 0; i < totalSize; i++) {
			list.add(0);
		}

		for (int i = 0; i < totalSize / 2 + 1; i++) {
			int val = calc(rowIndex, i);
			list.set(i, val);
			list.set(totalSize - i - 1, val);
		}
		return list;
	}

}