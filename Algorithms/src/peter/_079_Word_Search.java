package peter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board =
 * 
 * <pre>
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 *   
 *   word = "ABCCED", -> returns true,
 * 	 word = "SEE", -> returns true,
 *   word = "ABCB", -> returns false.
 * ]
 * </pre>
 * 
 * 
 * @author ylkang May 11, 2015
 */
public class _079_Word_Search {

	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0
				|| word == null || word.length() == 0) {
			return false;
		}

		Map<Character, ArrayList<String>> m = new HashMap<Character, ArrayList<String>>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char c = board[i][j];
				ArrayList<String> tmp = m.get(c);
				if (m.get(c) == null) {
					tmp = new ArrayList<String>();
					m.put(c, tmp);
				}
				tmp.add(i + "_" + j);
			}
		}

		char start = word.charAt(0);
		ArrayList<String> values = m.get(start);
		if (values == null) {
			return false;
		} else {
			for (String str : values) {
				boolean[][] mask = new boolean[board.length][board[0].length];
				String[] tmp = str.split("_");
				int i = Integer.parseInt(tmp[0]);
				int j = Integer.parseInt(tmp[1]);
				mask[i][j] = true;
				if (find(mask, board, word, 1, i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean find(boolean[][] mask, char[][] board, String word,
			int inx, int row, int col) {
		int[][] offset = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

		if (inx >= word.length()) {
			return true;
		}

		char c = word.charAt(inx);
		for (int i = 0; i < offset.length; i++) {
			if (isQualified(offset[i], row, col, board)) {
				if (board[row + offset[i][0]][col + offset[i][1]] == c
						&& !mask[row + offset[i][0]][col + offset[i][1]]) {
					mask[row + offset[i][0]][col + offset[i][1]] = true;
					if (find(mask, board, word, inx + 1, row + offset[i][0],
							col + offset[i][1])) {
						return true;
					}
					mask[row + offset[i][0]][col + offset[i][1]] = false;
				}
			}
		}
		return false;
	}

	private boolean isQualified(int[] offset, int row, int col, char[][] board) {
		if (row + offset[0] >= 0 && row + offset[0] < board.length
				&& col + offset[1] >= 0 && col + offset[1] < board[0].length) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new _079_Word_Search().exist(new char[][] {
				{ 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } }, "ABCCED"));
		System.out.println(new _079_Word_Search().exist(new char[][] {
				{ 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } }, "SEE"));
		System.out.println(new _079_Word_Search().exist(new char[][] {
				{ 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } }, "ABCB"));
	}
}