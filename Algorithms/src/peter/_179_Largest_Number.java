package peter;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of
 * an integer.
 * 
 * 
 * @author ylkang Feb 5, 2015
 */
public class _179_Largest_Number {

	class StringComparator implements Comparator<String> {
		public int compare(String s1, String s2) {
			String s1s2 = s1 + s2;
			String s2s1 = s2 + s1;
			if (s1s2.compareTo(s2s1) > 0)
				return -1;
			else if (s1s2.compareTo(s2s1) < 0)
				return 1;
			else if (s1.length() <= s2.length())
				return -1;
			else
				return 1;
		}
	}

	public String largestNumber(int[] num) {
		String[] nums = new String[num.length];
		for (int i = 0; i < num.length; i++) {
			nums[i] = String.valueOf(num[i]);
		}
		Comparator<String> comparator = new StringComparator();
		Arrays.sort(nums, comparator);

		StringBuilder str = new StringBuilder();
		for (String n : nums) {
			str.append(n);
		}
		return str.charAt(0) == '0' ? "0" : str.toString();
	}

}