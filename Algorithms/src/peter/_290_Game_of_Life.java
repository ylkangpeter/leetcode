package peter;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p/>
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p/>
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * <p/>
 * Follow up:
 * Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 * Created by ylkang on 10/8/15.
 */
public class _290_Game_of_Life {

    private static final int LIVE = 1;
    private static final int DEAD = 0;
    private static final int LIVE_NEXT = 3;
    private static final int DEAD_NEXT = 2;


    public void gameOfLife(int[][] board) {
        for (int vert = 0; vert < board.length; vert++) {
            for (int hori = 0; hori < board[0].length; hori++) {
                doCalc(vert, hori, board);
            }
        }

        for (int vert = 0; vert < board.length; vert++) {
            for (int hori = 0; hori < board[0].length; hori++) {
                board[vert][hori] &= 1;
            }
        }
    }

    private void doCalc(int vert, int hori, int[][] board) {
        int totalLiveAround = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (vert + i >= 0 && vert + i < board.length && hori + j >= 0 && hori + j < board[0].length) {
                    if (board[vert + i][hori + j] == 1 || board[vert + i][hori + j] == 2) {
                        totalLiveAround++;
                    }
                }
            }
        }
        if (totalLiveAround < 2) {
            if (board[vert][hori] == 1) {
                board[vert][hori] = 2;
            }
        } else if (totalLiveAround > 3) {
            if (board[vert][hori] == 1) {
                board[vert][hori] = 2;
            }
        } else if (totalLiveAround == 3) {
            if (board[vert][hori] == 0) {
                board[vert][hori] = 3;
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {{1, 0, 0, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 1, 1}};
        new _290_Game_of_Life().gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
