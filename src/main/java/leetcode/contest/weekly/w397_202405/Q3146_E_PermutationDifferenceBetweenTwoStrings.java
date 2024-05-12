package leetcode.contest.weekly.w397_202405;

import java.util.Arrays;

public class Q3146_E_PermutationDifferenceBetweenTwoStrings {

    public int findPermutationDifference(String s, String t) {
        int[] data = new int[26];
        int score = 0;
        Arrays.fill(data, -1);
        for (int i = 0; i < s.length(); i++) data[s.charAt(i) - 'a'] = i;
        for (int i = 0; i < s.length(); i++) score += Math.abs(data[t.charAt(i) - 'a'] - i);
        return score;
    }
}
