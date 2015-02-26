package peter;

public class _063_Unique_Paths_II {

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null) {
			return 0;
		}

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
			return 0;
		}
		obstacleGrid[0][0] = 1;

		boolean isBlock = false;
		for (int i = 1; i < m; i++) {
			if (isBlock) {
				obstacleGrid[i][0] = -1;
			} else {
				if (obstacleGrid[i][0] == 1) {
					isBlock = true;
					obstacleGrid[i][0] = -1;
				} else {
					obstacleGrid[i][0] = 1;
				}
			}
		}

		isBlock = false;
		for (int i = 1; i < n; i++) {
			if (isBlock) {
				obstacleGrid[0][i] = -1;
			} else {
				if (obstacleGrid[0][i] == 1) {
					isBlock = true;
					obstacleGrid[0][i] = -1;
				} else {
					obstacleGrid[0][i] = 1;
				}
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] != 0) {
					obstacleGrid[i][j] = -1;
					continue;
				}
				if (obstacleGrid[i - 1][j] != -1
						&& obstacleGrid[i][j - 1] != -1) {
					obstacleGrid[i][j] = obstacleGrid[i - 1][j]
							+ obstacleGrid[i][j - 1];
				} else if (obstacleGrid[i - 1][j] != -1) {
					obstacleGrid[i][j] = obstacleGrid[i - 1][j];
				} else if (obstacleGrid[i][j - 1] != -1) {
					obstacleGrid[i][j] = obstacleGrid[i][j - 1];
				} else {
					obstacleGrid[i][j] = -1;
				}
			}
		}
		return obstacleGrid[m - 1][n - 1] > 0 ? obstacleGrid[m - 1][n - 1] : 0;
	}

	public static void main(String[] args) {
		System.out.println(uniquePathsWithObstacles(new int[][] { { 0, 0 },
				{ 1, 1 }, { 0, 0 } }));
	}
}