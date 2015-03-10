package peter;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * <pre>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * </pre>
 * 
 * @author ylkang Mar 10, 2015
 */
public class _031_Next_Permutation {

	/**
	 * 
	 * <a href="http://en.wikipedia.org/wiki/Permutation#k-permutations_of_n">
	 * http://en.wikipedia.org/wiki/Permutation#k-permutations_of_n</a>
	 * 
	 * The following algorithm generates the next permutation lexicographically
	 * after a given permutation. It changes the given permutation in-place.
	 * 
	 * <pre>
	 * <li>Find the largest index k such that a[k] < a[k + 1]. If no such index
	 * exists, the permutation is the last permutation.</li> 
	 * 
	 * <li>Find the largest index l greater than k such that a[k] < a[l]. Swap the value of
	 * a[k] with that of a[l].</li> 
	 * 
	 * <li>Reverse the sequence from a[k + 1] up to
	 * and including the final element a[n].</li>
	 * </pre>
	 * 
	 * @param num
	 */
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
		int[] n = new int[] { 1, 2, 3 };
		nextPermutation(n);
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + ",");
		}
		System.out.println();
		n = new int[] { 3, 2, 1 };
		nextPermutation(n);
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + ",");
		}
		System.out.println();
		n = new int[] { 1, 1, 5 };
		nextPermutation(n);
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + ",");
		}
		System.out.println();
		n = new int[] { 1, 3, 2 };
		nextPermutation(n);
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + ",");
		}
		System.out.println();
		n = new int[] { 2, 3, 1 };
		nextPermutation(n);
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + ",");
		}
		System.out.println();
		n = new int[] { 4, 2, 0, 2, 3, 2, 0 };
		nextPermutation(n);
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + ",");
		}
		System.out
				.println("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,51,50,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100"
						.equals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100"));
	}
}