package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-01-27
 */
public class Q0629_H_KInversePairsArray {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Q0629_H_KInversePairsArray q0629HKInversePairsArray = new Q0629_H_KInversePairsArray();
        System.out.println(q0629HKInversePairsArray.kInversePairs(3, 0)); // 1
        System.out.println(q0629HKInversePairsArray.kInversePairs(3, 1)); // 2
    }

    public int kInversePairs(int n, int k) {
        int[][] data = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) data[i][0] = 1;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= k; j++) {
                data[i][j] = (data[i][j - 1] + data[i - 1][j]) % MOD;
                if (j - i >= 0) data[i][j] = (data[i][j] - data[i - 1][j - i] + MOD) % MOD;
            }

        return data[n][k];
    }

}
