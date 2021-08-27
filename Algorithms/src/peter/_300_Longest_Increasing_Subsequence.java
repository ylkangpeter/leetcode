package peter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ylkang on 11/9/15.
 */
public class _300_Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums) {
        List<Integer> seq = new ArrayList<>(nums.length);

        for (int num : nums) {
            if (seq.size() == 0
                    || seq.get(seq.size() - 1) < num) {
                seq.add(num);
            } else {
                seq.set(binarySearch(seq, num - 0.5), num);
            }
        }

        return seq.size();
    }

    private int binarySearch(List<Integer> seq, double target) {
        int st = 0;
        int ed = seq.size() - 1;
        int mid = 0;

        while (st <= ed) {
            mid = st + (ed - st) / 2;

            if (seq.get(mid) > target) {
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return st;
    }
}
