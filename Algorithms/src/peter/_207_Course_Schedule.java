package peter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * For example:
 * 
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0, and to take course 0 you should also have
 * finished course 1. So it is impossible.
 * 
 * @author ylkang May 7, 2015
 */
public class _207_Course_Schedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses <= 1 || prerequisites == null) {
			return true;
		}

		Map<Integer, ListNode> nodesMap = new HashMap<Integer, ListNode>();
		Set<Integer> root = new HashSet<Integer>();

		for (int i = 0; i < prerequisites.length; i++) {
			int father = prerequisites[i][1];
			int son = prerequisites[i][0];
			if (root.contains(son)) {
				root.remove(son);
				root.add(father);
			}

			if (!nodesMap.containsKey(son)) {
				nodesMap.put(son, new ListNode(son));
			}
			if (!nodesMap.containsKey(father)) {
				nodesMap.put(father, new ListNode(father));
				root.add(father);
			}
			nodesMap.get(father).next.add(nodesMap.get(son));
		}

		for (int val : root) {
			ListNode n = nodesMap.get(val);
			if (n.status != 2) {
				if (isLoop(n)) {
					return false;
				}
			}
		}
		return true;

	}

	private boolean isLoop(ListNode n) {
		if (n.status == 1) {
			return true;
		}
		n.status = 1;
		for (ListNode node : n.next) {
			if (node.status == 1 || isLoop(node)) {
				return true;
			}
		}
		n.status = 2;
		return false;
	}

	private static class ListNode {
		public int val;
		public int status = 0;
		public Set<ListNode> next = new HashSet<ListNode>();

		public ListNode(int x) {
			val = x;
			next = new HashSet<ListNode>();
		}

		public String toString() {
			return String.valueOf(val);
		}
	}

	public static void main(String[] args) {
		System.out.println(new _207_Course_Schedule().canFinish(5, new int[][] {
				{ 2, 0 }, { 2, 1 } }));
		System.out.println(new _207_Course_Schedule().canFinish(5, new int[][] {
				{ 0, 1 }, { 1, 0 } }));
		System.out.println(new _207_Course_Schedule().canFinish(5, new int[][] {
				{ 1, 0 }, { 0, 1 }, { 1, 2 }, { 3, 4 } }));

		System.out.println(new _207_Course_Schedule().canFinish(5, new int[][] {
				{ 1, 0 }, { 2, 1 } }));

	}
}
