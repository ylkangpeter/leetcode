package peter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CopyOf_218_The_Skyline_Problem {

	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> list = new LinkedList<int[]>();
		if (buildings == null || buildings.length == 0) {
			return list;
		}

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
		List<List<int[]>> squares = new LinkedList<List<int[]>>();
		list.add(new int[] { buildings[0][0], buildings[0][2] });
		list.add(new int[] { buildings[0][1], buildings[0][2] });
		squares.add(list);

		for (int i = 1; i < buildings.length; i++) {
			squares = merge(squares, buildings[i]);
		}

		List<int[]> result = new ArrayList<int[]>();
		for (List<int[]> square : squares) {
			boolean isAdd = false;
			for (int[] cube : square) {
				if (!isAdd) {
					result.add(new int[] { cube[0], cube[1] });
					isAdd = true;
				} else {
					isAdd = false;
				}
			}
			result.add(new int[] { square.get(square.size() - 1)[0], 0 });
		}
		return result;
	}

	private List<List<int[]>> merge(List<List<int[]>> squares, int[] newSquare) {
		if (newSquare == null) {
			return squares;
		}

		List<int[]> list = new LinkedList<int[]>();
		list.add(new int[] { newSquare[0], newSquare[2] });
		int start = Collections.binarySearch(squares, list, new MyComparator());

		List<int[]> square = new LinkedList<int[]>();
		if (start >= 0) {
			square = squares.get(start);
			if (square.get(square.size() - 1)[0] < newSquare[1]) {
				if (square.get(square.size() - 1)[1] != newSquare[2]) {
					square.add(new int[] { square.get(square.size() - 1)[0],
							newSquare[2] });
					square.add(new int[] { newSquare[1], newSquare[2] });
				} else {
					square.get(square.size() - 1)[0] = newSquare[1];
				}
			}
		} else {
			start = -start - 1;
			if (start == 0) {
				List<int[]> tmpList = squares.get(start);
				if (tmpList.get(0)[0] <= newSquare[1]) {
					if (tmpList.get(0)[1] == newSquare[2]) {
						square.addAll(tmpList);
						square.get(0)[0] = newSquare[0];
					} else {
						square.add(new int[] { newSquare[0], newSquare[2] });
						square.add(new int[] { tmpList.get(0)[0], newSquare[2] });
						square.addAll(tmpList);
					}
				} else {
					square.add(new int[] { newSquare[0], newSquare[2] });
					square.add(new int[] { newSquare[1], newSquare[2] });
				}
			} else {
				List<int[]> pre = squares.get(start - 1);
				if (pre.get(pre.size() - 1)[0] >= newSquare[0]) {
					if (pre.get(pre.size() - 1)[1] == newSquare[1]) {
						pre.get(pre.size() - 1)[0] = newSquare[1];
					} else {
						square.add(new int[] { newSquare[0], newSquare[2] });
						square.add(new int[] { newSquare[1], newSquare[2] });
					}
				} else {
					square.add(new int[] { newSquare[0], newSquare[2] });
					square.add(new int[] { newSquare[1], newSquare[2] });
				}
			}
		}
		int offset = 0;
		if (square.get(square.size() - 1)[1] == newSquare[2]) {
			offset = square.get(square.size() - 1)[0];
			square.remove(square.size() - 1);
		}
		int inx = start + 1;
		while (inx < squares.size()
				&& squares.get(inx).get(0)[0] <= newSquare[1]) {

			List<int[]> tmp = squares.get(inx);
			if (tmp.get(0)[1] > newSquare[1]) {
				square.add(new int[] { tmp.get(0)[0], newSquare[1] });
			}
			square.addAll(tmp);
			if (square.get(square.size() - 1)[1] == newSquare[2]) {
				offset = square.get(square.size() - 1)[0];
				square.remove(square.size() - 1);
			}
			inx++;
		}
		if (square.size() % 2 != 0) {
			square.add(new int[] { offset, newSquare[2] });
		}
		inx--;
		List<List<int[]>> result = new LinkedList<List<int[]>>();
		result.addAll(squares.subList(0, start));
		result.add(square);
		if (inx < squares.size())
			result.addAll(squares.subList(inx, squares.size()));
		squares.clear();
		return result;
	}

	private static class MyComparator implements Comparator<List<int[]>> {

		@Override
		public int compare(List<int[]> o1, List<int[]> o2) {
			if (o1.get(0)[0] <= o2.get(0)[0]
					&& o1.get(o1.size() - 1)[0] >= o2.get(0)[0]) {
				return 0;
			} else if (o1.get(0)[0] > o2.get(0)[0]) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new CopyOf_218_The_Skyline_Problem()
				.getSkyline(new int[][] { { 1, 2, 1 },
						{ 2147483646, 2147483647, 2147483647 } }));
		System.out.println(new CopyOf_218_The_Skyline_Problem()
				.getSkyline(new int[][] { { 0, 2, 3 }, { 2, 5, 3 } }));
		System.out.println(new CopyOf_218_The_Skyline_Problem()
				.getSkyline(new int[][] { { 0, 5, 7 }, { 5, 10, 7 },
						{ 5, 10, 12 }, { 10, 15, 7 }, { 15, 20, 7 },
						{ 15, 20, 12 }, { 20, 25, 7 } }));
		// System.out
		// .println(new CopyOf_218_The_Skyline_Problem()
		// .getSkyline(new int[][] { { 1, 5, 3 }, { 1, 5, 3 },
		// { 1, 5, 3 } }));
		// System.out.println(new CopyOf_218_The_Skyline_Problem()
		// .getSkyline(new int[][] { { 0, 2, 3 }, { 2, 5, 3 } }));
		// System.out.println(new CopyOf_218_The_Skyline_Problem()
		// .getSkyline(new int[][] { { 0, 5, 7 }, { 5, 10, 7 },
		// { 5, 10, 12 }, { 10, 15, 7 }, { 15, 20, 7 },
		// { 15, 20, 12 }, { 20, 25, 7 } }));
		System.out.println(new CopyOf_218_The_Skyline_Problem()
				.getSkyline(new int[][] { { 2, 9, 10 }, { 3, 7, 15 },
						{ 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 }
				// ,{ 10, 13, 13 }
				}));

	}
}
