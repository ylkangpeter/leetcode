package peter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p/>
 * Examples:                                                                <pre>
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.                </pre>
 * Notes:
 * patterncontains only lowercase alphabetical letters, and str contains words separated by a single space. Each word in str contains only lowercase alphabetical letters.
 * Both pattern and str do not have leading or trailing spaces.
 * Each letter in pattern must map to a word with length that is at least 1.
 * Created by ylkang on 10/8/15.
 */
public class _289_Word_Pattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> set = new HashMap<>();
        Set<String> wordSet = new HashSet<>();
        String[] tmps = str.split(" ");
        if (tmps.length != pattern.length()) {
            return false;
        }
        for (int inx = 0; inx < tmps.length; inx++) {
            if (set.containsKey(pattern.charAt(inx))) {
                if (!tmps[inx].equals(set.get(pattern.charAt(inx)))) {
                    return false;
                }
            } else {
                if (wordSet.contains(tmps[inx])) {
                    return false;
                }
                wordSet.add(tmps[inx]);
                set.put(pattern.charAt(inx), tmps[inx]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _289_Word_Pattern().wordPattern("abba", "dog cat cat dog"));
        System.out.println(new _289_Word_Pattern().wordPattern("abba", "dog cat cat fish"));
        System.out.println(new _289_Word_Pattern().wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(new _289_Word_Pattern().wordPattern("abba", "dog dog dog dog"));
    }
}
