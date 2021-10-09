/**
 * project info: leetcode-peter
 */

package peter;

/**
 * You are given an n x n binary grid board. In each move, you can swap any two rows with each other, or any two
 * columns with each other.
 * <p>
 * Return the minimum number of moves to transform the board into a chessboard board. If the task is impossible,
 * return -1.
 * <p>
 * A chessboard board is a board where no 0's and no 1's are 4-directionally adjacent.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
 * Output: 2
 * Explanation: One potential sequence of moves is shown.
 * The first move swaps the first and second column.
 * The second move swaps the second and third row.
 * Example 2:
 * <p>
 * <p>
 * Input: board = [[0,1],[1,0]]
 * Output: 0
 * Explanation: Also note that the board with 0 in the top left corner, is also a valid chessboard.
 * Example 3:
 * <p>
 * <p>
 * Input: board = [[1,0],[1,0]]
 * Output: -1
 * Explanation: No matter what sequence of moves you make, you cannot end with a valid chessboard.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == board.length
 * n == board[i].length
 * 2 <= n <= 30
 * board[i][j] is either 0 or 1.
 */
public class _782_Transform_to_Chessboard {
    public int movesToChessboard(int[][] board) {
        // check board
        int[] lines = new int[2];
        final int LEN = board.length;
        for (int i = 0; i < LEN; i++) {
            int value = 0;
            for (int j = 0; j < LEN; j++) {
                value = value >> 1 + board[i][j];
            }
            if (lines[0] == 0 || lines[0] == value) {
                lines[0] = value;
            } else if (lines[1] == 0 || lines[1] == value) {
                lines[1] = value;
            } else {
                return -1;
            }
        }

        int[] cols = new int[2];
        for (int i = 0; i < LEN; i++) {
            int value = 0;
            for (int j = 0; j < LEN; j++) {
                value = value << 1 + board[j][i];
            }
            if (cols[0] == 0 || cols[0] == value) {
                cols[0] = value;
            } else if (cols[1] == 0 || cols[1] == value) {
                cols[1] = value;
            } else {
                return -1;
            }
        }

        // validate line and col
//        if (isOK(lines[0], LEN) && isOK(lines[1], LEN)) {
//            int ones = Integer.bitCount(lines[0]);
//            if (LEN % 2 == 0 || ones * 2 < LEN) // zero start
//                return Integer.bitCount(k1 ^ 0xAAAAAAAA & Nones) / 2);
//
//            if (LEN % 2 == 0 || ones * 2 > LEN) // ones start
//                cand = Math.min(cand, Integer.bitCount(k1 ^ 0x55555555 & Nones) / 2);
//        } else {
//            return -1;
//        }
        return 0;
    }


    private boolean isOK(int col, int len) {
        int ones = Integer.bitCount(col);
        if (len % 2 == 0) {
            if (ones * 2 != len) {
                return false;
            } else {
                return true;
            }
        } else {
            if (len * 2 == ones - 1 || len * 2 == ones + 1) {
                return true;
            } else {
                return false;
            }
        }
    }

}
