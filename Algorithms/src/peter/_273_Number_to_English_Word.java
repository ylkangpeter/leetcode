package peter;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * <p/>
 * For example,
 * <pre>
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * </pre>
 * <p/>
 * Created by ylkang on 8/31/15.
 */
public class _273_Number_to_English_Word {

    private static final Map<Integer, String> MAP = new HashMap<>();

    static {
        MAP.put(1, "One");
        MAP.put(2, "Two");
        MAP.put(3, "Three");
        MAP.put(4, "Four");
        MAP.put(5, "Five");
        MAP.put(6, "Six");
        MAP.put(7, "Seven");
        MAP.put(8, "Eight");
        MAP.put(9, "Nine");
        MAP.put(10, "Ten");
        MAP.put(11, "Eleven");
        MAP.put(12, "Twelve");
        MAP.put(13, "Thirteen");
        MAP.put(14, "Fourteen");
        MAP.put(15, "Fifteen");
        MAP.put(16, "Sixteen");
        MAP.put(17, "Seventeen");
        MAP.put(18, "Eighteen");
        MAP.put(19, "Nineteen");
        MAP.put(20, "Twenty");
        MAP.put(30, "Thirty");
        MAP.put(40, "Forty");
        MAP.put(50, "Fifty");
        MAP.put(60, "Sixty");
        MAP.put(70, "Seventy");
        MAP.put(80, "Eighty");
        MAP.put(90, "Ninety");
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String _1 = helper(num / 1000000000, "Billion");
        String _2 = helper((num - num / 1000000000 * 1000000000) / 1000000, "Million");
        String _3 = helper((num - num / 1000000 * 1000000) / 1000, "Thousand");
        String _4 = helper(num % 1000, null);

        StringBuilder sb = new StringBuilder();
        sb.append(_1);
        if (sb.length() != 0) {
            if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(" ");
            }
        }
        sb.append(_2);
        if (sb.length() != 0) {
            if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(" ");
            }
        }
        sb.append(_3);
        if (sb.length() != 0) {
            if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(" ");
            }
        }
        sb.append(_4);
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    public static String helper(int num, String root) {
        int k = num / 1000;
        int h = (num - num / 1000 * 1000) / 100;
        int t = (num - num / 1000 * 1000) % 100;

        StringBuilder sb = new StringBuilder();

        if (k != 0) {
            sb.append(MAP.get(k)).append(" Thousand");
        }
        if (h != 0) {
            if (sb.length() != 0) {
                sb.append(" ");
            }
            sb.append(MAP.get(h)).append(" Hundred");
        }

        if (t != 0) {
            if (MAP.get(t) != null) {
                if (sb.length() != 0) {
                    sb.append(" ");
                }
                sb.append(MAP.get(t));
            } else {
                int mod = t / 10;
                String a = MAP.get(mod * 10);
                String b = MAP.get(t % 10);
                if (sb.length() != 0) {
                    sb.append(" ");
                }
                sb.append(a).append(" ").append(b);
            }
        }
        if (sb.length() != 0 && root != null) {
            sb.append(" ").append(root);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(new _273_Number_to_English_Word().numberToWords(1000));
        System.out.println(new _273_Number_to_English_Word().numberToWords(123));
        System.out.println(new _273_Number_to_English_Word().numberToWords(12345));
        System.out.println(new _273_Number_to_English_Word().numberToWords(1234567));

        System.out.println(new _273_Number_to_English_Word().numberToWords(1000007));

        System.out.println(new _273_Number_to_English_Word().numberToWords(0));
        System.out.println(helper(0, null));
    }
}
