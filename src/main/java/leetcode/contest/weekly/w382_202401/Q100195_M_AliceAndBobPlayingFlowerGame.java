package leetcode.contest.weekly.w382_202401;

/**
 * @author Vivek
 * @since 2024-01-28
 */
public class Q100195_M_AliceAndBobPlayingFlowerGame {

    public static void main(String[] args) {
        Q100195_M_AliceAndBobPlayingFlowerGame q100195MAliceAndBobPlayingFlowerGame = new Q100195_M_AliceAndBobPlayingFlowerGame();
        System.out.println(q100195MAliceAndBobPlayingFlowerGame.flowerGame(3, 2)); // 3
        System.out.println(q100195MAliceAndBobPlayingFlowerGame.flowerGame(1, 1)); // 0
    }

    public long flowerGame(int n, int m) {

        return getOdds(n) * getEvens(m) + getOdds(m) * getEvens(n);
    }

    private boolean isOdd(int n) {
        return (n & 1) == 1;
    }

    private long getOdds(int n) {
        return n / 2 + (isOdd(n) ? 1 : 0);
    }

    private long getEvens(int n) {
        return n / 2;
    }
}
