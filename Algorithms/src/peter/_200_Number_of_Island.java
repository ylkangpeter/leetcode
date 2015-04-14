package peter;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * <pre>
 * Example 1:
 * 
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * 
 * Example 2:
 * 
 * 11000
 * 11000
 * 00100
 * 00011
 * </pre>
 * 
 * @author ylkang Apr 9, 2015
 */
public class _200_Number_of_Island {

	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int island = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					trace(i, j, grid);
					island++;
				}
			}
		}

		return island;
	}

	private static void trace(int i, int j, char[][] grid) {
		if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length
				&& grid[i][j] == '1') {
			grid[i][j] = 't';
			trace(i - 1, j, grid);
			trace(i + 1, j, grid);
			trace(i, j - 1, grid);
			trace(i, j + 1, grid);
		}
	}

	public static void main(String[] args) {
		System.out.println(numIslands(new char[][] {
				{ '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' }, }));
		System.out.println(numIslands(new char[][] {
				{ '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' }, }));
	}
}
