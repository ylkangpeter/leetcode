package peter;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * 
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * 
 * @author ylkang Jun 26, 2015
 */

public class _228_Summary_Ranges {

	public List<String> summaryRanges(int[] nums) {

		List<String> list = new ArrayList<String>();
		if (nums == null || nums.length == 0) {
			return list;
		} else if (nums.length == 1) {
			list.add(String.valueOf(nums[0]));
			return list;
		}

		int base = nums[0];
		int pre = nums[0];
		int lastInQueue = 0;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - pre == 1) {
				pre = nums[i];
			} else {
				if (base == pre) {
					list.add(String.valueOf(base));
				} else {
					list.add(base + "->" + pre);
				}
				lastInQueue = pre;
				base = nums[i];
				pre = nums[i];
			}
		}
		if (lastInQueue != pre) {
			if (base == pre) {
				list.add(String.valueOf(base));
			} else {
				list.add(base + "->" + pre);
			}
		}
		return list;

	}

	public static void main(String[] args) {
//		System.out.println(new _229_Summary_Ranges()
//				.summaryRanges(new int[] { 0 }));
//		System.out.println(new _229_Summary_Ranges().summaryRanges(new int[] {
//				1, 2, 4, 5 }));
//		System.out.println(new _229_Summary_Ranges().summaryRanges(new int[] {
//				1, 2, 4, 5, 7, 8, 9 }));
//		System.out.println(new _229_Summary_Ranges().summaryRanges(new int[] {
//				1, 2, 3, 4, 5 }));
//		System.out.println(new _229_Summary_Ranges()
//				.summaryRanges(new int[] { -1 }));

	}
}
