package peter;

/**
 * Created by ylkang on 9/18/15.
 */
public class _279_Perfect_Squares {
    public int numSquares(int n) {
        if (n == 1) {
            return 1;
        }
        int[] results = new int[n + 1];
        results[0] = 0;
        results[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j < i; j++) {
                min = Math.min(results[j * j] + results[n - j * j], min);
            }
            results[i] = min;
        }
        return results[n];
    }

    public static void main(String[] args) {
//        System.out.println(new _279_Perfect_Squares().numSquares(1));
        System.out.println(new _279_Perfect_Squares().numSquares(4));
        System.out.println(new _279_Perfect_Squares().numSquares(10));
        System.out.println(new _279_Perfect_Squares().numSquares(13));
    }
}
