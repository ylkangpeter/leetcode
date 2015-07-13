package peter;

import java.util.Arrays;

public class _233_Number_of_Digit_One {

    private static long[] NUMS = {1, 10, 100, 1000, 10000, 100000, 1000000,
            10000000, 100000000, 1000000000, 10000000000L};
    private final long[] K = {0, 1, 19, 271, 3439, 40951, 468559, 5217031,
            56953279, 612579511, 6513215599L};

    public int countDigitOne(int n) {

        int ones = 0;
        for (long m = 1; m <= n; m *= 10)
            ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
        return ones;

    }

    public static void main(String[] args) {
        long a = 1;
        int inx = 1;
        while (a < Long.MAX_VALUE) {
            a = (long) (9 * a + Math.pow(10, inx));
            System.out.println(a);
            inx++;
        }
    }

}
