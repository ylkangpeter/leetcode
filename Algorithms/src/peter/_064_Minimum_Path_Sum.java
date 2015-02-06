package peter;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _064_Minimum_Path_Sum {

	public int minPathSum(int[][] grid) {

		if (grid == null) {
			return 0;
		}

		int height = grid.length;
		int width = grid[0].length;

		for (int i = 1; i < height; i++) {
			grid[i][0] = grid[i - 1][0] + grid[i][0];
		}

		for (int i = 1; i < width; i++) {
			grid[0][i] = grid[0][i - 1] + grid[0][i];
		}

		for (int j = 1; j < width; j++) {
			for (int i = 1; i < height; i++) {
				grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
			}
		}

		return grid[height - 1][width - 1];
	}

}