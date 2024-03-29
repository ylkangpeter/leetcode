package peter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出第一个词?first 和第二个词?second，考虑在某些文本?text?中可能以 "first second third" 形式出现的情况，其中?second?紧随?first?出现，third?紧随?second?出现。
 * <p>
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 * 输出：["girl","student"]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：text = "we will we will rock you", first = "we", second = "will"
 * 输出：["we","rock"]
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= text.length <= 1000
 * text?由一些用空格分隔的单词组成，每个单词都由小写英文字母组成
 * 1 <= first.length, second.length <= 10
 * first 和?second?由小写英文字母组成
 * <p>
 * https://leetcode-cn.com/problems/occurrences-after-bigram
 */
public class _1078_Occurrences_After_Bigram {

    public String[] findOcurrences(String text, String first, String second) {
        List<String> result = new ArrayList<>();
        String[] tmps = text.split(" ");
        for (int i = 0; i < tmps.length - 2; i++) {
            if (tmps[i].equals(first) && tmps[i + 1].equals(second)) {
                result.add(tmps[i + 2]);
            }
        }
        return result.toArray(new String[result.size()]);
    }
}