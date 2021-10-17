package peter;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * <p>
 * 美式键盘 中：
 * <p>
 * <p>
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 * <p>
 * <p>
 * <p>
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：words = ["omk"]
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] 由英文字母（小写和大写字母）组成
 * <p>
 * https://leetcode-cn.com/problems/keyboard-row
 */
public class _500_Keyboard_Row {

    public String[] findWords(String[] words) {
        List<String> result = new LinkedList<>();
        for (String word : words) {
            if (match(word, s1) || match(word, s2) || match(word, s3)) {
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);

    }

    Set<Character> s1 = new HashSet<>();
    Set<Character> s2 = new HashSet<>();
    Set<Character> s3 = new HashSet<>();

    {

        s1.add('q');
        s1.add('w');
        s1.add('e');
        s1.add('r');
        s1.add('t');
        s1.add('y');
        s1.add('u');
        s1.add('i');
        s1.add('o');
        s1.add('p');

        s2.add('a');
        s2.add('s');
        s2.add('d');
        s2.add('f');
        s2.add('g');
        s2.add('h');
        s2.add('j');
        s2.add('k');
        s2.add('l');

        s3.add('z');
        s3.add('x');
        s3.add('c');
        s3.add('v');
        s3.add('b');
        s3.add('n');
        s3.add('m');
    }

    boolean match(String s, Set<Character> set) {
        for (char c : s.toLowerCase().toCharArray()) {
            if (!set.contains(c)) {
                return false;
            }
        }
        return true;
    }

}