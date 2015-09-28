package peter;

import java.math.BigInteger;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate element must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * <p/>
 * <p/>
 * Note:                                             <pre>
 * You must not modify the array (assume the array is read only).
 * You must use only constant extra space.
 * Your runtime complexity should be less than O(n2).     </pre>
 * Created by ylkang on 9/28/15.
 */
public class _287_Find_the_Duplicate_Number {
    public int findDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int targetInx = nums[i] - 1;
            if (i == targetInx) {
                continue;
            } else {
                int tmpVal = nums[targetInx];
                nums[targetInx] = nums[i];
                nums[i] = 0;

                while (true) {
                    if (tmpVal == nums[tmpVal - 1]) {
                        return tmpVal;
                    } else if (nums[tmpVal - 1] == 0) {
                        nums[tmpVal - 1] = tmpVal;
                        break;
                    } else {
                        int newTmp = nums[tmpVal - 1];
                        nums[tmpVal - 1] = tmpVal;
                        tmpVal = newTmp;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new _287_Find_the_Duplicate_Number()
                .findDuplicate(new int[]{2, 4, 3, 1, 1}));
    }
}
