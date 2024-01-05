package leetcode.practise.grind75;

import java.util.Stack;

/**
 * @author Vivek
 * @since 2024-01-05
 */
public class Q0150_M_EvaluateReversePolishNotation {

    public static void main(String[] args) {
        Q0150_M_EvaluateReversePolishNotation q0150MEvaluateReversePolishNotation = new Q0150_M_EvaluateReversePolishNotation();
        System.out.println(q0150MEvaluateReversePolishNotation.evalRPN(new String[]{"2", "1", "+", "3", "*"})); // 9
        System.out.println(q0150MEvaluateReversePolishNotation.evalRPN(new String[]{"4", "13", "5", "/", "+"})); // 6
        System.out.println(q0150MEvaluateReversePolishNotation.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"})); // 22
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            Integer num = getInteger(token);
            if (num == null) {
                int n = -1;
                int n1 = stack.pop();
                int n2 = stack.pop();
                switch (token) {
                    case "+":
                        n = n1 + n2;
                        break;
                    case "-":
                        n = n2 - n1;
                        break;
                    case "*":
                        n = n1 * n2;
                        break;
                    case "/":
                        n = n2 / n1;
                        break;
                }
                stack.push(n);
            } else {
                stack.push(num);
            }
        }

        return stack.pop();
    }

    private Integer getInteger(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
