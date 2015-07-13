package peter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 * 
 * <pre>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * </pre>
 * 
 * Notes: You may assume that all operations are valid (for example, no pop or
 * top operations will be called on an empty stack). Depending on your language,
 * queue may not be supported natively. You may simulate a queue by using a list
 * or deque (double-ended queue), as long as you use only standard operations of
 * a queue -- which means only push to back, pop from front, size, and is empty
 * operations are valid.
 * 
 * @author ylkang Jun 11, 2015
 */
public class _225_Implement_Stack_using_Queues {/*
												 * cur refers to Q containing
												 * all the elements
												 */
	Queue<Integer> cur = new LinkedList<Integer>();

	/* other used as tmp Q; always empty after API called */
	Queue<Integer> other = new LinkedList<Integer>();

	private void swapQ() {
		Queue<Integer> tmp = cur;
		cur = other;
		other = tmp;
	}

	// Push element x onto stack.
	public void push(int x) {
		cur.offer(x);
	}

	// Removes the element on top of the stack.
	public void pop() {
		while (cur.size() > 1)
			other.offer(cur.poll());
		cur.poll();
		swapQ();
	}

	// Get the top element.
	public int top() {
		while (cur.size() > 1)
			other.offer(cur.poll());
		int res = cur.poll();
		other.offer(res);
		swapQ();
		return res;
	}

	public static void main(String[] args) {
	}
}
