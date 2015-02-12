package peter;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * @author ylkang Feb 10, 2015
 */
public class _128_Longest_Consecutive_Sequence {

	public static int longestConsecutive(int[] num) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < num.length; i++) {
			set.add(num[i]);
		}

		int max = 0;
		while (!set.isEmpty()) {
			int val = set.iterator().next();
			set.remove(val);
			int counter = 1;
			// left
			int tmp = val - 1;
			while (set.contains(tmp)) {
				counter++;
				set.remove(tmp);
				tmp--;
			}
			// right
			tmp = val + 1;
			while (set.contains(tmp)) {
				counter++;
				set.remove(tmp);
				tmp++;
			}
			if (counter > max) {
				max = counter;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[] { 1, 2, 3, 33, 44, 5,
				6, 7, 8, 9, 4 }));
	}
}