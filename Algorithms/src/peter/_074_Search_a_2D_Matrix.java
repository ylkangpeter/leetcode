package peter;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row. For example,
 * 
 * Consider the following matrix:
 * 
 * <pre>
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * </pre>
 * 
 * Given target = 3, return true.
 * 
 * @author ylkang Feb 10, 2015
 */
public class _074_Search_a_2D_Matrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null) {
			return false;
		}

		int start = 0;
		int end = matrix.length - 1;

		int middle = 0;

		if (matrix[start][0] > target
				|| matrix[end][matrix[end].length - 1] < target) {
			return false;
		}

		while (start <= end) {
			middle = (start + end) >>> 1;
			if (matrix[middle][0] == target) {
				return true;
			} else if (matrix[middle][0] < target) {
				start = middle + 1;
			} else {
				end = middle - 1;
			}
		}

		int row = middle - 1;
		if (matrix[row][matrix[row].length - 1] < target) {
			return false;
		}

		start = 0;
		end = matrix[middle].length - 1;

		while (start <= end) {
			middle = (start + end) >>> 1;
			if (matrix[row][middle] == target) {
				return true;
			} else if (matrix[row][middle] < target) {
				start = middle + 1;
			} else {
				end = middle - 1;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] m = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
				{ 21, 23, 25, 70 } };
		System.out.println(searchMatrix(m, 11));
	}
}