package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 24/10/22
 */
public class Q204_M_Count_Primes {

    public static void main(String[] args) {
        Q204_M_Count_Primes object = new Q204_M_Count_Primes();
        System.out.println(object.countPrimes(2));
    }

    public int countPrimes(int n) {
        boolean[] marked = new boolean[n + 1];
        Arrays.fill(marked, true);
        for (int i = 2; i <= n; i++) {
            for (int j = i * 2; j <= n; j += i) marked[j] = false;
        }
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (marked[i]) cnt++;
        }
        return cnt;
    }
}
