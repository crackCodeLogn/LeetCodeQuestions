package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-12-24
 */
public class Q1758_E_MinimumChangesToMakeAlternatingBinaryString {

    public static void main(String[] args) {
        Q1758_E_MinimumChangesToMakeAlternatingBinaryString q1758EMinimumChangesToMakeAlternatingBinaryString = new Q1758_E_MinimumChangesToMakeAlternatingBinaryString();
        System.out.println(q1758EMinimumChangesToMakeAlternatingBinaryString.minOperations("10"));
    }

    public int minOperations(String s) {
        int n = s.length();
        String s1 = getTarget('0', n);
        String s2 = getTarget('1', n);
        int n1 = 0, n2 = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s.charAt(i)) n1++;
            if (s2.charAt(i) != s.charAt(i)) n2++;
        }
        return Math.min(n1, n2);
    }

    private String getTarget(char ch, int n) {
        StringBuilder data = new StringBuilder();
        data.append(ch);
        for (int i = 1; i < n; i++) {
            data.append(getNext(data.charAt(i - 1)));
        }
        return data.toString();
    }

    private char getNext(char ch) {
        return ch == '0' ? '1' : '0';
    }
}
