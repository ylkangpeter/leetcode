package peter;

import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ylkang on 11/2/15.
 */
public class _299_Bulls_And_Cows {

    public String getHint(String secret, String guess) {

        int A = 0;
        int B = 0;

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) != secret.charAt(i)) {
                sb1.append(guess.charAt(i));
                sb2.append(secret.charAt(i));
            }
        }

        A = secret.length() - sb1.length();

        int[] mask = new int[10];
        for (int i = 0; i < sb1.length(); i++) {
            mask[Character.getNumericValue(sb1.charAt(i))]++;
        }

        for (int i = 0; i < sb2.length(); i++) {
            if (mask[Character.getNumericValue(sb2.charAt(i))] != 0) {
                mask[Character.getNumericValue(sb2.charAt(i))]--;
                B++;
            }
        }


        return A + "A" + B + "B";
    }

    public static void main(String[] args) {
        System.out.println(new _299_Bulls_And_Cows().getHint("1222", "1122"));
    }
}
