package leetcode.practise.grind75;

import java.util.Stack;

/**
 * @author Vivek
 * @since 2023-12-23
 */
public class Q0232_E_ImplementQueueUsingStacks {

    private final Stack<Integer> stack;

    public Q0232_E_ImplementQueueUsingStacks() {
        stack = new Stack<>();
    }

    public void push(int x) {
        Stack<Integer> buff = new Stack<>();
        while (!stack.isEmpty()) buff.push(stack.pop());
        stack.push(x);
        while (!buff.isEmpty()) stack.push(buff.pop());
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
