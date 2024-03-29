package peter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
 * <p>
 * 若无答案，则返回空字符串。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * words = ["w","wo","wor","worl", "world"]
 * 输出："world"
 * 解释：
 * 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出："apple"
 * 解释：
 * "apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 所有输入的字符串都只包含小写字母。
 * words数组长度范围为[1,1000]。
 * words[i]的长度范围为[1,30]。
 * <p>
 * https://leetcode-cn.com/problems/longest-word-in-dictionary
 */
public class _720_Longest_Word_in_Dictionary {

    class Solution {
        public String longestWord(String[] words) {
            Arrays.sort(words);
            Set<String> set = new HashSet<>();
            String res = "";
            for (String s : words) {
                if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
                    res = s.length() > res.length() ? s : res;
                    set.add(s);
                }
            }
            return res;
        }
    }
}