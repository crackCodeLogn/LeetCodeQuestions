package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-09-04
 */
public class Q2028_M_FindMissingObservations {

    public static void main(String[] args) {
        Q2028_M_FindMissingObservations q2028MFindMissingObservations = new Q2028_M_FindMissingObservations();
        System.out.println(Arrays.toString(q2028MFindMissingObservations.missingRolls(new int[]{3, 2, 4, 3}, 4, 2)));
        System.out.println(Arrays.toString(q2028MFindMissingObservations.missingRolls(new int[]{1, 5, 6}, 3, 4)));
        System.out.println(Arrays.toString(q2028MFindMissingObservations.missingRolls(new int[]{1, 2, 3, 4}, 6, 4)));
    }

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int targetSum = (rolls.length + n) * mean;
        int sum = 0;
        for (int i = 0; i < rolls.length; i++) sum += rolls[i];
        int missingSum = targetSum - sum;
        if (missingSum > n * 6 || missingSum < n) return new int[]{};

        int[] ans = new int[n];
        Arrays.fill(ans, missingSum / n);
        missingSum %= n;
        for (int i = 0; i < missingSum; i++) ans[i]++;

        return ans;
    }
}
