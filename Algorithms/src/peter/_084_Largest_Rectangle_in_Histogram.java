package peter;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where
 * the width of each bar is 1, find the area of largest rectangle in the
 * histogram.
 * 
 * 
 * @author ylkang Jun 5, 2015
 */
public class _084_Largest_Rectangle_in_Histogram {

	// http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
	public int largestRectangleArea(int[] height) {
		int len = height.length;
		Stack<Integer> s = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i <= len; i++) {
			int h = (i == len ? 0 : height[i]);
			if (s.isEmpty() || h >= height[s.peek()]) {
				s.push(i);
			} else {
				int tp = s.pop();
				maxArea = Math.max(maxArea, height[tp]
						* (s.isEmpty() ? i : i - 1 - s.peek()));
				i--;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		System.out.println(new _084_Largest_Rectangle_in_Histogram()
				.largestRectangleArea(new int[] { 1, 2, 3 }));
	}
}