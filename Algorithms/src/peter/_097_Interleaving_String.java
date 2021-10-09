package peter;

import java.util.Stack;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * <pre>
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 *
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * </pre>
 * <p>
 * *
 *
 * @author peter Mar 17, 2015
 */
public class _097_Interleaving_String {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        } else {
            int[] arr1 = new int[26];
            int[] arr2 = new int[26];
            int[] arr3 = new int[26];
            for (char c : s1.toCharArray()) {
                arr1[Character.getNumericValue(c) - 10]++;
            }
            for (char c : s2.toCharArray()) {
                arr2[Character.getNumericValue(c) - 10]++;
            }
            for (char c : s3.toCharArray()) {
                arr3[Character.getNumericValue(c) - 10]++;
            }
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] + arr2[i] != arr3[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isInterleave_slow(String s1, String s2, String s3) {

        if (s1 == null) {
            if (s2 == null || s3 == null) {
                return s3 == s2;
            } else {
                return s3.equals(s2);
            }
        } else {
            if (s3 == null) {
                return false;
            } else {
                if (s2 == null) {
                    return s1.equals(s3);
                }
            }
        }

        if (s1.equals("")) {
            return s2.equals(s3);
        } else {
            if (s2.equals("")) {
                return s1.equals(s3);
            }

        }
        Stack<Value> stack = new Stack<Value>();

        int _1_offset = 0;
        int _2_offset = 0;

        if (s1.charAt(0) == s3.charAt(0)) {
            stack.push(new Value(s1.charAt(0), 1, 0));
            _1_offset = 1;
        } else if (s2.charAt(0) == s3.charAt(0)) {
            stack.push(new Value(s2.charAt(0), 2, 0));
            _2_offset = 1;
        } else {
            return false;
        }

        int pre = 0;

        while (stack.size() != s3.length()) {
            char c = s3.charAt(_1_offset + _2_offset);
            if (pre == 0 && _1_offset < s1.length()
                    && s1.charAt(_1_offset) == c) {
                stack.push(new Value(s1.charAt(_1_offset), 1, _1_offset));
                _1_offset++;
            } else if (_2_offset < s2.length() && s2.charAt(_2_offset) == c) {
                pre = 0;
                stack.push(new Value(s2.charAt(_2_offset), 2, _2_offset));
                _2_offset++;
            } else {
                boolean isOver = true;
                while (!stack.isEmpty()) {
                    Value v = stack.pop();
                    if (v.whichStr == 1) {
                        pre = 1;
                        _1_offset = v.offset;
                        isOver = false;
                        break;
                    } else {
                        _2_offset = v.offset;
                    }
                }
                if (isOver) {
                    return false;

                }

            }
        }

        if (stack.isEmpty()) {
            return false;
        }
        return true;
    }

    private static class Value {
        char c;
        int whichStr;
        int offset;

        public Value(char c, int whichStr, int offset) {
            this.c = c;
            this.whichStr = whichStr;
            this.offset = offset;
        }

        @Override
        public String toString() {
            return String.format("[%s,%d,%d]", c, whichStr, offset);
        }
    }

    public static void main(String[] args) {
    	System.out.println(Character.getNumericValue('a'));
		System.out.println(Character.getNumericValue('b'));
        System.out.println(isInterleave_slow("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleave_slow("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(isInterleave_slow("abcc", "aabbca", "abaacbbcac"));
        System.out.println(isInterleave_slow("", "", ""));
        System.out.println(isInterleave_slow("aabd", "adbc", "aabdabcd"));
        System.out.println(isInterleave_slow("aa", "ab", "abaa"));
    }
}