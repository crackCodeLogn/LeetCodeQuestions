package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-01-18
 */
public class Q0070_E_ClimbingStairs {

    private final int[] data = new int[46];

    public int climbStairs(int n) {
        return compute(n);
    }

    private int compute(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        if (data[n] > 0) return data[n];
        int v = compute(n - 1) + compute(n - 2);
        data[n] = v;
        return v;
    }
}
