package peter;

/**
 * Created by ylkang on 8/21/15.
 */
public class _263_Ugly_Number {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        //remove 2's.
        num >>>= Integer.numberOfTrailingZeros(num);

        //remove 3's
        while (num % 3 == 0) {
            num = num / 3;
        }
        //remove 5's
        while (num % 5 == 0) {
            num = num / 5;
        }
        return num == 1;
    }
}
