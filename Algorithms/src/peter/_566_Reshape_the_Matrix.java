package peter;

/**
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个?m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 * <p>
 * 给你一个由二维数组 mat 表示的?m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * <p>
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * <p>
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：mat = [[1,2],[3,4]], r = 2, c = 4
 * 输出：[[1,2],[3,4]]
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * -1000 <= mat[i][j] <= 1000
 * 1 <= r, c <= 300
 * <p>
 * https://leetcode-cn.com/problems/reshape-the-matrix
 */
public class _566_Reshape_the_Matrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c == mat.length * mat[0].length) {
            int[][] newMat = new int[r][c];
            for (int i = 0; i < newMat.length; i++) {
                for (int j = 0; j < newMat[0].length; j++) {
                    int total = i * c + j;
                    newMat[i][j] =
                            mat[(i * c + j) / mat[0].length][(i * c + j) % mat[0].length];
                }
            }
            return newMat;
        } else {
            return mat;
        }
    }

    public static void main(String[] args) {
        new _566_Reshape_the_Matrix().matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4);
    }
}