import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ylkang on 7/21/15.
 */
public class Chess {

    private static final int GRID_NUM = 36;
    private boolean[] bitMap = new boolean[GRID_NUM];

    private int counter = 1;

    public void calc(int row, int col) {
        bitMap[calcOffset(row, col)] = true;
        List<Integer> list = new ArrayList<Integer>();
        list.add(calcOffset(row, col));
        calc(list, row, col);
    }

    private void calc(List<Integer> list, int startRow, int startCol) {

        int offset = calcOffset(startRow, startCol);

        if (list.size() == GRID_NUM) {
            System.out.println(String.format("--solution %d--", counter++));
            for (int i : list) {
                System.out.print(String.format("%d,%d \t", i / 6, i % 6));
            }
            System.out.println();
            return;
        }
        // up left
        int row = startRow - 2;
        int col = startCol - 1;
        calc(list, offset, row, col);
        // up right
        row = startRow - 2;
        col = startCol + 1;
        calc(list, offset, row, col);
        // down left
        row = startRow + 2;
        col = startCol - 1;
        calc(list, offset, row, col);
        // down right
        row = startRow + 2;
        col = startCol + 1;
        calc(list, offset, row, col);
        // left up
        row = startRow - 1;
        col = startCol - 2;
        calc(list, offset, row, col);
        // left down
        row = startRow + 1;
        col = startCol - 2;
        calc(list, offset, row, col);
        // right up
        row = startRow - 1;
        col = startCol + 2;
        calc(list, offset, row, col);
        // right down
        row = startRow + 1;
        col = startCol + 2;
        calc(list, offset, row, col);

    }

    private void calc(List<Integer> list, int offset, int row, int col) {
        if (!(row < 0 || row > 5 || col < 0 || col > 5)) {
            int off = calcOffset(row, col);
            if (!bitMap[off]) {
                bitMap[off] = true;
                list.add(calcOffset(row, col));
                calc(list, row, col);
                list.remove(list.size() - 1);
                bitMap[off] = false;
            }
        }
    }

    private int calcOffset(int startRow, int startCol) {
        return startRow * 6 + startCol;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                new Chess().calc(i, j);
            }
        }
    }
}
