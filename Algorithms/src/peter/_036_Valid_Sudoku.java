package peter;

/**
 * 
 A valid Sudoku board (partially filled) is not necessarily solvable. Only the
 * filled cells need to be validated.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _036_Valid_Sudoku {

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			boolean[] isRowSet = new boolean[9];
			boolean[] isColSet = new boolean[9];
			boolean[] isSquareSet = new boolean[9];

			for (int j = 0; j < 9; j++) {
				// row case
				char c = board[i][j];
				if (c != '.') {
					if (isRowSet[c - '1'] == true) {
						return false;
					}
					isRowSet[c - '1'] = true;
				}
				// column case
				c = board[j][i];
				if (c != '.') {
					if (isColSet[c - '1'] == true) {
						return false;
					}
					isColSet[c - '1'] = true;
				}
				// square case
				if (j > 6) {

				} else if (j > 3) {

				} else {

				}
				c = board[(i / 3) * 3 + (j / 3)][(i % 3) * 3 + (j % 3)];
				if (c != '.') {
					if (isSquareSet[c - '1'] == true) {
						return false;
					}
					isSquareSet[c - '1'] = true;
				}
			}
		}
		return true;
	}

}