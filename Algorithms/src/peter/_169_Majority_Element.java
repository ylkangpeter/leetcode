package peter;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * Credits: Special thanks to @ts for adding this problem and creating all test
 * cases.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _169_Majority_Element {

	public int majorityElement(int[] num) {
		int major = num[0];
		int counter = 1;

		for (int i = 1; i < num.length; i++) {
			if (num[i] == major) {
				counter++;
				continue;
			}
			counter--;
			if (counter < 0) {
				counter = 0;
				major = num[i];
			}
		}
		return major;
	}

}