package peter;

import java.util.Stack;

public class _232_Implement_Queue_Using_Stacks {

	private Stack<Integer> stack = new Stack<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		Stack<Integer> tmp = new Stack<Integer>();

		while (!stack.isEmpty()) {
			tmp.push(stack.pop());
		}
		stack.push(x);
		while (!tmp.isEmpty()) {
			stack.push(tmp.pop());
		}
	}

	// Removes the element from in front of queue.
	public void pop() {
		if (!stack.isEmpty()) {
			stack.pop();
		}
	}

	// Get the front element.
	public int peek() {
		if (!stack.isEmpty()) {
			return stack.peek();
		}
		return 0;
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		_232_Implement_Queue_Using_Stacks a = new _232_Implement_Queue_Using_Stacks();
		a.push(1);
		a.push(2);
		a.push(3);
		System.out.println(a.peek());
		a.pop();
		System.out.println(a.peek());
	}
}
