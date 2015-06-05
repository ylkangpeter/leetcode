package peter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * iven an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * 
 * For example, words: ["This", "is", "an", "example", "of", "text",
 * "justification."] L: 16.
 * 
 * Return the formatted lines as:
 * 
 * <pre>
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * </pre>
 * 
 * @author ylkang May 11, 2015
 */
public class _068_Text_Justification {

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> list = new ArrayList<String>();
		if (words == null || words.length == 0) {
			return list;
		}

		LinkedList<String> stack = new LinkedList<String>();

		int lineLength = 0;

		for (String word : words) {
			if (word.length() > maxWidth) {
				return new ArrayList<String>();
			}
			if (lineLength + word.length() < maxWidth) {
				stack.add(word);
				lineLength += word.length() + 1;
			} else if (lineLength + word.length() == maxWidth) {
				String str = word;
				if (stack.isEmpty()) {
					int padding = maxWidth - str.length();
					for (int i = 0; i < padding; i++) {
						str += " ";
					}
				} else {
					while (stack.size() > 0) {
						str = stack.pollLast() + " " + str;
					}
				}
				list.add(str);
				lineLength = 0;
			} else {
				print(maxWidth, list, stack, lineLength);
				stack.push(word);
				lineLength = word.length() + 1;
			}
		}

		StringBuilder last = new StringBuilder();
		while (!stack.isEmpty()) {
			last.append(stack.pop()).append(" ");
		}
		if (last.length() != 0) {
			last.deleteCharAt(last.length() - 1);
			int padding = maxWidth - last.length();
			for (int i = 0; i < padding; i++) {
				last.append(" ");
			}
			list.add(last.toString());
		}
		return list;
	}

	private void print(int maxWidth, List<String> list,
			LinkedList<String> stack, int lineLength) {
		if (!stack.isEmpty()) {
			if (stack.size() == 1) {
				String word = stack.pop();
				int padding = maxWidth - word.length();
				for (int i = 0; i < padding; i++) {
					word += " ";
				}
				list.add(word);
			} else {
				int len = lineLength - stack.size();
				int spaceNum = maxWidth - len;
				int baseLine = spaceNum / (stack.size() - 1);
				int minorSlots = spaceNum % (stack.size() - 1);

				String str = "";
				String spaces = "";
				for (int i = 0; i < baseLine; i++) {
					spaces += " ";
				}
				str = stack.pollFirst();
				while (!stack.isEmpty()) {
					if (minorSlots > 0) {
						str = str + " ";
					}
					str = str + spaces + stack.pollFirst();
					minorSlots--;
				}
				list.add(str);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new _068_Text_Justification().fullJustify(
				new String[] { "You", "never", "know", "what", "you're",
						"gonna", "get." }, 20));
		System.out.println(new _068_Text_Justification().fullJustify(
				new String[] { "Listen", "to", "many,", "speak", "to", "a",
						"few." }, 6));
		System.out.println(new _068_Text_Justification().fullJustify(
				new String[] { "This", "is", "an", "example", "of", "text",
						"justification." }, 16));
		System.out.println(new _068_Text_Justification().fullJustify(
				new String[] { "What", "must", "be", "shall", "be." }, 12));
		System.out.println(new _068_Text_Justification().fullJustify(
				new String[] { "Listen", "to", "many,", "speak", "to", "a",
						"few." }, 6));
		System.out.println(new _068_Text_Justification().fullJustify(
				new String[] { "a", "b", "c", "d", "e" }, 3));
		System.out.println(new _068_Text_Justification().fullJustify(
				new String[] { "a" }, 2));
		System.out.println(new _068_Text_Justification().fullJustify(
				new String[] { "" }, 3));
		System.out.println(new _068_Text_Justification().fullJustify(
				new String[] { "  " }, 3));

	}
}