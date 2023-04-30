package leetcode.contest.weekly.w343_202304;

/**
 * @author Vivek
 * @since 2023-04-30
 */
public class Q6341_E_DetermineTheWinnerOfABowlingGame {

    public static void main(String[] args) {
        Q6341_E_DetermineTheWinnerOfABowlingGame q6341EDetermineTheWinnerOfABowlingGame = new Q6341_E_DetermineTheWinnerOfABowlingGame();
        System.out.println(q6341EDetermineTheWinnerOfABowlingGame.isWinner(
                new int[]{9, 7, 10, 7},
                new int[]{10, 2, 4, 10}));
    }

    public int isWinner(int[] player1, int[] player2) {
        boolean f1 = false, f2 = false;
        int sum1 = 0, sum2 = 0, counter = 0;

        for (int i = 0; i < player1.length; i++) {
            sum1 += player1[i];
            if (counter <= 0) f1 = false;
            if (f1) sum1 += player1[i];
            if (player1[i] == 10) {
                f1 = true;
                counter = 2;
            } else counter--;
        }
        counter = 0;
        for (int i = 0; i < player2.length; i++) {
            sum2 += player2[i];
            if (counter <= 0) f2 = false;
            if (f2) sum2 += player2[i];
            if (player2[i] == 10) {
                f2 = true;
                counter = 2;
            } else counter--;
        }
        if (sum1 > sum2) return 1;
        else if (sum1 < sum2) return 2;
        return 0;
    }
}
