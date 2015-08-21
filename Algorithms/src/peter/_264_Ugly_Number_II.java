package peter;

import java.util.LinkedList;

/**
 * Write a program to check whether a given number is an ugly number.
 * <p/>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * <p/>
 * Note that 1 is typically treated as an ugly number.
 * <p/>
 * Created by ylkang on 8/21/15.
 */
public class _264_Ugly_Number_II {
    public int nthUglyNumber(int n) {
        int a = 2;
        int b = 3;
        int c = 4;

        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(2);
        list.add(3);
        list.add(4);

        int inx = 0;
        while (n - 3 != 0) {
            int tmp = Integer.MAX_VALUE;
            for (int i : list) {
                if (i*2)
            }

        }
        return 1;
    }


    public static void main(String[] args) {
    }
}
