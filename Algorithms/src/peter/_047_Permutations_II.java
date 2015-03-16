package peter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example, [1,1,2] have the following unique permutations: [1,1,2],
 * [1,2,1], and [2,1,1].
 * 
 * @author ylkang Mar 11, 2015
 */
public class _047_Permutations_II {

	public static List<List<Integer>> permuteUnique(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (num == null) {
			return list;
		}
		List<Integer> tmpList = new ArrayList<Integer>();
		for (int inx = 0; inx < num.length; inx++) {
			tmpList.add(num[inx]);
		}
		list.add(tmpList);

		while ((perm(num, list)) > 0) {
		}
		return list;
	}

	private static int perm(int num[], List<List<Integer>> list) {

		for (int k = num.length - 1; k > 0; k--) {
			if (num[k] > num[k - 1]) {
				for (int inner = num.length - 1; inner > k - 1; inner--) {
					if (num[inner] > num[k - 1]) {
						int tmp = num[inner];
						num[inner] = num[k - 1];
						num[k - 1] = tmp;
						break;
					}
				}
				// reverse
				for (int inx = 0; inx <= (num.length - 1 - k) / 2; inx++) {
					int tmp = num[k + inx];
					num[k + inx] = num[num.length - 1 - inx];
					num[num.length - 1 - inx] = tmp;
				}
				List<Integer> tmpList = new ArrayList<Integer>();
				for (int inx = 0; inx < num.length; inx++) {
					tmpList.add(num[inx]);
				}
				list.add(tmpList);
				return 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out
				.println(permuteUnique(new int[] { -1, 2, -1, 2, 1, -1, 2, 1 }));
	}
}