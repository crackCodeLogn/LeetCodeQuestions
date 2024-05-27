package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-05-26
 */
public class Q0552_H_StudentAttendanceRecordII {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Q0552_H_StudentAttendanceRecordII q0552HStudentAttendanceRecordII = new Q0552_H_StudentAttendanceRecordII();
        System.out.println(q0552HStudentAttendanceRecordII.checkRecord(2)); // 8
        System.out.println(q0552HStudentAttendanceRecordII.checkRecord(1)); // 3
        System.out.println(q0552HStudentAttendanceRecordII.checkRecord(10101)); // 183236316
    }

    public int checkRecord(int n) {
        long[][] dp = new long[2][3];
        dp[0][0] = 1;

        while (n-- > 0) {
            long[][] prev = new long[2][3];
            for (int i = 0; i < 2; i++) System.arraycopy(dp[i], 0, prev[i], 0, 3);

            // Append a P.
            dp[0][0] = (prev[0][0] + prev[0][1] + prev[0][2]) % MOD;

            // Append an L.
            dp[0][1] = prev[0][0];

            // Append an L.
            dp[0][2] = prev[0][1];

            // Append an A or append a P.
            dp[1][0] = (prev[0][0] + prev[0][1] + prev[0][2] + prev[1][0] + prev[1][1] + prev[1][2]) % MOD;

            // Append an L.
            dp[1][1] = prev[1][0];

            // Append an L.
            dp[1][2] = prev[1][1];
        }

        return (int) ((dp[0][0] + dp[0][1] + dp[0][2] + dp[1][0] + dp[1][1] + dp[1][2]) % MOD);
    }
}
