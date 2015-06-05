package peter;

import java.util.ArrayList;
import java.util.List;

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

	public String getPermutation(int n, int k) {
		if (k <= 0) {
			return "";
		}

		StringBuffer sb = new StringBuffer();
		List<Integer> list = new ArrayList<Integer>();

		int total = 1;
		for (int i = 1; i <= n; i++) {
			total *= i;
			list.add(i);
		}

		k--;
		for (int i = n; i > 0; i--) {
			total /= i;
			int m = k / total;
			k = k % total;
			sb.append(list.remove(m));
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		// System.out.println(new _060_Permutation_Sequence().getPermutation1(4,
		// 1));
		// System.out.println(new _060_Permutation_Sequence().getPermutation1(4,
		// 2));
		// System.out.println(new _060_Permutation_Sequence().getPermutation1(4,
		// 3));
		// System.out.println(new _060_Permutation_Sequence().getPermutation1(4,
		// 4));
		// System.out.println(new _060_Permutation_Sequence().getPermutation1(4,
		// 5));
		// System.out.println(new _060_Permutation_Sequence().getPermutation1(4,
		// 6));
		// System.out.println(new _060_Permutation_Sequence().getPermutation1(4,
		// 7));
		System.out.println(new _060_Permutation_Sequence()
				.getPermutation(4, 24));
		System.out
				.println(new _060_Permutation_Sequence().getPermutation(4, 9));
		System.out.println(new _060_Permutation_Sequence()
				.getPermutation(4, 10));
		System.out.println(new _060_Permutation_Sequence()
				.getPermutation(4, 11));
		System.out.println(new _060_Permutation_Sequence()
				.getPermutation(4, 12));
		System.out.println(new _060_Permutation_Sequence()
				.getPermutation(4, 13));
		System.out.println(new _060_Permutation_Sequence()
				.getPermutation(4, 14));
		System.out.println(new _060_Permutation_Sequence()
				.getPermutation(4, 15));
		System.out.println(new _060_Permutation_Sequence()
				.getPermutation(4, 16));
		System.out.println(new _060_Permutation_Sequence()
				.getPermutation(4, 17));
		System.out.println(new _060_Permutation_Sequence()
				.getPermutation(4, 18));
		System.out.println(new _060_Permutation_Sequence()
				.getPermutation(4, 19));
		System.out.println(new _060_Permutation_Sequence()
				.getPermutation(4, 20));
		System.out.println(new _060_Permutation_Sequence()
				.getPermutation(4, 21));
		System.out.println(new _060_Permutation_Sequence()
				.getPermutation(4, 22));
		System.out.println(new _060_Permutation_Sequence()
				.getPermutation(4, 23));
		System.out.println(new _060_Permutation_Sequence()
				.getPermutation(4, 24));
	}
}