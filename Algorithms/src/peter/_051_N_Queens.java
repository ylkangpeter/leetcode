package peter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

		Stack<Integer> stack = new Stack<Integer>();

		int[][] square = new int[n][n];

		int pre = -1;
		while (stack.size() != n) {
			for (int i = pre + 1; i < 9; i++) {
				if (isOk(i)) {
					square[stack.size()][i] = 1;
					break;
				}
			}
			pre = stack.pop();
		}

		return list;
	}

	private static boolean isOk(int i) {
		// TODO Auto-generated method stub
		return false;
	}
}