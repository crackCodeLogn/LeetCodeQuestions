package leetcode.practise;

import java.util.Stack;

/**
 * @author Vivek
 * @since 16/10/22
 */
public class Q0020_E_ValidParanthesis {

    public static void main(String[] args) {
        Q0020_E_ValidParanthesis object = new Q0020_E_ValidParanthesis();
        System.out.println(object.isValid("()"));
        System.out.println(object.isValid("(]"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            char peek = stack.peek();
            if (isPair(peek, ch)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    private boolean isPair(char c1, char c2) {
        switch (c1) {
            case '[':
                return c2 == ']';
            case '(':
                return c2 == ')';
            case '{':
                return c2 == '}';
        }
        return false;
    }
}
