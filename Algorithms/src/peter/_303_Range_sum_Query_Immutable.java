public class _303_Range_sum_Query_Immutable{
    private int[] nums;
    private int[] sums;

    public NumArray(int[] nums) {
        this.nums = nums;
        if (nums == null) {
            return;
        }
        sums = new int[nums.length+1];
        sums[0] = 0;
        for (int i=1; i<=nums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j+1] - sums[i];
    }
}