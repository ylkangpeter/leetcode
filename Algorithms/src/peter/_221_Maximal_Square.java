package peter;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing all 1's and return its area.
 * 
 * For example, given the following matrix:
 * 
 * <pre>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * </pre>
 * 
 * Return 4.
 * 
 * @author ylkang Jun 3, 2015
 */
public class _221_Maximal_Square {

	public int maximalSquare(char[][] matrix) {

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[] left = new int[n];
		int[] right = new int[n];
		int[] height = new int[n];

		for (int i = 0; i < right.length; i++) {
			right[i] = n;
		}

		int maxA = 0;
		for (int i = 0; i < m; i++) {
			int cur_left = 0, cur_right = n;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1')
					height[j]++;
				else
					height[j] = 0;
			}
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1')
					left[j] = Math.max(left[j], cur_left);
				else {
					left[j] = 0;
					cur_left = j + 1;
				}
			}
			// compute right (from right to left)
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1')
					right[j] = Math.min(right[j], cur_right);
				else {
					right[j] = n;
					cur_right = j;
				}
			}
			// compute the area of rectangle (can do this from either side)
			for (int j = 0; j < n; j++) {
				int w = right[j] - left[j];
				int h = height[j];
				int line = Math.min(w, h);
				maxA = Math.max(maxA, line * line);
			}
		}
		return maxA;

	}
}
