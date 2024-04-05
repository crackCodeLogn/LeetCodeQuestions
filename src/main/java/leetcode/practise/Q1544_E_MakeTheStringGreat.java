package leetcode.practise;

import java.util.Stack;

/**
 * @author Vivek
 * @since 2024-04-05
 */
public class Q1544_E_MakeTheStringGreat {

    public static void main(String[] args) {
        Q1544_E_MakeTheStringGreat q1544EMakeTheStringGreat = new Q1544_E_MakeTheStringGreat();
        System.out.println(q1544EMakeTheStringGreat.makeGood("leEeetcode")); // leetcode
        System.out.println(q1544EMakeTheStringGreat.makeGood("abBAcC")); //
        System.out.println(q1544EMakeTheStringGreat.makeGood("Pp")); //
    }

    public String makeGood(String s) { // 3ms
        if (s.length() == 1) return s;
        Stack<Character> stk = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (!stk.isEmpty()) {
                char ch2 = stk.peek();
                if (Math.abs(ch2 - ch) == 32) {
                    stk.pop();
                    continue;
                }
            }
            stk.push(ch);
        }
        StringBuilder data = new StringBuilder();
        while (!stk.isEmpty()) data.append(stk.pop());
        return data.toString();
    }

    public String makeGood2(String s) { // 3ms
        Stack<Character> stk1 = new Stack<>();
        Stack<Character> stk2 = new Stack<>();

        for (int i = 0; i < s.length(); i++) stk1.push(s.charAt(i));

        while (!stk1.isEmpty()) {
            char ch = stk1.pop();
            if (!stk2.isEmpty()) {
                char ch2 = stk2.peek();
                if (Math.abs(ch2 - ch) == 32) {
                    stk2.pop();
                    continue;
                }
            }
            stk2.push(ch);
        }
        StringBuilder data = new StringBuilder();
        while (!stk2.isEmpty()) data.append(stk2.pop());
        return data.toString();
    }
}
