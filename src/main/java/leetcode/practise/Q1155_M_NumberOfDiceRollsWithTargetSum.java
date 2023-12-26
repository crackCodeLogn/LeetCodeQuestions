package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-12-27
 */
public class Q1155_M_NumberOfDiceRollsWithTargetSum {
    private static final int MOD = (int) (1e9 + 7);
    private final int[][] data = new int[31][1001];

    public static void main(String[] args) {
        Q1155_M_NumberOfDiceRollsWithTargetSum q1155MNumberOfDiceRollsWithTargetSum = new Q1155_M_NumberOfDiceRollsWithTargetSum();
        //System.out.println(q1155MNumberOfDiceRollsWithTargetSum.numRollsToTarget(2, 6, 7)); // 6
        System.out.println(q1155MNumberOfDiceRollsWithTargetSum.numRollsToTarget(2, 5, 10)); // 1
        //System.out.println(q1155MNumberOfDiceRollsWithTargetSum.numRollsToTarget(30, 30, 500)); // 222616187
    }

    // memoization
    public int numRollsToTarget(int n, int k, int target) {
        int res = 0;

        if (n == 0 || target <= 0) {
            return n == target ? 1 : 0;
        }
        //System.out.printf("%d %d %d\n", n, k, target);
        if (data[n][target] > 0) {
            return data[n][target] - 1;
        }
        for (int i = 1; i <= k; i++) {
            res = (res + numRollsToTarget(n - 1, k, target - i)) % MOD;
        }
        data[n][target] = res + 1;
        return res;
    }

    // brute force op
    public int numRollsToTarget_0(int n, int k, int target) {
        int res = 0;
        if (n == 0 || target <= 0) {
            return n == target ? 1 : 0;
        }
        for (int i = 1; i <= k; i++) {
            res = (res + numRollsToTarget_0(n - 1, k, target - i)) % MOD;
        }
        return res;
    }
}
