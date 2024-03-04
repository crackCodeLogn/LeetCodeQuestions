package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-03-04
 */
public class Q0948_M_BagOfTokens {

    public static void main(String[] args) {
        Q0948_M_BagOfTokens q0948MBagOfTokens = new Q0948_M_BagOfTokens();
        System.out.println(q0948MBagOfTokens.bagOfTokensScore(new int[]{100}, 50)); // 0
        System.out.println(q0948MBagOfTokens.bagOfTokensScore(new int[]{200, 100}, 150)); // 1
        System.out.println(q0948MBagOfTokens.bagOfTokensScore(new int[]{100, 200, 300, 400}, 200)); // 2
    }

    public int bagOfTokensScore(int[] tokens, int power) { // 4ms
        if (tokens.length == 0) return 0;

        Arrays.sort(tokens);
        int n = tokens.length;
        int left = 0, right = n - 1, score = 0;
        while (true) {
            if (power >= tokens[left]) {
                score++;
                power -= tokens[left++];
            } else if (score >= 1) {
                score--;
                power += tokens[right--];
            } else break;
            if (left > right) break;
            if (left == right) {
                if (power >= tokens[left]) score++;
                break;
            }
        }
        return score;
    }
}
