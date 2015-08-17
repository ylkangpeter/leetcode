package peter;

/**
 * https://en.wikipedia.org/wiki/Digital_root
 * Created by ylkang on 8/17/15.
 */
public class _258_Add_Digits {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        } else if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }
}
