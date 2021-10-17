package peter;

/**
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * <p>
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * 输出：16
 * 解释：它的周长是上面图片中的 16 个黄色的边
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[1]]
 * 输出：4
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：grid = [[1,0]]
 * 输出：4
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 100
 * grid[i][j] 为 0 或 1
 * <p>
 * https://leetcode-cn.com/problems/island-perimeter
 */
public class _463_Island_Perimeter {

    public int islandPerimeter(int[][] grid) {
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) {
                        counter++;
                    }
                    if (i == grid.length - 1 || grid[i + 1][j] == 0) {
                        counter++;
                    }
                    if (j == 0 || grid[i][j - 1] == 0) {
                        counter++;
                    }
                    if (j == grid[0].length - 1 || grid[i][j + 1] == 0) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
}