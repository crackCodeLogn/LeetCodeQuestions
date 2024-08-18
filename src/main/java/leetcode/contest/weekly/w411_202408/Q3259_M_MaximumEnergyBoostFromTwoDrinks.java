package leetcode.contest.weekly.w411_202408;

/**
 * @author Vivek
 * @since 2024-08-18
 */
public class Q3259_M_MaximumEnergyBoostFromTwoDrinks {

    private int[] drink1;
    private int[] drink2;
    private int n;
    private long[][] dp;

    public static void main(String[] args) {
        Q3259_M_MaximumEnergyBoostFromTwoDrinks q3259MMaximumEnergyBoostFromTwoDrinks = new Q3259_M_MaximumEnergyBoostFromTwoDrinks();
        System.out.println(q3259MMaximumEnergyBoostFromTwoDrinks.maxEnergyBoost(new int[]{1, 3, 1}, new int[]{3, 1, 1}));
        System.out.println(q3259MMaximumEnergyBoostFromTwoDrinks.maxEnergyBoost(new int[]{4, 1, 1}, new int[]{1, 1, 3}));
    }

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        drink1 = energyDrinkA;
        drink2 = energyDrinkB;
        n = drink1.length;
        dp = new long[n * 2][2];

        return Math.max(solve(0, true), solve(0, false));
    }

    private long solve(int i, boolean current) {
        if (i >= n) return 0;
        if (dp[i][current ? 1 : 0] > 0) {
            //System.out.println("save");
            return dp[i][current ? 1 : 0];
        }

        long v1 = (current ? drink1[i] : drink2[i]) + Math.max(solve(i + 1, current), solve(i + 2, !current));
        dp[i][current ? 1 : 0] = v1;
        return v1;
    }

}
