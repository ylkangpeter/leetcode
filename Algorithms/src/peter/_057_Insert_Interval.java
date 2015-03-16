package peter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import util.Util.Interval;

public class _057_Insert_Interval {

	public static List<Interval> insert(List<Interval> intervals,
			Interval newInterval) {

		List<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			result.add(newInterval);
			return result;
		}

		int startInx = Collections.binarySearch(intervals, newInterval,
				new Comparator<Interval>() {
					public int compare(Interval o1, Interval o2) {
						return o1.start > o2.start ? 1 : -1;
					}
				});

		if (startInx < 0) {
			startInx = -startInx - 1;
		}

		int endInx = Collections.binarySearch(intervals, newInterval,
				new Comparator<Interval>() {
					public int compare(Interval o1, Interval o2) {
						return o1.end > o2.end ? 1 : -1;
					}
				});

		if (endInx < 0) {
			endInx = -endInx - 1;
		}

		if (startInx == endInx) {
			if (startInx == 0) {
				Interval next = intervals.get(0);
				if (next.start <= newInterval.end) {
					intervals.get(0).start = newInterval.start;
				} else {
					intervals.add(0, newInterval);
				}
				return intervals;
			} else if (startInx == intervals.size()) {
				Interval pre = intervals.get(intervals.size() - 1);
				if (pre.end >= newInterval.start) {
					intervals.get(intervals.size() - 1).end = newInterval.end;
				} else {
					intervals.add(newInterval);
				}
				return intervals;
			} else {
				Interval pre = intervals.get(startInx - 1);
				Interval next = intervals.get(endInx);
				if (pre.end < newInterval.start) {
					if (next.start > newInterval.end) {
						intervals.add(startInx, newInterval);
					} else {
						Interval inter = new Interval(newInterval.start,
								next.end);
						intervals.set(startInx, inter);
					}
				} else {
					if (next.start > newInterval.end) {
						Interval inter = new Interval(pre.start,
								newInterval.end);
						intervals.set(startInx - 1, inter);
					} else {
						Interval inter = new Interval(pre.start, next.end);
						intervals.remove(startInx);
						intervals.set(startInx - 1, inter);
					}
				}
				return intervals;
			}
		} else if (startInx > endInx) {
			// 1-5 2-3
			return intervals;
		} else {
			Interval pre = null;
			Interval next = null;
			if (startInx == 0) {
				pre = newInterval;
			} else {
				pre = intervals.get(startInx - 1);
			}
			if (endInx == intervals.size()) {
				next = newInterval;
			} else {
				next = intervals.get(endInx);
			}

			if (pre.end < newInterval.start) {
				for (int i = 0; i < startInx; i++) {
					result.add(intervals.get(i));
				}
				if (next.start > newInterval.end) {
					result.add(newInterval);
					for (int i = endInx; i < intervals.size(); i++) {
						result.add(intervals.get(i));
					}
				} else {
					Interval inter = new Interval(newInterval.start, next.end);
					result.add(inter);
					for (int i = endInx + 1; i < intervals.size(); i++) {
						result.add(intervals.get(i));
					}
				}
			} else {
				for (int i = 0; i < startInx - 1; i++) {
					result.add(intervals.get(i));
				}
				if (next.start > newInterval.end) {
					Interval inter = new Interval(pre.start, newInterval.end);
					result.add(inter);
					for (int i = endInx; i < intervals.size(); i++) {
						result.add(intervals.get(i));
					}
				} else {
					Interval inter = new Interval(pre.start, next.end);
					result.add(inter);
					for (int i = endInx + 1; i < intervals.size(); i++) {
						result.add(intervals.get(i));
					}
				}
			}

		}

		return result;
	}

	public static void main(String[] args) {
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(3, 6));
		list.add(new Interval(9, 9));
		list.add(new Interval(11, 13));
		list.add(new Interval(14, 14));
		list.add(new Interval(16, 19));
		list.add(new Interval(20, 22));
		list.add(new Interval(23, 25));
		list.add(new Interval(30, 34));
		list.add(new Interval(41, 43));
		list.add(new Interval(45, 49));
		System.out.println(insert(list, new Interval(29, 32)));
		// [3,6],[9,9],[11,13],[14,14],[16,19],[20,22],[23,25],[30,34],[41,43],[45,49]
	}
}