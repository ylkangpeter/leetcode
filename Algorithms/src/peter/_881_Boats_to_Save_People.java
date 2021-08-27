/**
 * Copyright 2018 @pinduoduo
 * <p>
 * project info: leetcode-peter
 */

package peter;

import java.util.Arrays;

/**
 * author: ylkang
 * date: 2021/8/27
 * version: v0.1
 */
public class _881_Boats_to_Save_People {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;

        int result = 0;
        while (start <= end) {
            if (people[end] + people[start] <= limit) {
                end--;
                start++;
            } else {
                end--;
            }

            result++;
        }
        return result;
    }
}
