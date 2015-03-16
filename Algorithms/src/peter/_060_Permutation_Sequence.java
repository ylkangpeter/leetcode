package peter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, We get the
 * following sequence (ie, for n = 3):
 * 
 * <pre>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * </pre>
 * 
 * Given n and k, return the kth permutation sequence.
 * 
 * @author ylkang Mar 11, 2015
 */
public class _060_Permutation_Sequence {

	// 1,2,3,4,5,6,7,8,9,10,11,12,13
	private static int[] mask = { 0, 1, 2, 6, 24, 120, 720, 5040, 40320,
			362880, 3628800, 39916800, 479001600 };

	private static Map<Integer, Integer> maskMap = new HashMap<Integer, Integer>();

	static {
		maskMap.put(1, 1);
		maskMap.put(2, 2);
		maskMap.put(6, 3);
		maskMap.put(24, 4);
		maskMap.put(120, 5);
		maskMap.put(720, 6);
		maskMap.put(5040, 7);
		maskMap.put(40320, 8);
		maskMap.put(362880, 9);
		maskMap.put(3628800, 10);
		maskMap.put(39916800, 11);
		maskMap.put(479001600, 12);
	}

	public static String getPermutation(int n, int k) {
		// StringBuffer sb = new StringBuffer();
		int[] nums = new int[n];

		int numInx = 0;
		int inx = Arrays.binarySearch(mask, k);
		if (inx < 0) {
			inx = -inx - 1;
		}
		if (inx == 0) {
			return "";
		}
		for (int i = 1; i <= n - inx; i++) {
			nums[i - 1] = i;
			numInx = i;
			// sb.append(i);
		}

		LinkedList<Integer> pool = new LinkedList<Integer>();
		for (int i = inx - 1; i >= 0; i--) {
			pool.add(n - i);
		}

		int rest = k;

		while (true) {

			if (rest == 1) {
				for (int i = 0; i < pool.size(); i++) {
					nums[numInx + i] = pool.get(i);
				}
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < nums.length; i++) {
					sb.append(nums[i]);
				}
				return sb.toString();
			}

			int offset = 1;
			while (mask[inx - 1] * offset < rest) {
				offset++;
			}

			// sb.append(pool.get(offset - 1));

			rest = rest - mask[inx - 1] * (offset - 1) - 1;

			if (rest == 0) {
				nums[numInx++] = pool.get(offset - 2);
				pool.remove(offset - 2);
				for (int i = pool.size() - 1; i >= 0; i--) {
					nums[numInx++] = pool.get(i);
				}
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < nums.length; i++) {
					sb.append(nums[i]);
				}
				return sb.toString();
			} else {
				nums[numInx++] = pool.get(offset - 1);
				pool.remove(offset - 1);

				inx = Arrays.binarySearch(mask, rest);
				if (inx < 0) {
					inx = -inx - 1;
				}
			}
		}

	}

	public static void nextPermutation(int[] num) {

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
				return;
			}
		}
		for (int k = 0; k <= (num.length - 1) / 2; k++) {
			int tmp = num[k];
			num[k] = num[num.length - 1 - k];
			num[num.length - 1 - k] = tmp;
		}
	}

	public static void main(String[] args) {
		System.out.println(getPermutation(4, 1));
		System.out.println(getPermutation(4, 2));
		System.out.println(getPermutation(4, 3));
		System.out.println(getPermutation(4, 4));
		System.out.println(getPermutation(4, 5));
		System.out.println(getPermutation(4, 6));
		System.out.println(getPermutation(4, 7));
		System.out.println(getPermutation(4, 8));
		System.out.println(getPermutation(4, 9));
		System.out.println(getPermutation(4, 10));
		System.out.println(getPermutation(4, 11));
		System.out.println(getPermutation(4, 12));
		System.out.println(getPermutation(4, 13));
		System.out.println(getPermutation(4, 14));
		System.out.println(getPermutation(4, 15));
		System.out.println(getPermutation(4, 16));
		System.out.println(getPermutation(4, 17));
		System.out.println(getPermutation(4, 18));
		System.out.println(getPermutation(4, 19));
		System.out.println(getPermutation(4, 20));
		System.out.println(getPermutation(4, 21));
		System.out.println(getPermutation(4, 22));
		System.out.println(getPermutation(4, 23));
		System.out.println(getPermutation(4, 24));
	}
}