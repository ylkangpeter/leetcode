/**
 * project info: leetcode-peter
 */

package peter;

/**
 * Given an integer array arr, return the length of a maximum size turbulent subarray of arr.
 * <p>
 * A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
 * <p>
 * More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:
 * <p>
 * For i <= k < j:
 * arr[k] > arr[k + 1] when k is odd, and
 * arr[k] < arr[k + 1] when k is even.
 * Or, for i <= k < j:
 * arr[k] > arr[k + 1] when k is even, and
 * arr[k] < arr[k + 1] when k is odd.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [9,4,2,10,7,8,8,1,9]
 * Output: 5
 * Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
 * Example 2:
 * <p>
 * Input: arr = [4,8,12,16]
 * Output: 2
 * Example 3:
 * <p>
 * Input: arr = [100]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 4 * 104
 * 0 <= arr[i] <= 109
 */
public class _978_Longest_Turbulent_Subarray {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }
        int[] nextBig = new int[arr.length];
        int[] nextSmall = new int[arr.length];
        nextBig[0] = 1;
        nextBig[1] = 1;
        nextSmall[1] = 1;
        nextSmall[0] = 1;
        if (arr[0] < arr[1]) {
            nextBig[1] = 2;
        } else if (arr[0] > arr[1]) {
            nextSmall[1] = 2;
        }

        for (int i = 2; i < arr.length; i++) {
            if (i % 2 != 0) {
                if (arr[i] > arr[i - 1]) {
                    nextBig[i] = nextBig[i - 1] + 1;
                    nextSmall[i] = 1;
                } else if (arr[i] < arr[i - 1]) {
                    nextBig[i] = 1;
                    nextSmall[i] = nextSmall[i - 1] + 1;
                } else {
                    nextBig[i] = 1;
                    nextSmall[i] = 1;
                }
            } else {
                if (arr[i] < arr[i - 1]) {
                    nextBig[i] = nextBig[i - 1] + 1;
                    nextSmall[i] = 1;
                } else if (arr[i] > arr[i - 1]) {
                    nextBig[i] = 1;
                    nextSmall[i] = nextSmall[i - 1] + 1;
                } else {
                    nextBig[i] = 1;
                    nextSmall[i] = 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < nextBig.length; i++) {
            max = Math.max(max, Math.max(nextBig[i], nextSmall[i]));
        }
        return max;
    }

    public static void main(String[] args) {
        new _978_Longest_Turbulent_Subarray().maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9});
    }
}
