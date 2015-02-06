package peter;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13",
 * "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * @author ylkang Feb 5, 2015
 */

public class _150_Evaluate_Reverse_Polish_Notation {

	public int evalRPN(String[] tokens) {
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			switch (tokens[i]) {
			case "+":
				s.push(s.pop() + s.pop());
				break;
			case "*":
				s.push(s.pop() * s.pop());
				break;
			case "/":
				int a = s.pop();
				s.push(s.pop() / a);
				break;
			case "-":
				a = s.pop();
				s.push(s.pop() - a);
				break;
			default:
				s.push(Integer.parseInt(tokens[i]));
			}
		}
		return s.pop();
	}

}