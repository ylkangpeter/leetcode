package peter;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Given two words (start and end), and a dictionary, find the length of
 * shortest transformation sequence from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 * 
 * <pre>
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * </pre>
 * 
 * Note: Return 0 if there is no such transformation sequence. All words have
 * the same length. All words contain only lowercase alphabetic characters.
 * 
 * @author ylkang Feb 26, 2015
 */
public class _127_Word_Ladder {
	private static class Counter {
		int counter;
		String val;

		Counter(int counter, String val) {
			this.counter = counter;
			this.val = val;
		}
	}

	public static int ladderLength(String start, String end, Set<String> dict) {
		if (start == null || end == null || dict == null || dict.isEmpty()
				|| start.equals(end)) {
			return 0;
		}

		/**
		 * stack is used to store all transformed string. e.g.hit->hot. hot is
		 * stored in stack. then delete all transformation in the dict.
		 */
		Stack<Counter> stack = new Stack<Counter>();
		Counter cc = new Counter(1, start);
		stack.push(cc);

		while (!stack.isEmpty()) {
			Counter tmp = stack.pop();
			int distance = distance(tmp.val, end);
			if (distance == 0) {
				return tmp.counter;
			} else if (distance == 1) {
				return tmp.counter + 1;
			} else {
				for (int i = 0; i < tmp.val.length(); i++) {
					char[] chars = tmp.val.toCharArray();
					for (int j = 97; j < 123; j++) {
						chars[i] = Character.toChars(j)[0];
						String str = new String(chars);
						if (dict.contains(str)) {
							dict.remove(str);
							Counter tmpCc = new Counter(tmp.counter + 1, str);
							stack.insertElementAt(tmpCc, 0);
						}
					}
				}
			}
		}

		return 0;
	}

	private static int distance(String s1, String s2) {
		int diff = 0;
		for (int i = 0; i < s2.length(); i++) {
			diff += (s2.charAt(i) - s1.charAt(i)) == 0 ? 0 : 1;
			if (diff > 1) {
				return diff;
			}
		}

		return diff;
	}

	/**
	 * public static int ladderLength(String start, String end, Set<String>
	 * dict) {
	 * 
	 * if (start == null || end == null || dict == null || dict.isEmpty() ||
	 * start.equals(end)) { return 0; }
	 * 
	 * AtomicInteger distance = new AtomicInteger(1);
	 * 
	 * List<String> list = new ArrayList<String>(); list.addAll(dict);
	 * Collections.sort(list);
	 * 
	 * if (start.compareTo(end) > 0) { String tmp = start; start = end; end =
	 * tmp; }
	 * 
	 * int startInx = setPoint(start, distance, list); if (startInx < 0) {
	 * return 0; }
	 * 
	 * int endInx = setPoint(end, distance, list); if (endInx < 0) { return 0; }
	 * 
	 * String preS1 = list.get(startInx);
	 * 
	 * while (startInx != endInx) { String s1 = list.get(startInx); int dist1 =
	 * distance(s1, preS1); if (dist1 == 0) { startInx++; continue; } else if
	 * (dist1 > 1) { return 0; } else { distance.incrementAndGet(); int dis =
	 * distance(s1, list.get(endInx)); if (dis == 1) { return
	 * distance.incrementAndGet(); } if (dis == 0) { return distance.get(); }
	 * else { startInx++; } }
	 * 
	 * }
	 * 
	 * return 0; }
	 * 
	 * private static int setPoint(String start, AtomicInteger distance,
	 * List<String> list) { int inx = Collections.binarySearch(list, start);
	 * 
	 * if (inx < 0) { distance.incrementAndGet(); inx = -inx - 1; if (inx == 0)
	 * { if (distance(start, list.get(inx)) != 1) { return -1; } return inx; }
	 * else if (inx == list.size()) { return -1; } else { if (distance(start,
	 * list.get(inx)) == 1) { return inx; } else if (distance(start,
	 * list.get(inx - 1)) == 1) { return inx - 1; } else { return -1; } } } else
	 * { return inx; } }
	 * 
	 * private static int distance(String s1, String s2, int endOffset) { int
	 * diff = 0; for (int i = 0; i < endOffset; i++) { diff += (s2.charAt(i) -
	 * s1.charAt(i)) == 0 ? 0 : 1; }
	 * 
	 * return diff; }
	 */

	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.println(ladderLength("hit", "cog", dict));
	}
}