package leetcode.practise;

import java.util.Stack;

/**
 * @author Vivek
 * @since 2024-04-12
 */
public class Q0402_M_RemoveKDigits {

    public static void main(String[] args) {
        Q0402_M_RemoveKDigits q0402MRemoveKDigits = new Q0402_M_RemoveKDigits();
        System.out.println(q0402MRemoveKDigits.removeKdigits("1432219", 3)); // 1219
        System.out.println(q0402MRemoveKDigits.removeKdigits("10200", 1)); // 1
        System.out.println(q0402MRemoveKDigits.removeKdigits("10", 2)); // 0
    }

    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        while (k-- > 0) stack.pop();
        for (final char c : stack) {
            if (c == '0' && sb.length() == 0) continue;
            sb.append(c);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
