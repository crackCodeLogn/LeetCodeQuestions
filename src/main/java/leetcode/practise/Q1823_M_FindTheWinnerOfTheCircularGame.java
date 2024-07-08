package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-07-08
 */
public class Q1823_M_FindTheWinnerOfTheCircularGame {

    public static void main(String[] args) {
        Q1823_M_FindTheWinnerOfTheCircularGame q1823MFindTheWinnerOfTheCircularGame = new Q1823_M_FindTheWinnerOfTheCircularGame();
        System.out.println(q1823MFindTheWinnerOfTheCircularGame.findTheWinner(5, 2)); // 3
        System.out.println(q1823MFindTheWinnerOfTheCircularGame.findTheWinner(6, 5)); // 1
    }

    public int findTheWinner(int n, int k) {
        boolean[] friends = new boolean[n];
        int friendCount = n;
        int fp = n;

        while (friendCount > 1) {
            for (int i = 0; i < k; ++i, fp++)
                while (friends[fp % n])
                    fp++;
            friends[(fp - 1) % n] = true;
            friendCount--;
        }

        for (fp = 0; friends[fp]; fp++) ;
        return fp + 1;
    }
}
