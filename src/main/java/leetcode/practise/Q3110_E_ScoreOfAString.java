package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-06-01
 */
public class Q3110_E_ScoreOfAString {

    public int scoreOfString(String s) {
        int score = 0;
        for (int i = 1; i < s.length(); i++) score += Math.abs(s.charAt(i) - s.charAt(i - 1));
        return score;
    }
}
