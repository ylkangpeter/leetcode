package peter;

import java.util.LinkedList;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example: Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 * @author ylkang Mar 6, 2015
 */
public class _045_Jump_Game_II {

	private static class Node {
		int distance2End;
		int dis2Next;
		int offset;

		public Node(int end, int next, int offset) {
			this.distance2End = end;
			this.dis2Next = next;
			this.offset = offset;
		}

		@Override
		public String toString() {
			return String.format("toEnd:%s,toNext£º%s,offset£º%s", distance2End,
					dis2Next, offset);
		}
	}

	public static int jump(int[] A) {
		if (A == null || A.length == 1) {
			return 0;
		}

		int currentDestDistance = 0;

		LinkedList<Node> list = new LinkedList<Node>();

		int inx = A.length - 1;

		while (inx >= 0) {
			if (A[inx] > 0) {
				if (A[inx] >= currentDestDistance) {
					list.clear();
					list.add(new Node(1, 1, inx));
				} else {
					if (!list.isEmpty()) {
						int distance = A[inx];
						int gap = distance + inx - list.get(0).dis2Next
								- list.get(0).offset;
						Node tailPoint = null;
						while (gap >= 0 && !list.isEmpty()) {
							tailPoint = list.remove();
							if (!list.isEmpty()) {
								gap -= list.get(0).dis2Next;
							}
						}
						if (list.isEmpty()) {
							list.add(tailPoint);
						}
						int dis = list.get(0).distance2End + 1;
						list.addFirst(new Node(dis, list.get(0).offset - inx,
								inx));
					}
				}
			}
			inx--;
			currentDestDistance++;
		}

		return list.get(0).distance2End;
	}

	public int jump_better(int[] array) {
		if (array == null || array.length <= 1)
			return 0;
		int oldMax = array[0];
		int newMax = array[0];
		int ret = 1;
		for (int i = 1; i < array.length; i++) {
			if (oldMax >= array.length - 1)
				return ret;
			if (i > oldMax) {
				ret++;
				oldMax = newMax;
				if (i > oldMax)
					return Integer.MAX_VALUE;
			}
			newMax = Math.max(newMax, i + array[i]);
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(jump(new int[] { 3, 4, 3, 2, 5, 4, 3 }));
		System.out
				.println(jump(new int[] { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 }));
		System.out.println(jump(new int[] { 6, 9, 1, 5, 6, 0, 0, 5, 9 }));
		System.out.println(jump(new int[] { 1, 2, 1, 1, 1 }));
	}
}