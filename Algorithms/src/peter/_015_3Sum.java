package peter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			Integer counter = m.get(num[i]);
			if (counter == null) {
				counter = 0;
			}
			m.put(num[i], counter + 1);
		}

		int start = 0;
		int end = num.length - 1;
		while (start < end) {
			List<Integer> tmp = new ArrayList<Integer>();
			if (num[end] < 0 || num[start] > 0) {
				break;
			} else if (num[end] == 0 && num[start] == 0) {
				if (m.get(0) >= 3) {
					tmp.add(0);
					tmp.add(0);
					tmp.add(0);
					list.add(tmp);
					start++;
					break;
				}
			} else {

				if (num[end] * 2 + num[start] < 0) {
					start++;
					continue;
				} else if (num[end] + num[start] * 2 > 0) {
					end--;
					continue;
				}
				
				
				int c = 0 - num[start] - num[end];
				tmp.add(num[start]);
				tmp.add(num[end]);
				tmp.add(c);
				if (c == num[start] || c == num[end]) {
					if (m.get(c) >= 2) {
						list.add(tmp);
						start++;
					}
				} else {
					if (m.get(c) != null) {
						list.add(tmp);
						start++;
					}
				}
			}
		}

		// if (m.get(num[start]) != null) {
		// if(num[start]+num[end])
		// } else {
		// start++;
		// }

		return list;
	}

	public static void main(String[] args) {
		System.out
				.println(threeSum(new int[] { -7, -1, -1, 0, 0, 1, 1, 2, 3 }));
	}
}