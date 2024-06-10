package leetcode.contest.weekly.w401_202406;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-06-09
 */
public class Q3179_M_FindTheNthValueAfterKSeconds {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Q3179_M_FindTheNthValueAfterKSeconds q3179MFindTheNthValueAfterKSeconds = new Q3179_M_FindTheNthValueAfterKSeconds();
        System.out.println(q3179MFindTheNthValueAfterKSeconds.valueAfterKSeconds(4, 5));
        System.out.println(q3179MFindTheNthValueAfterKSeconds.valueAfterKSeconds(5, 3));
    }

    public int valueAfterKSeconds(int n, int k) {
        long[] data = new long[n];
        Arrays.fill(data, 1);
        while (k-- > 0) {
            for (int i = 1; i < n; i++) data[i] = (data[i - 1] + data[i]) % MOD;
        }
        return (int) data[n - 1];
    }
}
