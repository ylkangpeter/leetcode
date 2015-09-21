package peter;

/**
 * Created by ylkang on 9/18/15.
 */
public class _278_First_Bad_Version {
    boolean isBadVersion(int version) {
        byte[] boo = {1, 1, 1, 1, 1,1, 0, 0, 0, 0, 0, 0};
        return boo[version] == 0;
    }

    public int firstBadVersion(int n) {
        int start = 0;
        int end = n;
        int middle = 0;
        while (start <= end) {
            middle = (start + end) >>> 1;
            if (!isBadVersion(middle)) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return middle+1;
    }
    public static void main(String[] args){
        System.out.println(new _278_First_Bad_Version().firstBadVersion(10));
    }
}
