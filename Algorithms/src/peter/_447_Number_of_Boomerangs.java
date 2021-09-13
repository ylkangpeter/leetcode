/**
 * project info: leetcode-peter
 */

package peter;

import java.util.HashMap;
import java.util.Map;

public class _447_Number_of_Boomerangs {

    class Solution {
        public int numberOfBoomerangs(int[][] points) {

            Map<Integer, Integer> map = new HashMap<>();
            int length = points.length;
            if (length < 3) return 0;
            int sum = 0;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (i == j) continue;
                    int x = Math.abs(points[i][0] - points[j][0]);
                    int y = Math.abs(points[i][1] - points[j][1]);
                    int distance = x * x + y * y;
                    if (!map.containsKey(distance))
                        map.put(distance, 1);
                    else {
                        int n = map.get(distance);
                        sum += n * 2;
                        map.put(distance, n + 1);
                    }
                }
                map.clear();
            }
            return sum;
        }
    }
}
