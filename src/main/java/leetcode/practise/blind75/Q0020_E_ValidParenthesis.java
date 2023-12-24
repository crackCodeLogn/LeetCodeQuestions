package leetcode.practise.blind75;

import java.util.Stack;

/**
 * @author Vivek
 * @since 2023-12-23
 */
public class Q0020_E_ValidParenthesis {
    public static void main(String[] args) {
        Q0020_E_ValidParenthesis q0020EValidParenthesis = new Q0020_E_ValidParenthesis();
        System.out.println(q0020EValidParenthesis.isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isOpening(ch)) stack.push(ch);
            else {
                if (stack.isEmpty()) return false;
                if (match(stack.peek(), ch)) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpening(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    private boolean match(char ch1, char ch2) {
        return ch2 - 1 == ch1 || ch2 - 2 == ch1;
    }
}
