package leetcode.practise;

import java.util.Arrays;

public class Q1482_M_MinimumNumberOfDaysToMakeMBouquets {

    public static void main(String[] args) {
        Q1482_M_MinimumNumberOfDaysToMakeMBouquets q1482MMinimumNumberOfDaysToMakeMBouquets = new Q1482_M_MinimumNumberOfDaysToMakeMBouquets();
        System.out.println(q1482MMinimumNumberOfDaysToMakeMBouquets.minDays(new int[]{1, 10, 3, 10, 2}, 3, 1)); // 3
        System.out.println(q1482MMinimumNumberOfDaysToMakeMBouquets.minDays(new int[]{1, 10, 3, 10, 2}, 3, 2)); // -1
        System.out.println(q1482MMinimumNumberOfDaysToMakeMBouquets.minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3)); // 12
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < (long) m * k) return -1;

        int lb = Arrays.stream(bloomDay).min().getAsInt();
        int ub = Arrays.stream(bloomDay).max().getAsInt();

        while (lb < ub) {
            int mid = (lb + ub) / 2;
            if (getBouquetCount(bloomDay, k, mid) >= m) ub = mid;
            else lb = mid + 1;
        }

        return lb;
    }

    private int getBouquetCount(int[] bloomDay, int k, int waitingDays) {
        int bouquetCount = 0;
        int requiredFlowers = k;
        for (final int day : bloomDay)
            if (day > waitingDays) {
                requiredFlowers = k;
            } else if (--requiredFlowers == 0) {
                ++bouquetCount;
                requiredFlowers = k;
            }
        return bouquetCount;
    }
}
