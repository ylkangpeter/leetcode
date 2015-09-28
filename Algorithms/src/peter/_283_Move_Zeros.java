package peter;

/**
 * Created by ylkang on 9/28/15.
 */
public class _283_Move_Zeros {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int current = 0;
        while (current < nums.length - 1 && nums[current] != 0) {
            current++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i <= current) {
                    continue;
                }

                nums[current] = nums[i];
                nums[i] = 0;
                while (current < nums.length - 1 && nums[current] != 0) {
                    current++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 3, 0, 4, 5, 0};
        new _283_Move_Zeros().moveZeroes(nums);
        System.out.println(nums);
    }
}
