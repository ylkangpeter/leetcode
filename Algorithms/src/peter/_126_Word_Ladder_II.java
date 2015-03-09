package peter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Given two words (start and end), and a dictionary, find all shortest
 * transformation sequence(s) from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 * 
 * <pre>
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 *   [
 *     ["hit","hot","dot","dog","cog"],
 *     ["hit","hot","lot","log","cog"]
 *   ]
 * </pre>
 * 
 * Note: All words have the same length. All words contain only lowercase
 * alphabetic characters.
 * 
 * @author ylkang Feb 26, 2015
 */
public class _126_Word_Ladder_II {

	static Map<String, List<String>> map;
	static List<List<String>> results;

	/**
	 * coyp from
	 * https://oj.leetcode.com/discuss/9523/share-two-similar-java-solution
	 * -that-accpted-by-oj
	 * 
	 * @param start
	 * @param end
	 * @param dict
	 * @return
	 */
	public static List<List<String>> findLadders3(String start, String end,
			Set<String> dict) {
		results = new ArrayList<List<String>>();
		if (dict.size() == 0)
			return results;

		int min = Integer.MAX_VALUE;

		Queue<String> queue = new ArrayDeque<String>();
		queue.add(start);

		map = new HashMap<String, List<String>>();

		dict.add(end);
		Map<String, Integer> ladder = new HashMap<String, Integer>();
		for (String string : dict)
			ladder.put(string, Integer.MAX_VALUE);
		ladder.put(start, 0);

		// BFS: Dijisktra search
		while (!queue.isEmpty()) {

			String word = queue.poll();

			int step = ladder.get(word) + 1;// 'step' indicates how many steps
											// are needed to travel to one word.

			if (step > min)
				break;

			for (int i = 0; i < word.length(); i++) {
				StringBuilder builder = new StringBuilder(word);
				for (char ch = 'a'; ch <= 'z'; ch++) {
					builder.setCharAt(i, ch);
					String new_word = builder.toString();
					if (ladder.containsKey(new_word)) {

						if (step > ladder.get(new_word))// Check if it is the
														// shortest path to one
														// word.
							continue;
						else if (step < ladder.get(new_word)) {
							queue.add(new_word);
							ladder.put(new_word, step);
						} else
							;// It is a KEY line. If one word already appeared
								// in one ladder,
								// Do not insert the same word inside the queue
								// twice. Otherwise it gets TLE.

						if (map.containsKey(new_word)) // Build adjacent Graph
							map.get(new_word).add(word);
						else {
							List<String> list = new LinkedList<String>();
							list.add(word);
							map.put(new_word, list);
							// It is possible to write three lines in one:
							// map.put(new_word,new
							// LinkedList<String>(Arrays.asList(new
							// String[]{word})));
							// Which one is better?
						}

						if (new_word.equals(end))
							min = step;

					}// End if dict contains new_word
				}// End:Iteration from 'a' to 'z'
			}// End:Iteration from the first to the last
		}// End While

		// BackTracking
		LinkedList<String> result = new LinkedList<String>();
		backTrace(end, start, result);

		return results;
	}

	private static void backTrace(String word, String start, List<String> list) {
		if (word.equals(start)) {
			list.add(0, start);
			results.add(new ArrayList<String>(list));
			list.remove(0);
			return;
		}
		list.add(0, word);
		if (map.get(word) != null)
			for (String s : map.get(word))
				backTrace(s, start, list);
		list.remove(0);
	}

	/**
	 * copy from
	 * https://oj.leetcode.com/discuss/21902/java-solution-with-iteration
	 * 
	 * @param start
	 * @param end
	 * @param dict
	 * @return
	 */
	public static List<List<String>> findLadders2(String start, String end,
			Set<String> dict) {
		List<List<String>> results = new ArrayList<List<String>>();
		dict.add(end);
		// instead of storing words we are at, we store the paths.
		Deque<List<String>> paths = new LinkedList<List<String>>();
		List<String> path0 = new LinkedList<String>();
		path0.add(start);
		paths.add(path0);
		// if we found a path ending at 'end', we will set lastLevel,
		// use this data to stop iterating further.
		int level = 1, lastLevel = Integer.MAX_VALUE;
		Set<String> wordsPerLevel = new HashSet<String>();
		while (!paths.isEmpty()) {
			List<String> path = paths.pollFirst();
			if (path.size() > level) {
				dict.removeAll(wordsPerLevel);
				wordsPerLevel.clear();
				level = path.size();
				if (level > lastLevel)
					break; // stop and return
			}
			// try to find next word to reach, continuing from the path
			String last = path.get(level - 1);
			char[] chars = last.toCharArray();
			for (int index = 0; index < last.length(); index++) {
				char original = chars[index];
				for (char c = 'a'; c <= 'z'; c++) {
					chars[index] = c;
					String next = new String(chars);
					if (dict.contains(next)) {
						wordsPerLevel.add(next);
						List<String> nextPath = new LinkedList<String>(path);
						nextPath.add(next);
						if (next.equals(end)) {
							results.add(nextPath);
							lastLevel = level; // curr level is the last level
						} else
							paths.addLast(nextPath);
					}
				}
				chars[index] = original;
			}
		}

		return results;
	}

	public static List<List<String>> findLadders(String start, String end,
			Set<String> dict) {

		if (start == null || end == null || dict == null || dict.isEmpty()
				|| start.equals(end)) {
			return null;
		}

		List<List<String>> list = new ArrayList<List<String>>();
		/**
		 * stack is used to store all transformed string. e.g.hit->hot. hot is
		 * stored in stack. then delete all transformation in the dict.
		 */
		Stack<Counter> stack = new Stack<Counter>();
		Set<String> set = new HashSet<String>();
		//
		// Map<String, Counter> counterMap = new HashMap<String, Counter>();

		int currentDistanceSize = 0;
		// fill stack
		if (dict.contains(start)) {
			Counter cc = new Counter(1, start);
			stack.add(cc);
			currentDistanceSize++;
		} else {
			for (String str : dict) {
				int distance = distance(str, start);
				if (distance == 1) {
					currentDistanceSize++;
					Counter cc = new Counter(1, start);

					stack.add(cc);
				}
			}
		}

		int currentDistance = -1;

		while (!stack.isEmpty()) {
			int number = currentDistanceSize;
			currentDistanceSize = 0;
			Set<String> tmpSet = set;
			set = new HashSet<String>();
			while (number-- != 0) {
				Counter tmp = stack.pop();
				int distance = distance(tmp.val, end);
				if (distance == 0) {
					currentDistance = tmp.counter;
					fillList(list, tmp);
				} else if (distance == 1) {
					currentDistance = tmp.counter + 1;
					Counter endC = new Counter(tmp.counter + 1, end);
					endC.parent = tmp;
					fillList(list, endC);
				} else {
					if (currentDistance != -1) {
						continue;
					}
					for (int i = 0; i < tmp.val.length(); i++) {
						char[] chars = tmp.val.toCharArray();
						for (int j = 97; j < 123; j++) {
							chars[i] = Character.toChars(j)[0];
							String str = new String(chars);
							if (!str.equals(tmp.val)) {
								if (dict.contains(str)) {
									Counter c = new Counter(tmp.counter + 1,
											str);
									currentDistanceSize++;
									c.parent = tmp;
									set.add(str);
									stack.insertElementAt(c, 0);
								}
							}
						}
					}
				}
			}

			dict.removeAll(tmpSet);
		}

		return list;

	}

	private static void fillList(List<List<String>> list, Counter tmp) {
		LinkedList<String> innerList = new LinkedList<String>();
		while (tmp != null) {
			innerList.addFirst(tmp.val);
			tmp = tmp.parent;
		}
		list.add(innerList);
	}

	private static class Counter {
		int counter;
		String val;
		Counter parent;

		Counter(int counter, String val) {
			this.counter = counter;
			this.val = val;
		}

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

	public static void main(String[] args) {

		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");

		// // "red", "tax", ["ted","tex","red","tax","tad","den","rex","pee"]
		// dict.add("ted");
		// dict.add("tex");
		// dict.add("red");
		// dict.add("tax");
		// dict.add("tad");
		// dict.add("den");
		// dict.add("rex");
		// dict.add("pee");
		System.out.println(findLadders3("hit", "cog", dict));

	}
}