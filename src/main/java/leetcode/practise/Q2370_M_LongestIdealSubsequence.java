package leetcode.practise;

public class Q2370_M_LongestIdealSubsequence {

    public int longestIdealString(String s, int k) {
        int maxLength = 1;
        int[] data = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int v = s.charAt(i) - 'a';
            int length = 0;
            for (int j = Math.max(0, v - k); j <= Math.min(25, v + k); j++)
                length = Math.max(length, data[j]);
            data[v] = 1 + length;
            maxLength = Math.max(maxLength, data[v]);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Q2370_M_LongestIdealSubsequence q2370MLongestIdealSubsequence = new Q2370_M_LongestIdealSubsequence();
        System.out.println(q2370MLongestIdealSubsequence.longestIdealString("acfgbd", 2)); // 4
        System.out.println(q2370MLongestIdealSubsequence.longestIdealString("abcd", 3)); // 4
    }
}
