package peter;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 * 
 * @author ylkang Feb 6, 2015
 */
public class _001_Two_Sum {

	public int[] twoSum(int[] numbers, int target) {

		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (m.get(numbers[i]) == null) {
				m.put(target - numbers[i], i + 1);
			} else {
				return new int[] { m.get(numbers[i]), i + 1 };
			}
		}
		return new int[] { 1, 1 };

	}

}