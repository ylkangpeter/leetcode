package peter;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 104
 * s 仅由小写英文组成
 * 1 <= k <= 104
 * <p>
 * https://leetcode-cn.com/problems/reverse-string-ii
 */
public class _541_Reverse_String_II {

    public String reverseStr(String str, int k) {
        if (str.length() <= k) {
            return reverse(str);
        } else {
            int i = 0;
            StringBuffer sb = new StringBuffer();
            while (i < str.length() && (i + k) < str.length()) {
                sb.append(reverse(str.substring(i, i + k)));
                int end = Math.min(i + 2 * k, str.length());
                sb.append(str.substring(i + k, end));
                i += 2 * k;
            }
            if (i < str.length()) {
                sb.append(reverse(str.substring(i)));
            }
            return sb.toString();
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

    public static void main(String[] args) {
        new _541_Reverse_String_II().reverseStr("abcdefg", 2);
    }
}