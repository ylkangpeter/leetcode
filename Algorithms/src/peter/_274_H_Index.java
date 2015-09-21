package peter;

/**
 * Created by ylkang on 9/18/15.
 */
public class _274_H_Index {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0 ) {
            return 0;
        }
        int[] tmp = new int[citations.length + 1];

        for (int ele : citations) {
            if (ele > citations.length) {
                tmp[citations.length] += 1;
            } else {
                tmp[ele] += 1;
            }
        }

        if (tmp[citations.length] >= citations.length) {
            return citations.length;
        }
        for (int i = tmp.length - 2; i >= 0; i--) {
            tmp[i] += tmp[i + 1];
            if (i <= tmp[i]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new _274_H_Index().hIndex(new int[]{0, 0}));
    }
}
