package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-01-23
 */
public class Q0997_E_FindTheTownJudge {

    public static void main(String[] args) {
        Q0997_E_FindTheTownJudge q0997EFindTheTownJudge = new Q0997_E_FindTheTownJudge();
        System.out.println(q0997EFindTheTownJudge.findJudge(2, new int[][]{
                {1, 2}
        }));
        System.out.println(q0997EFindTheTownJudge.findJudge(3, new int[][]{
                {1, 3},
                {2, 3}
        }));
        System.out.println(q0997EFindTheTownJudge.findJudge(3, new int[][]{
                {1, 3},
                {2, 3},
                {3, 1}

        }));
        System.out.println(q0997EFindTheTownJudge.findJudge(3, new int[][]{
                {1, 2},
                {2, 3}
        }));
        System.out.println(q0997EFindTheTownJudge.findJudge(4, new int[][]{
                {1, 3},
                {1, 4},
                {2, 3},
                {2, 4},
                {4, 3}
        }));
    }

    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) return 1;
        if (trust.length == 0) return -1;

        int[][] data = new int[n + 1][n + 1];
        for (int i = 0; i < trust.length; i++) {
            data[trust[i][0]][trust[i][1]]++;
        }

        int maxCol = -1, maxSum = -1;
        for (int j = 1; j <= n; j++) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += data[i][j];
            }
            if (sum == n - 1 && sum > maxSum) {
                maxSum = sum;
                maxCol = j;
            }
        }
        if (maxCol == -1) return -1;
        for (int j = 1; j <= n; j++) {
            if (data[maxCol][j] > 0) return -1;
        }
        return maxCol;
    }
}
