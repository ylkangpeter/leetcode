package peter;

/**
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 * <p>
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * <p>
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写，?比如?"Google"。
 * <p>
 * <p>
 * 否则，我们定义这个单词没有正确使用大写字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "USA"
 * 输出: True
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: "FlaG"
 * 输出: False
 * <p>
 * <p>
 * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
 * <p>
 * https://leetcode-cn.com/problems/detect-capital
 */
public class _520_Detect_Capital {

    public boolean detectCapitalUse(String word) {
        if (word.length() == 1 || word.toLowerCase().equals(word) || word.toUpperCase().equals(word)) {
            return true;
        }
        if (word.substring(1).toLowerCase().equals(word.substring(1))) {
            return true;
        }
        return false;

    }
}