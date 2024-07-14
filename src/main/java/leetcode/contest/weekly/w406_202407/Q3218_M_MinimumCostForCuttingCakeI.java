package leetcode.contest.weekly.w406_202407;

/**
 * @author Vivek
 * @since 2024-07-14
 */
public class Q3218_M_MinimumCostForCuttingCakeI {

    public static void main(String[] args) {
        Q3218_M_MinimumCostForCuttingCakeI q3217MMinimumCostForCuttingCakeI = new Q3218_M_MinimumCostForCuttingCakeI();
        System.out.println(q3217MMinimumCostForCuttingCakeI.minimumCost(3, 2, new int[]{1, 3}, new int[]{5})); // 13
        System.out.println(q3217MMinimumCostForCuttingCakeI.minimumCost(2, 2, new int[]{7}, new int[]{4})); // 15
    }

    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        return compute(0, 0, m - 1, n - 1, horizontalCut, verticalCut);
    }

    private int compute(int r1, int c1, int r2, int c2, int[] hc, int[] vc) {
        if (r1 == r2 && c1 == c2) {
            return 0;
        }

        int cost = 0, r = -1, c = -1;
        for (int i = c1; i < c2; i++) {
            if (vc[i] > cost) {
                cost = vc[i];
                c = i;
                r = -1;
            }
        }
        for (int i = r1; i < r2; i++) {
            if (hc[i] > cost) {
                cost = hc[i];
                r = i;
                c = -1;
            }
        }
        if (r == -1) { // found most expensive in c
            return cost + compute(r1, c1, r2, c, hc, vc) + compute(r1, c + 1, r2, c2, hc, vc);
        }
        return cost + compute(r1, c1, r, c2, hc, vc) + compute(r + 1, c1, r2, c2, hc, vc);

    }
}
