package leetcode.practise;

import java.util.Stack;

/**
 * @author Vivek
 * @since 2024-04-04
 */
public class Q1614_E_MaximumNestingDepthOfTheParenthesis {

    public static void main(String[] args) {
        Q1614_E_MaximumNestingDepthOfTheParenthesis q1614EMaximumNestingDepthOfTheParenthesis = new Q1614_E_MaximumNestingDepthOfTheParenthesis();
        System.out.println(q1614EMaximumNestingDepthOfTheParenthesis.maxDepth("(1+(2*3)+((8)/4))+1")); // 3
        System.out.println(q1614EMaximumNestingDepthOfTheParenthesis.maxDepth("(1)+((2))+(((3)))")); // 3
    }

    public int maxDepth(String s) {
        int max = 0, current = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push('(');
                current++;
                if (current > max) max = current;
            } else if (ch == ')') {
                stack.pop();
                current--;
            }
        }

        return max;
    }
}
