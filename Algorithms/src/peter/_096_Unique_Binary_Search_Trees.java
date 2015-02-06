package peter;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1...n?
 * 
 * For example, Given n = 3, there are a total of 5 unique BST's.
 * 
 * <pre>
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * </pre>
 * 
 * @author ylkang Feb 5, 2015
 */
public class _096_Unique_Binary_Search_Trees {

	public int numTrees(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		int[] vals = new int[n + 1];
		vals[0] = 1;
		vals[1] = 1;
		vals[2] = 2;
		for (int i = 3; i <= n; i++) {
			int tmp = 0;
			for (int j = 0; j < i; j++) {
				tmp += vals[j] * vals[i - j - 1];
			}
			vals[i] = tmp;
		}
		return vals[n];
	}

}
