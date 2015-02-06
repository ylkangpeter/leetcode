package peter;


/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * @author ylkang Feb 5, 2015
 */
public class _062_Unique_Paths {

	public int uniquePaths(int m, int n) {
		int[][] a = new int[m][n];
		for (int i = 0; i < m; i++) {
			a[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			a[0][i] = 1;
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] != 0) {
					continue;
				}
				a[i][j] = a[i - 1][j] + a[i][j - 1];
			}
		}
		return a[m - 1][n - 1];
	}

}