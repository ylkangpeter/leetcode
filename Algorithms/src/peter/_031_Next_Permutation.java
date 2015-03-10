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

	public static void nextPermutation(int[] num) {
		for (int outer = num.length - 1; outer >= 0; outer--) {
			for (int i = outer; i >= 0; i--) {
				if (num[outer] > num[i]) {
					int tmp = num[i];
					num[i] = num[outer];
					num[outer] = tmp;

					for (int k = 0; k < (num.length - 1 - i) / 2; k++) {
						tmp = num[k + i + 1];
						num[k + i + 1] = num[num.length - 1 - k];
						num[num.length - 1 - k] = tmp;
					}
					return;
				}
			}
		}
		for (int k = 0; k < (num.length) / 2; k++) {
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
		n = new int[] { 4, 2, 0, 2, 3, 2, 0 };
		nextPermutation(n);
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + ",");
		}
	}
}