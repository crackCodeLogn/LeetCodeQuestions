package leetcode.contest.weekly.w398_202405;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-05-19
 */
public class Q3153_M_SumOfDigitDifferencesOfAllPairs {

    public static void main(String[] args) {
        Q3153_M_SumOfDigitDifferencesOfAllPairs q3153MSumOfDigitDifferencesOfAllPairs = new Q3153_M_SumOfDigitDifferencesOfAllPairs();
        System.out.println(q3153MSumOfDigitDifferencesOfAllPairs.sumDigitDifferences(new int[]{12, 23, 12}));
        System.out.println(q3153MSumOfDigitDifferencesOfAllPairs.sumDigitDifferences(new int[]{12, 23, 12, 45}));
        System.out.println(q3153MSumOfDigitDifferencesOfAllPairs.sumDigitDifferences(new int[]{10, 10, 10, 10}));
    }

    public long sumDigitDifferences(int[] nums) {
        long sum = 0;
        int limit = String.valueOf(nums[0]).length();

        for (int k = 1; k <= limit; k++) {
            long[] counter = new long[10];
            for (int i = 0; i < nums.length; i++) {
                counter[nums[i] % 10]++;
                nums[i] /= 10;
            }
            Arrays.sort(counter);

            int i = 0;
            while (counter[i] == 0) i++;

            for (; i < 10; i++) for (int j = i + 1; j < 10; j++) sum += counter[i] * counter[j];
        }

        return sum;
    }
}
