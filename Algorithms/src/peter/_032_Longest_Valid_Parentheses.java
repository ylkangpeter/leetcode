package peter;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 * 
 * @author ylkang May 13, 2015
 */
public class _032_Longest_Valid_Parentheses {

	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')' && !stack.isEmpty()
					&& s.charAt(stack.peek()) == '(') {
				stack.pop();
				max = Math
						.max(max, i - ((stack.isEmpty()) ? -1 : stack.peek()));
			} else
				stack.push(i);
		}
		return max;
	}

	public int longestValidParentheses_DP(String s) {
		/* max[i] = j means subsequence index i-j is longest valid Parentheses */
		int[] max = new int[s.length() + 1];
		max[s.length()] = s.length();
		int sum = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (max[i + 1] != i + 1) {
				if (max[i + 1] + 1 < s.length() && s.charAt(i) == '('
						&& s.charAt(max[i + 1] + 1) == ')') {
					max[i] = (max[i + 1] + 2 < s.length() + 1 && max[max[i + 1] + 2] != max[i + 1] + 2) ? max[max[i + 1] + 2]
							: max[i + 1] + 1;
				} else
					max[i] = i;
			} else if (i + 1 < s.length() && s.charAt(i + 1) == ')'
					&& s.charAt(i) == '(') {
				max[i] = (i + 2 < s.length() + 1 && max[i + 2] != i + 2) ? max[i + 2]
						: i + 1;
			} else
				max[i] = i;
			sum = Math.max(sum, max[i] - i + 1);
		}
		return (sum == 1) ? 0 : sum;
	}

	public static void main(String[] args) {
		System.out.println(new _032_Longest_Valid_Parentheses()
				.longestValidParentheses("()(((()(()))))"));
		System.out.println(new _032_Longest_Valid_Parentheses()
				.longestValidParentheses("(()()"));
		System.out.println(new _032_Longest_Valid_Parentheses()
				.longestValidParentheses("()(()"));
		System.out.println(new _032_Longest_Valid_Parentheses()
				.longestValidParentheses("()(()"));
		System.out.println(new _032_Longest_Valid_Parentheses()
				.longestValidParentheses("(()"));
		System.out.println(new _032_Longest_Valid_Parentheses()
				.longestValidParentheses(")()()"));
		System.out.println(new _032_Longest_Valid_Parentheses()
				.longestValidParentheses("))(("));
	}
}