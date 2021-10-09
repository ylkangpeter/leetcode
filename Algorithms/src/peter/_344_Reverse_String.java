/**
 * project info: leetcode-peter
 */

package peter;

public class _344_Reverse_String {

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - i - 1] = tmp;
        }
    }
}
