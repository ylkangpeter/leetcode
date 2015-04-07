package peter;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author ylkang Apr 7, 2015
 */
public class _198_House_Robber {

	// max[i] = num[i] + max(max[i-2],max[i-3])

	public static int rob(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		} else if (num.length < 3) {
			int max = num[0];
			for (int i = 1; i < num.length; i++) {
				max = Math.max(max, num[i]);
			}
			return max;
		}

		int[] max = new int[num.length];
		max[0] = num[0];
		max[1] = num[1];
		max[2] = num[2] + num[0];

		int result = Math.max(max[1], max[2]);

		for (int i = 3; i < num.length; i++) {
			max[i] = num[i] + Math.max(max[i - 2], max[i - 3]);
			if (result < max[i]) {
				result = max[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(rob(new int[] { 1, 2, 3, 4, 5 }));
	}
}
