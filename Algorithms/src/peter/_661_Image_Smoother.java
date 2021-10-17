package peter;

/**
 * 包含整数的二维矩阵 img 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度?(向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [[1,1,1],
 * [1,0,1],
 * [1,1,1]]
 * 输出:
 * [[0, 0, 0],
 * [0, 0, 0],
 * [0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 * <p>
 * <p>
 * 注意:
 * <p>
 * <p>
 * 给定矩阵中的整数范围为 [0, 255]。
 * 矩阵的长和宽的范围均为?[1, 150]。
 * <p>
 * https://leetcode-cn.com/problems/image-smoother
 */
public class _661_Image_Smoother {

    public int[][] imageSmoother(int[][] img) {
        int height = img.length, width = img[0].length;
        int[][] r = new int[height][width];
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                int sum = img[i][j];
                int num = 1;
                if (i > 0 && j > 0) {
                    sum += img[i - 1][j - 1];
                    num++;
                }
                if (i > 0) {
                    sum += img[i - 1][j];
                    num++;
                }
                if (i > 0 && j < width - 1) {
                    sum += img[i - 1][j + 1];
                    num++;
                }
                if (j > 0) {
                    sum += img[i][j - 1];
                    num++;
                }
                if (j < width - 1) {
                    sum += img[i][j + 1];
                    num++;
                }
                if (i < height - 1 && j > 0) {
                    sum += img[i + 1][j - 1];
                    num++;
                }
                if (i < height - 1) {
                    sum += img[i + 1][j];
                    num++;
                }
                if (i < height - 1 && j < width - 1) {
                    sum += img[i + 1][j + 1];
                    num++;
                }
                r[i][j] = sum / num;
            }
        return r;
    }
}