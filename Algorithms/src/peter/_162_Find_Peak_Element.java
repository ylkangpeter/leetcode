package peter;

/**
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return
 * its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 * 
 * click to show spoilers.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _162_Find_Peak_Element {

	public int findPeakElement(int[] num) {
		if (num == null || num.length == 0 || num.length == 1) {
			return 0;
		}
		if (num.length == 2) {
			return num[0] > num[1] ? 0 : 1;
		}

		int start = 0;
		int end = num.length - 1;
		int middle = start / 2 + end / 2;
		while (true) {
			if (num[start] <= num[middle] && num[middle] >= num[end]) {
				if ((middle - start) == 1 && (end - middle) == 1) {
					return middle;
				} else if ((middle - start) == 1 && (middle == end)) {
					return middle;
				} else if ((end - middle) == 1 && (middle == start)) {
					return middle;
				}

				int tmpStart = start / 2 + middle / 2
						+ ((start % 2 + middle % 2) > 1 ? 1 : 0);
				int tmpEnd = end / 2 + middle / 2
						+ ((end % 2 + middle % 2) > 1 ? 1 : 0);
				if (num[tmpStart] <= num[middle] && num[middle] >= num[tmpEnd]) {
					start = tmpStart;
					end = tmpEnd;
					continue;
				} else if (num[tmpStart] > num[middle]) {
					end = middle;
					middle = tmpStart;
				} else if (num[tmpEnd] > num[middle]) {
					start = middle;
					middle = tmpEnd;
				}
			} else if (num[start] > num[middle]) {
				end = middle;
				middle = start;
			} else {
				start = middle;
				middle = end;
			}
		}
	}

}