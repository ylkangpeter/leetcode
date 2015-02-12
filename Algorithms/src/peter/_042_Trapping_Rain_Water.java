package peter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * 
 * @author ylkang Feb 10, 2015
 */
public class _042_Trapping_Rain_Water {

	public static int trap_exceed_time_limit(int[] A) {
		if (A == null || A.length == 1 || A.length == 0) {
			return 0;
		}

		int i = 0;
		for (; i < A.length; i++) {
			if (A[i] != 0) {
				break;
			}
		}

		int total = 0;
		int tmpTotal = 0;
		int tmpBlock = 0;

		int preHigh = A[i];
		int preHighInx = i;

		int tmpListStartInx = 0;

		List<Integer> list = new ArrayList<Integer>();

		i++;
		for (; i < A.length; i++) {
			if (A[i] >= preHigh) {
				total += preHigh * (i - preHighInx - 1) - tmpBlock;
				tmpTotal = 0;
				tmpBlock = 0;
				preHigh = A[i];
				preHighInx = i;
				list.clear();
			} else {
				if (A[i] == 0) {
					continue;
				}
				if (list.isEmpty()) {
					tmpListStartInx = i;
					list.add(A[i]);
					tmpBlock = A[i];
				} else {
					if (list.get(0) <= A[i]) {
						tmpTotal = (i - preHighInx - 1) * A[i] - tmpBlock;
						tmpBlock += A[i];
						list.clear();
					} else if (list.get(list.size() - 1) >= A[i]) {
						if (A[i - 1] == 0) {
							tmpTotal += A[i];
						}
						tmpBlock += A[i];
					} else {
						int inx = Collections.binarySearch(list, A[i],
								new Comparator<Integer>() {
									public int compare(Integer o1, Integer o2) {
										return o1 > o2 ? -1 : 1;
									}
								});
						if (inx < 0) {
							inx = -1 * (inx + 1);
						}
						tmpTotal += (i - inx - tmpListStartInx) * A[i];
						for (int m = list.size() - 1; m >= inx; m--) {
							tmpTotal -= list.get(m);
						}
						list = list.subList(0, inx);

					}
					list.add(A[i]);
				}
			}
		}
		total += tmpTotal;
		return total;
	}

	public static int trap(int[] A) {
		if (A == null || A.length == 1 || A.length == 0) {
			return 0;
		}
		return trap(A, 0, A.length - 1);
	}

	private static int trap(int[] A, int startInx, int endInx) {
		if (startInx == endInx || startInx == endInx - 1) {
			return 0;
		}

		int[] bigestTwoInx = findBigestTwo(A, startInx, endInx);

		int start = bigestTwoInx[0];
		int end = bigestTwoInx[1];
		if (bigestTwoInx[0] > bigestTwoInx[1]) {
			start = bigestTwoInx[1];
			end = bigestTwoInx[0];
		}

		int bar = A[start] > A[end] ? A[end] : A[start];
		int total = 0;
		for (int i = start + 1; i < end; i++) {
			total += bar - A[i];
		}

		return total + trap(A, startInx, start) + trap(A, end, endInx);
	}

	private static int[] findBigestTwo(int[] A, int startInx, int endInx) {
		int[] result = new int[2];
		result[0] = startInx;
		result[1] = startInx + 1;
		int _1st = A[startInx];
		int _2nd = A[startInx + 1];

		if (_1st < _2nd) {
			_1st = A[startInx + 1];
			_2nd = A[startInx];
			result[0] = startInx + 1;
			result[1] = startInx;
		}

		for (int i = startInx + 2; i <= endInx; i++) {
			if (A[i] >= _1st) {
				_2nd = _1st;
				_1st = A[i];
				result[1] = result[0];
				result[0] = i;
			} else if (A[i] > _2nd) {
				_2nd = A[i];
				result[1] = i;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out
				.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
	}
}