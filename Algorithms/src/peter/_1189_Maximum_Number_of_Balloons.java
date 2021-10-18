package peter;

/**
 * 给你一个字符串?text，你需要使用 text 中的字母来拼凑尽可能多的单词?"balloon"（气球）。
 * <p>
 * 字符串?text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词?"balloon"。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：text = "nlaebolko"
 * 输出：1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：text = "leetcode"
 * 输出：0
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= text.length <= 10^4
 * text?全部由小写英文字母组成
 * <p>
 * https://leetcode-cn.com/problems/maximum-number-of-balloons
 */
public class _1189_Maximum_Number_of_Balloons {
    public int maxNumberOfBalloons(String text) {

        int b = 0, a = 0, l = 0, o = 0, n = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'b')
                b++;
            else if (text.charAt(i) == 'a')
                a++;
            else if (text.charAt(i) == 'l')
                l++;
            else if (text.charAt(i) == 'o')
                o++;
            else if (text.charAt(i) == 'n')
                n++;
        }
        l /= 2;
        o /= 2;

        return Math.min(Math.min(Math.min(b, a), Math.min(l, o)), n);
    }
}