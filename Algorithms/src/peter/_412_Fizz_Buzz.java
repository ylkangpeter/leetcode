/**
 * project info: leetcode-peter
 */

package peter;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return a string array answer (1-indexed) where:
 * <p>
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i if non of the above conditions are true.
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["1","2","Fizz"]
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: ["1","2","Fizz","4","Buzz"]
 * Example 3:
 * <p>
 * Input: n = 15
 * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _412_Fizz_Buzz {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int v = i + 1;
            if (v % 3 == 0 && v % 5 == 0) {
                result.add("FizzBuzz");
            } else if (v % 3 == 0) {
                result.add("Fizz");
            } else if (v % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(v));
            }
        }
        return result;

    }
}
