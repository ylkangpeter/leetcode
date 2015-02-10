package peter;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n2 in spiral order.
 * 
 * For example, Given n = 3,
 * 
 * You should return the following matrix:
 * 
 * <pre>
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * </pre>
 * 
 * @author ylkang Feb 10, 2015
 */
public class _059_Spiral_Matrix_II {

	private static int value = 1;

	public static int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];

		for (int i = 0; i < n / 2; i++) {
			fillHori(result, true, i, i, n - 1 - i * 2);
			fillVert(result, true, i, n - 1 - i, n - 1 - i * 2);
			fillHori(result, false, n - 1 - i, n - 1 - i, n - 1 - i * 2);
			fillVert(result, false, n - 1 - i, i, n - 1 - i * 2);
		}
		if (n % 2 == 1) {
			int middle = n / 2;
			result[middle][middle] = value;
		}
		return result;
	}

	private static void fillVert(int[][] result, boolean asc, int startRow,
			int col, int len) {

		if (asc) {
			for (int i = 0; i < len; i++) {
				result[startRow + i][col] = value++;
			}
		} else {
			for (int i = 0; i < len; i++) {
				result[startRow - i][col] = value++;
			}
		}
	}

	private static void fillHori(int[][] result, boolean asc, int row,
			int startCol, int len) {
		if (asc) {
			for (int i = 0; i < len; i++) {
				result[row][startCol + i] = value++;
			}
		} else {
			for (int i = 0; i < len; i++) {
				result[row][startCol - i] = value++;
			}
		}
	}

	public static void main(String[] args) {
		int[][] m = generateMatrix(5);
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
		 m = generateMatrix(4);
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {
				System.out.print(m[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
}