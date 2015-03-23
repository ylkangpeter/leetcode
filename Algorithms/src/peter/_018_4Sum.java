package peter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order.
 * (ie, a ≤ b ≤ c ≤ d) The solution set must not contain duplicate quadruplets.
 * 
 * <pre>
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *     A solution set is:
 *     (-1,  0, 0, 1)
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 * </pre>
 * 
 * @author peter Mar 23, 2015
 * 
 */
public class _018_4Sum {

	private static class Pair {
		int val1;
		int val2;

		int inx1;
		int inx2;

		Pair(int val1, int val2, int inx1, int inx2) {
			this.val1 = val1 > val2 ? val2 : val1;
			this.val2 = val1 > val2 ? val1 : val2;
			this.inx1 = inx1 > inx2 ? inx2 : inx1;
			this.inx2 = inx1 > inx2 ? inx1 : inx2;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + inx1;
			result = prime * result + inx2;
			result = prime * result + val1;
			result = prime * result + val2;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (inx1 != other.inx1)
				return false;
			if (inx2 != other.inx2)
				return false;
			if (val1 != other.val1)
				return false;
			if (val2 != other.val2)
				return false;
			return true;
		}

		public boolean isDup(Pair p) {
			if (inx1 == p.inx1 || inx2 == p.inx2 || inx1 == p.inx2
					|| inx2 == p.inx1) {
				return true;
			}
			return false;
		}

		@Override
		public String toString() {
			return val1 + "," + val2;
		}
	}

	public static List<List<Integer>> fourSum(int[] num, int target) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (num == null || num.length < 4) {
			return list;
		}

		Arrays.sort(num);

		// <val,Set>
		Map<Integer, Set<Pair>> map = new HashMap<Integer, Set<Pair>>();

		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int val = num[i] + num[j];
				Set<Pair> set = map.get(val);
				if (set == null) {
					set = new HashSet<Pair>();
				}
				set.add(new Pair(num[i], num[j], i, j));
				map.put(val, set);
			}
		}

		Set<String> set = new HashSet<String>();

		for (Iterator<Entry<Integer, Set<Pair>>> iter = map.entrySet()
				.iterator(); iter.hasNext();) {
			Entry<Integer, Set<Pair>> entry = iter.next();
			int val1 = entry.getKey();
			int val2 = target - val1;
			if (val1 == val2) {
				if (entry.getValue().size() >= 2) {
					for (Iterator<Pair> it1 = entry.getValue().iterator(); it1
							.hasNext();) {
						Pair p1 = it1.next();
						it1.remove();
						for (Iterator<Pair> it2 = entry.getValue().iterator(); it2
								.hasNext();) {
							Pair p2 = it2.next();
							if (p1.isDup(p2)) {
								continue;
							}
							List<Integer> tmp = new ArrayList<Integer>();
							tmp.add(p1.val1);
							tmp.add(p1.val2);
							tmp.add(p2.val1);
							tmp.add(p2.val2);
							Collections.sort(tmp);
							if (!set.contains(tmp.toString())) {
								list.add(tmp);
								set.add(tmp.toString());
							}
						}
					}
				}
			} else {
				if (map.get(val2) != null) {
					for (Iterator<Pair> it1 = entry.getValue().iterator(); it1
							.hasNext();) {
						Pair p1 = it1.next();

						for (Iterator<Pair> it2 = map.get(val2).iterator(); it2
								.hasNext();) {
							Pair p2 = it2.next();
							if (p1.isDup(p2)) {
								continue;
							}
							List<Integer> tmp = new ArrayList<Integer>();
							tmp.add(p1.val1);
							tmp.add(p1.val2);
							tmp.add(p2.val1);
							tmp.add(p2.val2);
							Collections.sort(tmp);
							if (!set.contains(tmp.toString())) {
								list.add(tmp);
								set.add(tmp.toString());
							}
						}
					}
				}
			}
			iter.remove();
		}

		return list;

	}

	public static void main(String[] args) {
		// System.out.println(fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
		// System.out.println(fourSum(new int[] { 0, 0, 0, 0 }, 0));
		System.out.println(fourSum(new int[] { -3, -1, 0, 2, 4, 5 }, 0));
	}
}