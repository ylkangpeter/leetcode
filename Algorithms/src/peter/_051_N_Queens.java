package peter;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * For example, There exist two distinct solutions to the 4-queens puzzle:
 * 
 * <pre>
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * 
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * </pre>
 * 
 * @author peter Mar 16, 2015
 * 
 */
public class _051_N_Queens {

	public static List<String[]> solveNQueens(int n) {

		List<String[]> list = new ArrayList<String[]>();
		if (n <= 0) {
			return list;
		}
		
		byte[][] matrix = new byte[n][n];

		calc(matrix, 0, list, n);

		return list;
	}

	private static void calc(byte[][] matrix, int currentLayer,
			List<String[]> list, int totalLayer) {
		if (currentLayer == totalLayer) {
			String[] strs = new String[totalLayer];
			for (int i = 0; i < totalLayer; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < totalLayer; j++) {
					if (matrix[i][j] == 1) {
						sb.append("Q");
					} else {
						sb.append(".");
					}
				}
				strs[i] = sb.toString();
			}
			list.add(strs);
		} else {
			for (int i = 0; i < totalLayer; i++) {
				if (isOk(matrix, i, currentLayer)) {
					matrix[currentLayer][i] = 1;
					calc(matrix, currentLayer + 1, list, totalLayer);
					matrix[currentLayer][i] = 0;
				}
			}
		}

	}

	private static boolean isOk(byte[][] matrix, int col, int row) {
		int n = matrix.length;
		// cols
		for (int i = 0; i < n; i++) {
			if (matrix[i][col] == 1) {
				return false;
			}
		}
		// cross up-right
		int _col = col;
		int _row = row;
		while (++_col < n && --_row >= 0) {
			if (matrix[_row][_col] == 1) {
				return false;
			}
		}
		// cross up-left
		_col = col;
		_row = row;
		while (--_col >= 0 && --_row >= 0) {
			if (matrix[_row][_col] == 1) {
				return false;
			}
		}
		// cross down-left
		_col = col;
		_row = row;
		while (--_col >= 0 && ++_row < n) {
			if (matrix[_row][_col] == 1) {
				return false;
			}
		}
		// cross down-right
		_col = col;
		_row = row;
		while (++_col < n && ++_row < n) {
			if (matrix[_row][_col] == 1) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(solveNQueens(2));
		System.out.println(solveNQueens(8));
	}
}