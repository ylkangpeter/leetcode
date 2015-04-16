package peter;

import java.util.Arrays;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 * 
 * 100 4
 * 
 * 101 5 110 6 111 7
 * 
 * 1000 8 For example, given the range [5, 7], you should return 4.
 * 
 * @author ylkang Apr 16, 2015
 */
public class _201_Bitwise_AND_of_Numbers_Range {

	private static final long[] ARRAY = { 1, 2, 4, 8, 16, 32, 64, 128, 256,
			512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144,
			524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432,
			67108864, 134217728, 268435456, 536870912, 1073741824, 2147483648L };

	public static int rangeBitwiseAnd(int m, int n) {
		if (m == 0) {
			return 0;
		} else if (m >= n) {
			return m;
		} else {
			int start = Arrays.binarySearch(ARRAY, m);
			int end = Arrays.binarySearch(ARRAY, n);

			if (start >= 0) {

				if (end >= 0) {
					return 0;
				} else {
					end = -1 - end;
					if (end > start + 1) {
						return 0;
					} else {
						return (int) ARRAY[start];
					}
				}
			} else {
				start = -1 - start;
				if (end < 0) {
					end = -1 - end;
					if (end > start) {
						return rangeBitwiseAnd(m - (int) ARRAY[start - 1],
								(int) ARRAY[start] - 1);
					} else {
						return (int) ARRAY[start - 1]
								+ rangeBitwiseAnd(m - (int) ARRAY[start - 1], n
										- (int) ARRAY[start - 1]);
					}
				} else {
					return rangeBitwiseAnd(m - (int) ARRAY[start - 1],
							(int) ARRAY[start] - 1);
				}
			}
		}

	}

	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(2147483646, 2147483647));
		System.out.println(rangeBitwiseAnd(2, 3));
		System.out.println(rangeBitwiseAnd(1, 2));
		System.out.println(rangeBitwiseAnd(5, 7));
	}
}
