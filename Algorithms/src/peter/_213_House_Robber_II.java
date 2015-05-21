package peter;

public class _213_House_Robber_II {

	public int rob(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		} else if (nums.length < 3) {
			int max = nums[0];
			for (int i = 1; i < nums.length; i++) {
				max = Math.max(max, nums[i]);
			}
			return max;
		}

		int max0 = calcMax(nums, 0);
		int max1 = calcMax(nums, 1);
		int max2 = calcMax(nums, 2);

		return Math.max(Math.max(max0, max1), max2);
	}

	private int calcMax(int[] nums, int offset) {
		int[] max_0 = new int[nums.length];
		max_0[(0 + offset) % nums.length] = nums[(0 + offset) % nums.length];
		max_0[(1 + offset) % nums.length] = 0;
		max_0[(2 + offset) % nums.length] = nums[(2 + offset) % nums.length]
				+ max_0[(0 + offset) % nums.length];
		int m0 = max_0[(2 + offset) % nums.length];
		for (int i = 3; i < nums.length - 1; i++) {
			int inx = (i + offset) % nums.length;
			max_0[inx] = nums[inx]
					+ Math.max(max_0[(i - 2 + offset) % nums.length],
							max_0[(i - 3 + offset) % nums.length]);
			m0 = Math.max(m0, max_0[inx]);
		}
		return m0;
	}

	public static void main(String[] args) {
		System.out.println(new _213_House_Robber_II().rob(new int[] { 1, 1, 1,
				1 }));
		System.out.println(new _213_House_Robber_II().rob(new int[] { 4, 8, 7,
				2, 3, 6, 9, 1 }));
	}
}
