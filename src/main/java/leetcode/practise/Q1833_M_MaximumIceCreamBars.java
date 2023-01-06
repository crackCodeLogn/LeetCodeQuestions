package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2023-01-06
 */
public class Q1833_M_MaximumIceCreamBars {

    public int maxIceCream(int[] costs, int coins) {
        int cnt = 0, i = 0;
        Arrays.sort(costs);

        while (coins > 0 && i < costs.length) {
            if (costs[i] <= coins) {
                coins -= costs[i];
                cnt++;
            }
            i++;
        }
        return cnt;
    }
}
