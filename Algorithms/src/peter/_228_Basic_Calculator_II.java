package peter;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class _228_Basic_Calculator_II {

	private static final Set<String> operatorMap = new HashSet<String>();
	static {
		operatorMap.add("+");
		operatorMap.add("-");
		operatorMap.add("*");
		operatorMap.add("/F");
	}

	public int calculate(String s) {
		Stack<Long> numberStack = new Stack<Long>();
		Stack<Character> operatorStack = new Stack<Character>();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case ' ':
				break;
			case '+':
			case '-':
				operate(numberStack, operatorStack, sb, c, '(');
				sb = new StringBuilder();
				break;
			case '*':
			case '/':
				operate(numberStack, operatorStack, sb, c, '/');
				sb = new StringBuilder();
				break;
			case '(':
				if (sb.length() != 0) {
					numberStack.push(Long.parseLong(sb.toString()));
					sb = new StringBuilder();
				}
				operatorStack.push(c);
				sb = new StringBuilder();
				break;
			case ')':
				operate(numberStack, operatorStack, sb, c, '(');
				operatorStack.pop();
				sb = new StringBuilder();
				break;
			default:
				sb.append(c);
				break;
			}
		}

		long val = 0L;
		if (sb.length() != 0) {
			val = Long.parseLong(sb.toString());
		} else {
			val = numberStack.pop();
		}

		while (!numberStack.isEmpty() && !operatorStack.isEmpty()) {
			val = calc(numberStack, operatorStack, val);
		}

		return (int) val;
	}

	private void operate(Stack<Long> numberStack,
			Stack<Character> operatorStack, StringBuilder sb, char c, char oper) {
		long val = 0L;
		if (sb.length() != 0) {
			val = Long.parseLong(sb.toString());
			while (!operatorStack.isEmpty() && check(operatorStack, oper)) {
				val = calc(numberStack, operatorStack, val);
			}
			numberStack.push(val);
		} else {
			val = numberStack.pop();
			while (!numberStack.isEmpty() && !operatorStack.isEmpty()
					&& check(operatorStack, oper)) {
				val = calc(numberStack, operatorStack, val);

			}
			numberStack.push(val);
		}

		if (c != ')') {
			operatorStack.push(c);
		}
	}

	private boolean check(Stack<Character> operatorStack, char c) {
		switch (c) {
		case '(':
			return operatorStack.peek() != '(';
		case '/':
			return operatorStack.peek() == '*' || operatorStack.peek() == '/';
		}
		return false;
	}

	private long calc(Stack<Long> numberStack, Stack<Character> operatorStack,
			long val) {

		if (numberStack.isEmpty()) {
			return val;
		}
		long peekVal = numberStack.pop();
		char operator = operatorStack.pop();
		switch (operator) {
		case '+':
			val = peekVal + val;
			break;
		case '-':
			val = peekVal - val;
			break;
		case '*':
			val = val * peekVal;
			break;
		case '/':
			val = peekVal / val;
			break;
		default:
			numberStack.push(peekVal);
			break;
		}
		return val;
	}

	public static void main(String[] args) {
		System.out.println(new _228_Basic_Calculator_II().calculate("3+2*2"));
		System.out.println(new _228_Basic_Calculator_II().calculate("3/2"));
		System.out.println(new _228_Basic_Calculator_II()
				.calculate(" 3+5 / 2 "));
	}
}
