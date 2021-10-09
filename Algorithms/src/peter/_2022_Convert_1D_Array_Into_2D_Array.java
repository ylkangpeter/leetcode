/**
 * project info: leetcode-peter
 */

package peter;

/**
 * You are given a 0-indexed 1-dimensional (1D) integer array original, and two integers, m and n. You are tasked
 * with creating a 2-dimensional (2D) array with m rows and n columns using all the elements from original.
 * <p>
 * The elements from indices 0 to n - 1 (inclusive) of original should form the first row of the constructed 2D
 * array, the elements from indices n to 2 * n - 1 (inclusive) should form the second row of the constructed 2D
 * array, and so on.
 * <p>
 * Return an m x n 2D array constructed according to the above procedure, or an empty 2D array if it is impossible.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: original = [1,2,3,4], m = 2, n = 2
 * Output: [[1,2],[3,4]]
 * Explanation:
 * The constructed 2D array should contain 2 rows and 2 columns.
 * The first group of n=2 elements in original, [1,2], becomes the first row in the constructed 2D array.
 * The second group of n=2 elements in original, [3,4], becomes the second row in the constructed 2D array.
 * Example 2:
 * <p>
 * Input: original = [1,2,3], m = 1, n = 3
 * Output: [[1,2,3]]
 * Explanation:
 * The constructed 2D array should contain 1 row and 3 columns.
 * Put all three elements in original into the first row of the constructed 2D array.
 * Example 3:
 * <p>
 * Input: original = [1,2], m = 1, n = 1
 * Output: []
 * Explanation:
 * There are 2 elements in original.
 * It is impossible to fit 2 elements in a 1x1 2D array, so return an empty 2D array.
 * Example 4:
 * <p>
 * Input: original = [3], m = 1, n = 2
 * Output: []
 * Explanation:
 * There is 1 element in original.
 * It is impossible to make 1 element fill all the spots in a 1x2 2D array, so return an empty 2D array.
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= original.length <= 5 * 104
 * 1 <= original[i] <= 105
 * 1 <= m, n <= 4 * 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-1d-array-into-2d-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _2022_Convert_1D_Array_Into_2D_Array {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][];
        } else {
            int[][] result = new int[m][n];

            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    result[row][col] = original[row * n + col];
                }
            }
            return result;
        }
    }
}
