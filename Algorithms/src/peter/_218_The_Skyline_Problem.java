package peter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _218_The_Skyline_Problem {

	public List<int[]> getSkyline(int[][] buildings) {

		Arrays.sort(buildings, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				int[] p1 = (int[]) o1;
				int[] p2 = (int[]) o2;
				if (p1[2] > p2[2]) {
					return -1;
				} else if (p1[2] < p2[2]) {
					return 1;
				} else
					return 0;
			}
		});
		List<int[]> list = new ArrayList<int[]>();
		List<List<int[]>> squares = new ArrayList<List<int[]>>();
		list.add(new int[] { buildings[0][0], buildings[0][2] });
		list.add(new int[] { buildings[0][1], buildings[0][2] });
		squares.add(list);

		for (int i = 1; i < buildings.length; i++) {
			merge(squares, buildings[i]);
		}
		System.out.println(squares);
		return null;
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
			if (start < 0) {
				start = -start - 1;
			}
			if (start == 0) {
				squares.add(0, list);
			} else {
				List<int[]> tmp = squares.get(start - 1);
				if (tmp.get(tmp.size() - 1)[0] >= newSquare[0]) {
					tmp.add(new int[] { tmp.get(tmp.size() - 1)[0],
							newSquare[2] });
					tmp.add(new int[] { newSquare[1], newSquare[2] });
				} else {
					squares.add(start, list);
				}
			}
		} else {
			if (start < 0) {
				start = -start - 1;
			}
			if (end < 0) {
				end = -end - 1;
			}
			// merge start to end-1
			list.add(new int[] { squares.get(start).get(0)[0], newSquare[2] });

			List<List<int[]>> result = new ArrayList<List<int[]>>();

			if (start != 0) {
				int tmp = squares.get(start - 1).get(
						squares.get(start - 1).size() - 1)[0];
				if (tmp >= newSquare[0]) {
					squares.get(start - 1)
							.add(new int[] {
									squares.get(start - 1).get(
											squares.get(start - 1).size() - 1)[0],
									newSquare[2] });
					list = squares.get(start - 1);
				} else {
					list.addAll(squares.get(start - 1));
				}

			} else {
				list.addAll(squares.get(start));
			}

			int val = squares.get(end - 1).get(squares.get(end - 1).size() - 1)[0];

			if (val < newSquare[1]) {
				squares.get(squares.size() - 1)
						.add(new int[] {
								squares.get(squares.size() - 1)
										.get(squares.get(squares.size() - 1)
												.size() - 1)[0], newSquare[2] });
				squares.get(squares.size() - 1).add(
						new int[] { newSquare[1], newSquare[2] });
			}
			squares.get(end - 1).add(0,
					new int[] { squares.get(end - 1).get(0)[0], newSquare[2] });

			for (int i = start; i < end; i++) {
				list.addAll(squares.get(i));
				list.add(new int[] {
						squares.get(i).get(squares.get(i).size() - 1)[1],
						newSquare[2] });
			}

			int inx = end;

			List<List<int[]>> tmp = new ArrayList<List<int[]>>(squares.subList(
					inx, squares.size()));
			tmp.add(0, list);
			squares.clear();
			squares.addAll(tmp);
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

	public static void main(String[] args) {
		System.out.println(new _218_The_Skyline_Problem()
				.getSkyline(new int[][] { { 2, 9, 10 }, { 3, 7, 15 },
						{ 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 },
						{ 10, 13, 13 } }));
	}
}
