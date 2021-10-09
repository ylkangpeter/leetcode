/**
 * project info: leetcode-peter
 */

package peter;

/**
 *
 */
public class _2000_Reverse_Prefix_of_Word {

    public String reversePrefix(String word, char ch) {
        int inx = word.indexOf(ch);
        if (inx >= 0) {
            if (inx == (word.length() - 1)) {
                return reverse(word);
            } else {
                return reverse(word.substring(0, inx + 1)) + word.substring(inx + 1);
            }
        } else {
            return word;
        }
    }

    public String reverse(String str) {
        char[] s = str.toCharArray();
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - i - 1] = tmp;
        }
        return new String(s);
    }

}
