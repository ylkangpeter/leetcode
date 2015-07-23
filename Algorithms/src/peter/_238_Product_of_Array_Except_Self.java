package peter;

import util.Util.ListNode;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * <p/>
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class _238_Product_of_Array_Except_Self {

    public int[] productExceptSelf(int[] nums) {
        int[] tmp = new int[nums.length];
        tmp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            tmp[i] = tmp[i - 1] * nums[i - 1];
        }

        int factor = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            tmp[i] = tmp[i] * factor;
            factor = factor * nums[i];
        }
        return tmp;
    }
}
