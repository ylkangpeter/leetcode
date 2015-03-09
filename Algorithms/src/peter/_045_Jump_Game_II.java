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
					list.add(new Node(1, 0, inx));

				} else {
					int i = Math.min(A[inx], list.size());
					if (!list.isEmpty()) {
						if (A[inx] >= list.get(0).dis2Next) {
							while (list.size() > 1) {
								distance = list.get(0).offset - inx;
								if (distance < A[inx]) {
									list.remove();
								} else {
									break;
								}
							}
							int dis = list.get(0).distance2End + 1;
							list.addFirst(new Node(dis, inx));
						}
					}
				}
			}
			inx--;
			currentDestDistance++;
		}

		return list.get(0).distance2End;
	}

	public static void main(String[] args) {
		System.out.println(jump(new int[] { 3, 4, 3, 2, 5, 4, 3 }));
	}
}