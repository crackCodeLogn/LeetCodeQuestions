package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2023-10-22
 */
public class Q0155_M_MinStack {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(2147483646);
        stack.push(2147483646);
        stack.push(2147483647);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        stack.push(2147483647);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.push(-2147483648);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }

    static class MinStack {

        List<Node> data;
        int top;

        public MinStack() {
            data = new ArrayList<>(10000);
            top = -1;
        }

        private Node generateNode(int val) {
            return new Node(val, top == -1 ? val : Math.min(val, data.get(top).min));
        }

        public void push(int val) {
            if ((top == -1 && data.isEmpty()) || top + 1 == data.size()) {
                data.add(generateNode(val));
                //top++;
            } else
                data.set(top + 1, generateNode(val));
            top++;
        }

        public void pop() {
            top--;
        }

        public int top() {
            return data.get(top).getN();
        }

        public int getMin() {
            return data.get(top).getMin();
        }

        private class Node {
            private final int n;
            private final int min;

            public Node(int n, int min) {
                this.n = n;
                this.min = min;
            }

            public int getN() {
                return n;
            }

            public int getMin() {
                return min;
            }
        }
    }
}
