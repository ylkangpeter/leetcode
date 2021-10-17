package peter;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * ?
 * <p>
 * 示例：
 * <p>
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * <p>
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 */
public class _557_Reverse_Words_in_a_String_III {

    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        String[] tmps = s.split(" ");
        for (String tmp : tmps) {
            char[] chars = tmp.toCharArray();
            reverseString(chars);
            sb.append(chars).append(" ");
        }
        return sb.toString().trim();
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - i - 1] = tmp;
        }
    }
}