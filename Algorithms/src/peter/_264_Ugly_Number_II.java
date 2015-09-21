package peter;

import java.util.LinkedList;
import java.util.Queue;

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
        Queue<Long> q2 = new LinkedList<Long>();
        Queue<Long> q3 = new LinkedList<Long>();
        Queue<Long> q5 = new LinkedList<Long>();
        Long res = 1L;
        q2.add(2L);
        q3.add(3L);
        q5.add(5L);
        while (n-- > 1) {
            if (q2.peek() < q3.peek() && q2.peek() < q5.peek()) {
                res = q2.poll();
                q2.add(res * 2);
                q3.add(res * 3);
                q5.add(res * 5);
            } else if (q3.peek() < q2.peek() && q3.peek() < q5.peek()) {
                res = q3.poll();
                q3.add(res * 3);
                q5.add(res * 5);
            } else {
                res = q5.poll();
                q5.add(res * 5);
            }
        }
        return res.intValue();
    }


    public static void main(String[] args) {
    }
}
