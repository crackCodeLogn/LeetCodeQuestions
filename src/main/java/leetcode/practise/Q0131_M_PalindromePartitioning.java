package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

public class Q0131_M_PalindromePartitioning {
    private List<List<String>> data;

    public static void main(String[] args) {
        Q0131_M_PalindromePartitioning q0131MPalindromePartitioning = new Q0131_M_PalindromePartitioning();
        System.out.println(q0131MPalindromePartitioning.partition("aab"));
        System.out.println(q0131MPalindromePartitioning.partition("a"));
    }

    public List<List<String>> partition(String s) {
        data = new ArrayList<>();
        compute(s, 0, new ArrayList<>());
        return data;
    }

    private void compute(String s, int start, List<String> path) {
        if (start == s.length()) {
            data.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++)
            if (isPalindrome(s, start, i)) {
                path.add(s.substring(start, i + 1));
                compute(s, i + 1, path);
                path.remove(path.size() - 1);
            }
    }

    private boolean isPalindrome(String s, int left, int right) {
        for (int i = left; i < right; i++, right--) if (s.charAt(i) != s.charAt(right)) return false;
        return true;
    }
}
