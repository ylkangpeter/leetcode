package peter;

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

		// radix sort
		if (num == null || num.length < 2) {
			return 0;
		}

		int mask = 1;
		int[] tmpNum = new int[num.length];

		for (int i = 0; i < 32; i++) {
			int[] tmp = num;
			num = tmpNum;
			tmpNum = tmp;

			int start = 0;
			int end = num.length - 1;

			for (int j = 0; j < num.length; j++) {
				if ((tmpNum[j] & mask) == 0) {
					num[start++] = tmpNum[j];
				}
				if ((tmpNum[tmpNum.length - 1 - j] & mask) != 0) {
					num[end--] = tmpNum[tmpNum.length - 1 - j];
				}
			}
			mask <<= 1;

		}

		int max = Integer.MIN_VALUE;
		for (int i = 1; i < num.length; i++) {
			max = Math.max(max, num[i] - num[i - 1]);
		}
		return max;
	}

	public int maximumGap1(int[] num) {
		int len = num.length;
		int mask = 1;
		int[] num2 = new int[len];
		for (int i = 0; i < 31; i++) {
			int[] tmp = num;
			num = num2;
			num2 = tmp;
			int s = 0;
			int e = len - 1;
			for (int j = 0; j < len; j++) {
				if ((num2[j] & mask) == 0)
					num[s++] = num2[j];
				if ((num2[len - 1 - j] & mask) > 0)
					num[e--] = num2[len - 1 - j];
			}
			mask <<= 1;
		}
		int max = 0;
		for (int i = 1; i < len; i++) {
			max = Math.max(max, num[i] - num[i - 1]);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(new _164_Maximum_Gap().maximumGap(new int[] { 1,
				10000000 }));
	}
}