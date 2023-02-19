package leetcode.contest.weekly.w331_202302;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2023-02-05
 */
public class Q2558_E_Take_Gifts_From_the_Richest_Pile {

    public static void main(String[] args) {
        Q2558_E_Take_Gifts_From_the_Richest_Pile q2558ETakeGiftsFromtheRichestPile = new Q2558_E_Take_Gifts_From_the_Richest_Pile();
        System.out.println(q2558ETakeGiftsFromtheRichestPile.pickGifts(new int[]{
                25, 64, 9, 4, 100
        }, 4));
    }

    public long pickGifts(int[] gifts, int k) {
        long cnt = 0;
        int n = gifts.length;
        while (k-- > 0) {
            Arrays.sort(gifts);
            int v = gifts[n - 1];
            gifts[n - 1] = (int) Math.sqrt(v);
        }
        for (int i = 0; i < n; i++) cnt += gifts[i];
        return cnt;
    }
}