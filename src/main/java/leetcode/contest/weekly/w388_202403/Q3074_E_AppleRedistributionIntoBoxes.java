package leetcode.contest.weekly.w388_202403;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-03-10
 */
public class Q3074_E_AppleRedistributionIntoBoxes {

    public static void main(String[] args) {
        Q3074_E_AppleRedistributionIntoBoxes q100233EAppleRedistributionIntoBoxes = new Q3074_E_AppleRedistributionIntoBoxes();
        System.out.println(q100233EAppleRedistributionIntoBoxes.minimumBoxes(new int[]{1, 3, 2}, new int[]{4, 3, 1, 5, 2}));
        System.out.println(q100233EAppleRedistributionIntoBoxes.minimumBoxes(new int[]{5, 5, 5}, new int[]{2, 4, 2, 7}));
        System.out.println(q100233EAppleRedistributionIntoBoxes.minimumBoxes(new int[]{9, 8, 8, 2, 3, 1, 6}, new int[]{10, 1, 4, 10, 8, 5})); // 5
    }

    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int i = 0; i < apple.length; i++) sum += apple[i];
        Arrays.sort(capacity);

        for (int i = capacity.length - 1, k = 0; i >= 0; i--) {
            k++;
            if (sum > capacity[i]) sum -= capacity[i];
            else return k;
        }
        return capacity.length;
    }
}
