package peter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _218_The_Skyline_Problem {

	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> list = new ArrayList<int[]>();
		return list;
	}

	private void merge(List<List<int[]>> squares, int[] newSquare) {
		if (newSquare == null) {
			return;
		}

		List<int[]> list = new ArrayList<int[]>();
		list.add(new int[] { newSquare[1], newSquare[2] });
		int end = Collections.binarySearch(squares, list, new MyComparator());

		list = new ArrayList<int[]>();
		list.add(new int[] { newSquare[0], newSquare[2] });
		int start = Collections.binarySearch(squares, list, new MyComparator());

		if (start == end) {
			list.add(new int[] { newSquare[1], newSquare[2] });
			squares.add(Math.abs(start), list);
		}

		if (start < 0) {
			start = -start - 1;
			// merge start to end-1

			List<int[]> ll = squares.get(start);
			ll.add(0, new int[] { newSquare[0], newSquare[2] });
			for (int i = start + 1; i < end - 1; i++) {
				ll.addAll(squares.get(i));
				ll.add(squares.get(i).get(squares.get(i).size()-1)[1]);
			}
		}

	}

	private static class MyComparator implements Comparator<List<int[]>> {

		@Override
		public int compare(List<int[]> o1, List<int[]> o2) {
			if (o1.get(0)[0] > o2.get(0)[0]) {
				return 1;
			} else if (o1.get(0)[0] < o2.get(0)[0]) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}
