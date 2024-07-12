package leetcode.practise;

import java.util.Stack;

/**
 * @author Vivek
 * @since 2024-07-12
 */
public class Q1717_M_MaximumScoreFromRemovingSubstrings {

    public static void main(String[] args) {
        Q1717_M_MaximumScoreFromRemovingSubstrings q1717MMaximumScoreFromRemovingSubstrings = new Q1717_M_MaximumScoreFromRemovingSubstrings();
        System.out.println(q1717MMaximumScoreFromRemovingSubstrings.maximumGain("cdbcbbaaabab", 4, 5)); // 19
        System.out.println(q1717MMaximumScoreFromRemovingSubstrings.maximumGain("aabbaaxybbaabb", 5, 4)); // 20
    }

    public int maximumGain(String s, int x, int y) { // 99ms
        char c1 = 'b', c2 = 'a', NULL = '\0';
        int[] gain = {y, x};
        if (x > y) {
            c1 = 'a';
            c2 = 'b';
            gain = new int[]{x, y};
        }
        int pts = 0;
        Stack<Integer> stack = new Stack<>();
        StringBuilder data = new StringBuilder(s);
        stack.push(data.length() - 1);

        for (int i = data.length() - 2; i >= 0; i--) {
            char ch = data.charAt(i);
            if (ch == c1 && !stack.isEmpty() && data.charAt(stack.peek()) == c2) {
                pts += gain[0];
                data.setCharAt(i, NULL);
                data.setCharAt(stack.pop(), NULL);
            } else stack.push(i);
        }
        StringBuilder data2 = data;
        stack.clear();
        if (data2.charAt(data2.length() - 1) != NULL)
            stack.push(data2.length() - 1);

        for (int i = data2.length() - 2; i >= 0; i--) {
            char ch = data2.charAt(i);
            if (ch == NULL) continue;
            if (ch == c2 && !stack.isEmpty() && data2.charAt(stack.peek()) == c1) {
                pts += gain[1];
                data2.setCharAt(i, NULL);
                data2.setCharAt(stack.pop(), NULL);
            } else stack.push(i);
        }

        return pts;
    }
}
