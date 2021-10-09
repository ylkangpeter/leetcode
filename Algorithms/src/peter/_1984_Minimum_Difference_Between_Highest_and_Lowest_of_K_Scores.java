/**
 * project info: leetcode-peter
 */

package peter;

import java.util.Arrays;

/**
 *
 */
public class _1984_Minimum_Difference_Between_Highest_and_Lowest_of_K_Scores {

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int small = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            small = Math.min(small, nums[i + k - 1] - nums[i]);
        }
        return small;
    }

    public static void main(String[] args) {
        new _1984_Minimum_Difference_Between_Highest_and_Lowest_of_K_Scores().minimumDifference(new int[]{9, 4, 1
                , 7}, 3);
    }
}
