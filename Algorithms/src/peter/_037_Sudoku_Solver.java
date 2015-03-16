package peter;

import java.util.Stack;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution.
 * 
 * @author peter Mar 16, 2015
 * 
 */
public class _037_Sudoku_Solver {

	public static void solveSudoku(char[][] board) {

		Stack<Slot> stack = new Stack<Slot>();

		int offset = 0;
		int pre = 0;
		while (offset != 81) {
			int row = offset / 9;
			int col = offset % 9;
			if (board[row][col] == '.') {
				boolean isPop = true;
				for (int i = pre + 1; i <= 9; i++) {
					if (isOk(Character.forDigit(i, 10), row, col, board)) {
						board[row][col] = Character.forDigit(i, 10);
						stack.push(new Slot(row, col, Character.forDigit(i, 10)));
						isPop = false;
						pre = 0;
						break;
					}
				}
				if (isPop) {
					Slot slot = stack.pop();
					offset = slot.row * 9 + slot.col;
					pre = Character.getNumericValue(slot.val);
					board[slot.row][slot.col] = '.';
					continue;
				}
			}
			offset++;
		}

		while (!stack.isEmpty()) {
			Slot slot = stack.pop();
			board[slot.row][slot.col] = slot.val;
		}
	}

	private static boolean isOk(char val, int row, int col, char[][] board) {
		// row && col
		for (int i = 0; i < 9; i++) {
			if (board[i][col] - val == 0 || board[row][i] - val == 0) {
				return false;
			}
		}
		// 9 square
		int squareInx = row / 3 * 3 + col / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[(squareInx / 3) * 3 + i][(squareInx % 3) * 3 + j] == val) {
					return false;
				}
			}
		}
		return true;
	}

	private static class Slot {
		int row;
		int col;
		char val;

		Slot(int row, int col, char val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}

		@Override
		public String toString() {
			return String.format("[%d,%d]=%s", row, col, val);
		}
	}

	public static void main(String[] args) {
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		solveSudoku(board);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}