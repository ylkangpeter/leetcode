package peter;

/**
 * Created by ylkang on 9/18/15.
 */
public class _278_First_Bad_Version {
    boolean isBadVersion(int version) {
        byte[] boo = {1, 1};
        return boo[version] == 0;
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int last = 1;
        boolean isBad = false;
        while (start <= end) {
            int middle = (start + end) >>> 1;
            if (!isBadVersion(middle)) {
                start = middle + 1;
            } else {
                end = middle - 1;
                last = middle;
            }
        }
        return last;

    }

    public static void main(String[] args) {
        System.out.println(new _278_First_Bad_Version().firstBadVersion(2));
    }
}
