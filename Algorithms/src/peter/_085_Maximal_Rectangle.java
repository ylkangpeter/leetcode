package peter;

/**
 * 
 * @author ylkang Jun 3, 2015
 */
public class _085_Maximal_Rectangle {
	public int maximalRectangle(char[][] matrix) {
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
			for (int j = 0; j < n; j++) { // compute height (can do this from
											// either side)
				if (matrix[i][j] == '1')
					height[j]++;
				else
					height[j] = 0;
			}
			for (int j = 0; j < n; j++) { // compute left (from left to right)
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
			for (int j = 0; j < n; j++)
				maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
		}
		return maxA;
	}

	public static void main(String[] args) {
//		System.out.println(new _085_Maximal_Rectangle()
//				.maximalRectangle(new char[][] {
//						{ '1', '1', '1', '1', '1', '1' },
//						{ '1', '1', '1', '1', '0', '1' },
//						{ '1', '1', '1', '1', '0', '1' } }));
		System.out.println(new _085_Maximal_Rectangle()
				.maximalRectangle(new char[][] {
						{ '0', '0', '1', '1', '0', '1' },
						{ '1', '1', '1', '1', '0', '1' },
						{ '1', '1', '1', '1', '0', '1' } }));
	}
}