package peter;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * You may assume all elements in the array are non-negative integers and fit in
 * the 32-bit signed integer range.
 * 
 * Credits: Special thanks to @porker2008 for adding this problem and creating
 * all test cases.
 * 
 * @author ylkang Mar 10, 2015
 */
public class _164_Maximum_Gap {

	public int maximumGap(int[] num) {
		if (num.length < 2) {
			return 0;
		}

		Integer[][] bucket = new Integer[num.length][32];

		Set<Integer> set = new HashSet<Integer>();

		for (Integer val : set) {
			
		}

		return 0;
	}

	public static int maximumGap_Exception(int[] num) {
		if (num.length < 2) {
			return 0;
		}

		BitSet set = new BitSet(Integer.MAX_VALUE);
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < num.length; i++) {
			set.set(num[i]);
			if (num[i] > max) {
				max = num[i];
			}
			if (num[i] < min) {
				min = num[i];
			}
		}

		int len = 0;
		int maxLen = 0;
		for (int i = min; i <= max; i++) {
			if (set.get(i)) {
				len++;
			} else {
				maxLen = maxLen > len ? maxLen : len;
				len = 0;
			}
		}
		return maxLen = maxLen > len ? maxLen - 1 : len - 1;
	}

	public static void main(String[] args) {
		System.out.println(maximumGap_Exception(new int[] { 1, 10000000 }));
	}
}