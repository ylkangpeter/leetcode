package peter;

import java.util.Stack;

public class _155_Min_Stack {

	Stack<Integer> stack = new Stack<Integer>();

	int min = Integer.MAX_VALUE;

	public void push(int x) {
		if (x <= min) {
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}

	public void pop() {
		int val = stack.pop();
		if (val == min) {
			min = stack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min;
	}

}