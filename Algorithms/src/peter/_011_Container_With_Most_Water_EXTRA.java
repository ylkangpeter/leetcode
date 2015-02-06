package peter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * what if use all plated between i and j?
 * 
 * <pre>
 * 
 * |
 * |   |
 * | | | | |
 * 
 * where max is from 0 to 4. area is 4
 * </pre>
 * 
 * @author ylkang Feb 5, 2015
 */
public class _011_Container_With_Most_Water_EXTRA {

	public int maxArea(int[] height) {

		if (height == null || height.length == 0 || height.length == 1) {
			return 0;
		}

		int max = 0;

		List<Integer> l = new ArrayList<Integer>();

		if (height[0] > height[1]) {
			l.add(height[1]);
			max = height[1];
		} else {
			l.add(height[0]);
			l.add(height[1]);
			max = height[0];
		}
		for (int i = 2; i < height.length; i++) {
			int val = height[i];
			int inx = Collections.binarySearch(l, val);
			if (inx >= 0) {
				l = l.subList(0, inx + 1);
			} else {
				inx = -1 * inx - 1;
				l = l.subList(0, inx);
				l.add(height[i]);
			}
		}
		for (int k = 0; k < l.size(); k++) {
			max = Math.max(max, l.get(k) * (height.length - k));
		}
		return max;

	}
}