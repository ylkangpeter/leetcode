package peter;

import java.util.concurrent.atomic.AtomicInteger;

public class _052_N_Queens_II {

	public static int totalNQueens(int n) {

		AtomicInteger counter = new AtomicInteger(0);

		AtomicInteger middleCounter = new AtomicInteger(0);

		if (n <= 1) {
			return n;
		}

		byte[][] matrix = new byte[n][n];
		for (int i = 0; i < n / 2; i++) {
			matrix[0][i] = 1;
			calc(matrix, 1, counter, n);
			matrix[0][i] = 0;
		}

		if (n % 2 != 0) {
			matrix[0][n / 2] = 1;
			calc(matrix, 1, middleCounter, n);
			return counter.intValue() * 2 + middleCounter.intValue();
		}

		return counter.intValue() * 2;

	}

	private static void calc(byte[][] matrix, int currentLayer,
			AtomicInteger counter, int totalLayer) {
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
			counter.incrementAndGet();
		} else {
			for (int i = 0; i < totalLayer; i++) {
				if (isOk(matrix, i, currentLayer)) {
					matrix[currentLayer][i] = 1;
					calc(matrix, currentLayer + 1, counter, totalLayer);
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
		// System.out.println(totalNQueens(2));
		System.out.println(totalNQueens(3));
		System.out.println(totalNQueens(4));
		System.out.println(totalNQueens(8));
	}

}