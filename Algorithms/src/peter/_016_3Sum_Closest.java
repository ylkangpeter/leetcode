package peter;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author ylkang Feb 17, 2015
 */
public class _016_3Sum_Closest {

	public static int threeSumClosest(int[] num, int target) {

		if (num == null || num.length < 3) {
			return 0;
		}

		Arrays.sort(num);

		int minVal = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < num.length; i++) {
			int k = num.length - 1;
			for (int j = i + 1; j < k;) {
				int val = num[i] + num[j] + num[k] - target;
				boolean isNeg = false;
				if (val < 0) {
					isNeg = true;
				}
				val = Math.abs(val);

				if (val == 0) {
					return target;
				} else if (val < min) {
					min = val;
					minVal = num[i] + num[j] + num[k];
					if (isNeg) {
						j++;
					} else {
						k--;
					}
				} else {
					if (isNeg) {
						j++;
					} else {
						k--;
					}
				}
			}
		}
		return minVal;
	}

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[] { -1, 2, 1, -4 }, 6));
	}
}