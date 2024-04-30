package leetcode.practise.grind75;

/**
 * @author Vivek
 * @since 2023-12-26
 */
public class Q0121_E_BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) { // 1ms
        int min = prices[0], delta = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i < prices.length - 1 && prices[i] < min) min = prices[i];
            delta = Math.max(delta, prices[i] - min);
        }
        return delta;
    }

    public int maxProfit2(int[] prices) { // 3 ms
        int n = prices.length;
        if (n == 1) return 0;
        if (n == 2) return Math.max(0, prices[1] - prices[0]);

        int[] max = new int[n];
        int[] min = new int[n];
        int gain = 0;
        max[n - 1] = prices[n - 1];
        min[0] = prices[0];

        for (int i = n - 2, j = 1; i > 0; i--, j++) {
            max[i] = Math.max(prices[i], max[i + 1]);
            min[j] = Math.min(prices[j], min[j - 1]);
        }

        for (int i = 1; i < n - 1; i++) gain = Math.max(gain, max[i] - min[i]);
        return gain;
    }
}
