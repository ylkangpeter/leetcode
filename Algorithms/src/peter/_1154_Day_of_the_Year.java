package peter;

/**
 * 给你一个按 YYYY-MM-DD 格式表示日期的字符串?date，请你计算并返回该日期是当年的第几天。
 * <p>
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入：date = "2019-01-09"
 * 输出：9
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：date = "2019-02-10"
 * 输出：41
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：date = "2003-03-01"
 * 输出：60
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：date = "2004-03-01"
 * 输出：61
 * <p>
 * ?
 * <p>
 * 提示：
 * <p>
 * <p>
 * date.length == 10
 * date[4] == date[7] == '-'，其他的?date[i]?都是数字。
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日。
 * <p>
 * https://leetcode-cn.com/problems/day-of-the-year
 */
public class _1154_Day_of_the_Year {

    public int dayOfYear(String date) {
        String[] strs = date.split("-");
        int year = Integer.parseInt(strs[0]);
        int month = Integer.parseInt(strs[1]);
        int day = Integer.parseInt(strs[2]);

        int leap = 0;
        if (year % 4 == 0) {
            if (year % 400 == 0) {
                leap = 1;
            } else if (year % 100 != 0) {
                leap = 1;
            }
        }

        int result = 0;
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 1; i < month; i++) {
            result += months[i - 1];
        }
        result += day;
        if (month > 2) {
            result += leap;
        }
        return result;
    }
}