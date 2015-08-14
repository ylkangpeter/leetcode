package peter;

/**
 * Created by ylkang on 8/4/15.
 */
public class _242_Valid_Anagram {

    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null && t != null) {
            return false;
        } else if (s != null && t == null) {
            return false;
        } else if (s.length() != t.length()) {
            return false;
        }

        int[] mask = new int[100];

        for (int i = 0; i < s.length(); i++) {
            mask[Character.getNumericValue(s.charAt(i))]++;
            mask[Character.getNumericValue(t.charAt(i))]--;
        }

        for (int i = 0; i < mask.length; i++) {
            if (mask[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _242_Valid_Anagram().isAnagram("anagram", "nagaram"));
        System.out.println(new _242_Valid_Anagram().isAnagram("nat", "cat"));
    }
}
