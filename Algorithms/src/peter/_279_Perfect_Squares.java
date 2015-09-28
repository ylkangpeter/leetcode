package peter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ylkang on 9/18/15.
 */
public class _279_Perfect_Squares {
    public int numSquares(int n) {
        if (n == 1) {
            return 1;
        }
        List<Integer> results = new ArrayList<>();
        results.add(0);

        while (results.size() <= n) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= results.size(); j++) {
                min = Math.min(1 + results.get(results.size() - j * j), min);
            }
            results.add(min);
        }
        return results.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new _279_Perfect_Squares().numSquares(3));
        System.out.println(new _279_Perfect_Squares().numSquares(4));
        System.out.println(new _279_Perfect_Squares().numSquares(10));
        System.out.println(new _279_Perfect_Squares().numSquares(13));
    }
}
