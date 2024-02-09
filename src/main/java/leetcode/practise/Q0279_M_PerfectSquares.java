package leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-02-08
 */
public class Q0279_M_PerfectSquares {

    private static final List<Integer> squares = new ArrayList<>(100);
    private static final int UPPER = 101 * 101 + 1;
    private static final int[] data = new int[UPPER];

    public static void main(String[] args) {
        Q0279_M_PerfectSquares q0279MPerfectSquares = new Q0279_M_PerfectSquares();
        System.out.println(q0279MPerfectSquares.numSquares(10));
    }

    public int numSquares(int n) {
        int[] data = new int[n + 1];
        Arrays.fill(data, n);
        data[0] = 0;
        data[1] = 1;

        for (int i = 2; i <= n; i++)
            for (int j = 1; j * j <= i; j++)
                data[i] = Math.min(data[i], data[i - j * j] + 1);

        return data[n];
    }

    public int numSquares2(int n) {
        if (squares.isEmpty()) {
            for (int i = 1; i * i <= UPPER; i++) {
                squares.add(i * i);
                data[i * i] = 1;
            }
        }
        if (data[n] == 1) return 1;
        int num = 0;
        int i = 0;
        for (; i < UPPER && squares.get(i) < n; i++) ;
        i--;


        return -1;
    }

    private int compute(int n, int i, int high) {
        if (i > high) return 0;
        if (data[n] > 0) return data[n];
        int v = Integer.MAX_VALUE;
        if (n - squares.get(i) > 0) v = 1 + compute(n - squares.get(i), i, high);
        v = Math.min(v, compute(n, i + 1, high));
        data[n] = v;
        return v;
    }
}
