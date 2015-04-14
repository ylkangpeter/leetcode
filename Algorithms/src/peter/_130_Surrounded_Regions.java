package peter;

import java.util.Stack;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by
 * 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * For example,
 * 
 * <pre>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * </pre>
 * 
 * @author ylkang Apr 14, 2015
 */
public class _130_Surrounded_Regions {

	public void solve(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}

		Stack<Pair> stack = new Stack<Pair>();

		// find break point
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O') {
				stack.push(new Pair(i, 0));
				board[i][0] = 'P';
			}
			if (board[i][board[0].length - 1] == 'O') {
				stack.push(new Pair(i, board[0].length - 1));
				board[i][board[0].length - 1] = 'P';
			}
		}
		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] == 'O') {
				stack.push(new Pair(0, i));
				board[0][i] = 'P';
			}
			if (board[board.length - 1][i] == 'O') {
				stack.push(new Pair(board.length - 1, i));
				board[board.length - 1][i] = 'P';
			}
		}

		while (!stack.isEmpty()) {
			Pair pair = stack.pop();
			if (pair.row < 0 || pair.row >= board.length || pair.col < 0
					|| pair.col >= board[0].length) {
				continue;
			}
			if (board[pair.row][pair.col] == 'O'
					|| board[pair.row][pair.col] == 'P') {
				board[pair.row][pair.col] = '1';
				stack.push(new Pair(pair.row - 1, pair.col));
				stack.push(new Pair(pair.row, pair.col - 1));
				stack.push(new Pair(pair.row + 1, pair.col));
				stack.push(new Pair(pair.row, pair.col + 1));

			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '1' || board[i][j] == 'P') {
					board[i][j] = 'O';
				}
			}

		}
	}

	private static class Pair {
		int row;
		int col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

}