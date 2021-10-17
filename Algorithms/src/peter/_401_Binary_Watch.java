package peter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 * <p>
 * <p>
 * 例如，下面的二进制手表读取 "3:25" 。
 * <p>
 * <p>
 * <p>
 * <p>
 * （图源：WikiMedia - Binary clock samui moon.jpg ，许可协议：Attribution-ShareAlike 3.0 Unported (CC BY-SA 3.0) ）
 * <p>
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
 * <p>
 * 小时不会以零开头：
 * <p>
 * <p>
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * <p>
 * <p>
 * 分钟必须由两位数组成，可能会以零开头：
 * <p>
 * <p>
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 * <p>
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：turnedOn = 1
 * 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：turnedOn = 9
 * 输出：[]
 * <p>
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= turnedOn <= 10
 * <p>
 * https://leetcode-cn.com/problems/binary-watch
 */
public class _401_Binary_Watch {

    private Map<Integer, List<String>> map = new HashMap<>();

    {
        for (int i = 0; i < 12; i++) {
            String hour = String.valueOf(i);
            int iCount = Integer.bitCount(i);
            for (int j = 0; j < 60; j++) {
                String minute = j < 10 ? "0" + j : "" + j;
                int bitsOn = iCount + Integer.bitCount(j);
                List<String> result = map.get(bitsOn);
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(hour + ":" + minute);
                map.put(bitsOn, result);
            }
        }
    }

    public List<String> readBinaryWatch(int turnedOn) {
        return turnedOn > 8 ? new ArrayList<>() : map.get(turnedOn);
    }

    public static void main(String[] args) {
        System.out.println(new _401_Binary_Watch().readBinaryWatch(1));
    }
}