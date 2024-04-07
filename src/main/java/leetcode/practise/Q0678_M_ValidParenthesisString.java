package leetcode.practise;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Vivek
 * @since 2024-04-07
 */
public class Q0678_M_ValidParenthesisString {

    private static final Map<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        Q0678_M_ValidParenthesisString q0678MValidParenthesisString = new Q0678_M_ValidParenthesisString();
        System.out.println(q0678MValidParenthesisString.checkValidString("()")); // true
        System.out.println(q0678MValidParenthesisString.checkValidString("(*)")); // true
        System.out.println(q0678MValidParenthesisString.checkValidString("(*))")); // true
        System.out.println(q0678MValidParenthesisString.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()")); // true
    }

    public boolean checkValidString(String s) {
        Stack<Integer> startStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') startStack.push(i);
            else if (ch == '*') starStack.push(i);
            else {
                if (startStack.isEmpty() && starStack.isEmpty()) return false;
                if (!startStack.isEmpty()) startStack.pop();
                else starStack.pop();
            }
        }

        while (!startStack.isEmpty()) {
            if (starStack.isEmpty()) return false;
            if (starStack.peek() <= startStack.peek()) return false;
            starStack.pop();
            startStack.pop();
        }
        return true;
    }

    public boolean checkValidString2(String s) {
        return compute(s.toCharArray(), 0, s.charAt(0));
    }

    private boolean compute(char[] s, int placeIndex, char replace) {
        s[placeIndex] = replace;
        int index = indexOf(s);
        if (index == -1) {
            return isValid(new String(s));
            /*String key = new String(s);
            Boolean val = map.get(key);
            if (val == null) {
                map.put(key, isValid(key));
                return map.get(key);
            }
            return val;*/
        }

        String key = new String(s);
        if (map.containsKey(key)) return map.get(key);

        boolean b1 = compute(s, index, '(');
        boolean b2 = compute(s, index, ')');
        boolean b3 = compute(s, index, '\0');
        boolean res = b1 || b2 || b3;
        map.put(key, res);
        return res;
    }

    private int indexOf(char[] data) {
        for (int i = 0; i < data.length; i++) if (data[i] == '*') return i;
        return -1;
    }

    public boolean isValid(String s) {
        int opens = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '\0') continue;
            if (ch == '(') opens++;
            else {
                if (opens == 0) return false;
                opens--;
            }
        }
        return opens == 0;
    }
}
