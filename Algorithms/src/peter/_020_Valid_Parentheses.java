package peter;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @author ylkang Feb 5, 2015
 */
public class _020_Valid_Parentheses {

	public boolean isValid(String s) {
		Stack<Integer> stack = new Stack<Integer>();

		for (char c : s.toCharArray()) {
			switch (c) {
			case '(':
				stack.push(1);
				break;
			case ')':
				if (stack.empty()) {
					return false;
				}
				int val = stack.pop();
				if (val != 1) {
					return false;
				}
				break;
			case '[':
				stack.push(2);
				break;
			case ']':
				if (stack.empty()) {
					return false;
				}
				val = stack.pop();
				if (val != 2) {
					return false;
				}
				break;
			case '{':
				stack.push(3);
				break;
			case '}':
				if (stack.empty()) {
					return false;
				}
				val = stack.pop();
				if (val != 3) {
					return false;
				}
				break;
			default:
				break;
			}
		}
		if (!stack.empty()) {
			return false;
		}
		return true;
	}

}