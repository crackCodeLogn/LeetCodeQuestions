package leetcode.practise;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Vivek
 * @since 2024-04-06
 */
public class Q1249_M_MinimumRemoveToMakeValidParenthesis {

    public static void main(String[] args) {
        Q1249_M_MinimumRemoveToMakeValidParenthesis q1249MMinimumRemoveToMakeValidParenthesis = new Q1249_M_MinimumRemoveToMakeValidParenthesis();
        System.out.println(q1249MMinimumRemoveToMakeValidParenthesis.minRemoveToMakeValid("lee(t(c)o)de)")); // lee(t(c)o)de
        System.out.println(q1249MMinimumRemoveToMakeValidParenthesis.minRemoveToMakeValid("a)b(c)d")); // ab(c)d
        System.out.println(q1249MMinimumRemoveToMakeValidParenthesis.minRemoveToMakeValid("))((")); //
    }

    public String minRemoveToMakeValid(String s) { // 18ms
        int n = s.length();
        boolean[] valid = new boolean[n + 1];
        Arrays.fill(valid, true);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') stack.push(i);
            else if (ch == ')') {
                if (stack.isEmpty()) {
                    valid[i] = false;
                    continue;
                }
                stack.pop();
            }
        }
        while (!stack.isEmpty()) valid[stack.pop()] = false;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) if (valid[i]) res.append(s.charAt(i));
        return res.toString();
    }
}
