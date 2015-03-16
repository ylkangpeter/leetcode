package peter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import util.Util.Interval;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * 
 * @author peter Mar 16, 2015
 * 
 */
public class _056_Merge_Intervals {

	public static List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0) {
			return intervals;
		}

		Collections.sort(intervals, new Comparator<Interval>() {

			public int compare(Interval o1, Interval o2) {
				if (o1.start > o2.start) {
					return 1;
				} else if (o1.start == o2.start) {
					return 0;
				} else {
					return -1;
				}
			}
		});

		List<Interval> result = new ArrayList<Interval>();
		Interval current = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval element = intervals.get(i);
			if (element.start > current.end) {
				result.add(current);
				current = element;
			} else {
				if (element.end >= current.end) {
					current.end = element.end;
				}
			}
		}
		result.add(current);
		return result;
	}

	public static void main(String[] args) {
		Interval inter1 = new Interval(1, 3);
		Interval inter2 = new Interval(2, 6);
		Interval inter3 = new Interval(8, 10);
		Interval inter4 = new Interval(15, 18);

		List<Interval> list = new ArrayList<Interval>();
		list.add(inter1);
		list.add(inter2);
		list.add(inter3);
		list.add(inter4);
		System.out.println(merge(list));
	}

}