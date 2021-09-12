/**
 * project info: leetcode-peter
 */

package peter;

import java.util.Stack;

public class _678_Valid_Parenthesis_String {

    public boolean checkValidString(String s) {

        Stack<Integer> starStack = new Stack<>();
        Stack<Integer> leftStack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ')') {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            } else if (arr[i] == '*') {
                starStack.push(i);
            } else {
                leftStack.push(i);
            }
        }
        if (leftStack.empty()) {
            return true;
        } else {
            while (!leftStack.isEmpty()) {
                if (starStack.isEmpty()) {
                    return false;
                } else {
                    if (leftStack.pop() > starStack.pop()) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {

    }
}
