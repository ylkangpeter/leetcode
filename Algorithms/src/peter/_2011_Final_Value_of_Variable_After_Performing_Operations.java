/**
 * project info: leetcode-peter
 */

package peter;

/**
 *
 */
public class _2011_Final_Value_of_Variable_After_Performing_Operations {
    public int finalValueAfterOperations(String[] operations) {
        int val = 0;
        for (String oper : operations) {
            if (oper.equals("++X") || oper.equals("X++")) {
                val++;
            } else {
                val--;
            }
        }
        return val;
    }
}
