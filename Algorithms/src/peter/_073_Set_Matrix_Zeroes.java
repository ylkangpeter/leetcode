package peter;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * click to show follow up.
 * 
 * Follow up: Did you use extra space? A straight forward solution using O(mn)
 * space is probably a bad idea. A simple improvement uses O(m + n) space, but
 * still not the best solution. Could you devise a constant space solution?
 * 
 * @author ylkang Feb 15, 2015
 */
public class _073_Set_Matrix_Zeroes {

	public static void setZeroes(int[][] matrix) {
		if (matrix == null) {
			return;
		}
		boolean _1stRowZero = false;
		boolean _1stColZero = false;

		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				_1stRowZero = true;
				break;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				_1stColZero = true;
				break;
			}
		}

		/**
		 * check other cols
		 */

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		/**
		 * set according to 1st row and col
		 */
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
			if (_1stColZero) {
				matrix[i][0] = 0;
			}
		}

		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 0; i < matrix.length; i++) {
					matrix[i][j] = 0;
				}
			}

			if (_1stRowZero) {
				matrix[0][j] = 0;
			}
		}

		if (_1stRowZero || _1stColZero) {
			matrix[0][0] = 0;
		}
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 1, 1, 1, 1, 1, 0, 1 }, { 0, 1, 1, 0, 0, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 0, 1, 1, 0 },
				{ 0, 1, 1, 1, 1, 1, 1, 1 } };
		for (int j = 0; j < arr.length; j++) {
			for (int i = 0; i < arr[0].length; i++) {
				System.out.print(arr[j][i] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		setZeroes(arr);
		for (int j = 0; j < arr.length; j++) {
			for (int i = 0; i < arr[0].length; i++) {
				System.out.print(arr[j][i] + "\t");
			}
			System.out.println();
		}

	}
}