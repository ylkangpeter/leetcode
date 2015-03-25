package peter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤
 * b ≤ c) The solution set must not contain duplicate triplets. For example,
 * given array S = {-1 0 1 2 -1 -4},
 * 
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 * 
 * @author ylkang Feb 17, 2015
 */
public class _015_3Sum {

	public static List<List<Integer>> threeSum(int[] num) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (num == null || num.length < 3) {
			return list;
		}

		Arrays.sort(num);
		if (num[0] > 0 || num[num.length - 1] < 0) {
			return list;
		}

		final int TARGET = 0;

		long pre = Integer.MAX_VALUE + 1;
		for (int i = 0; i < num.length; i++) {
			if (pre == num[i]) {
				continue;
			} else {
				pre = num[i];
			}
			int k = num.length - 1;
			for (int j = i + 1; j < k;) {
				if (num[i] + num[j] + num[k] == TARGET) {
					List<Integer> tmp = new ArrayList<Integer>();
					tmp.add(num[i]);
					tmp.add(num[j]);
					tmp.add(num[k]);
					list.add(tmp);
					int tmpK = num[k];
					while (k > j && num[k] == tmpK) {
						k--;
					}
					int tmpJ = num[j];
					while (k > j && num[j] == tmpJ) {
						j++;
					}
				} else if (num[i] + num[j] + num[k] > TARGET) {
					int tmpK = num[k];
					while (k > j && num[k] == tmpK) {
						k--;
					}
				} else {
					int tmpJ = num[j];
					while (k > j && num[j] == tmpJ) {
						j++;
					}
				}
			}
		}
		return list;
	        
    }

	public static void main(String[] args) {
		System.out
				.println(threeSum(new int[] { -7, -1, -1, 0, 0, 1, 1, 2, 3 }));
	}
}