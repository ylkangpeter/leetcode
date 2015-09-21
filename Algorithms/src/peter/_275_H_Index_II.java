package peter;

/**
 * Created by ylkang on 9/18/15.
 */
public class _275_H_Index_II {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int len = citations.length;
        int start = 0;
        int end = len - 1;
        int middle = 0;
        while (start <= end) {
            middle = (start + end) >>> 1;
            if (citations[middle] >= middle) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return citations[middle - 1];
    }

    public static void main(String[] args) {
        int[] nums = {8, 5, 4, 1, 1};

        nums = new int[]{1, 1, 1, 1, 1};
        nums = new int[]{10, 9, 7, 6, 6};
        System.out.println(new _275_H_Index_II().hIndex(nums));
    }
}
