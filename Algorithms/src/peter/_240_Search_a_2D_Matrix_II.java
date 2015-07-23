package peter;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p/>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * <p/>
 * Consider the following matrix:
 * <p/>
 * <pre>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * </pre>
 * Given target = 5, return true.
 * Given target = 20, return false.
 * <p/>
 * Created by ylkang on 7/23/15.
 */
public class _240_Search_a_2D_Matrix_II {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) {
                return false;
            }
            int inx = Arrays.binarySearch(matrix[i], target);
            if (inx >= 0) {
                return true;
            }
        }

        return false;
    }

}
