package peter;

/**
 * Created by ylkang on 8/25/15.
 */
public class _268_Missing_Number {

    public int missingNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long total = 0;
        for (int num : nums) {
            total += num;
            if (min > num) {
                min = num;
            }
            if (max < num) {
                max = num;
            }
        }
        long destTotal = (min + min + nums.length) * (nums.length + 1) / 2;
        if(destTotal-total>max){
            if(min==0){
                return (int) (destTotal - total);
            }else{
                return min-1;
            }
        }
        return (int) (destTotal - total);
    }

    public static void main(String[] args) {
        System.out.println(new _268_Missing_Number().missingNumber(new int[]{2, 1,3,5}));
    }
}
