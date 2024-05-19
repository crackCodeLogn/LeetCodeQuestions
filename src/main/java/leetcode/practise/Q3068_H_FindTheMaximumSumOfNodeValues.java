package leetcode.practise;

public class Q3068_H_FindTheMaximumSumOfNodeValues {

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long maxSum = 0;
        int changedCount = 0;
        int minChangeDiff = Integer.MAX_VALUE;

        for (int num : nums) {
            maxSum += Math.max(num, num ^ k);
            changedCount += ((num ^ k) > num) ? 1 : 0;
            minChangeDiff = Math.min(minChangeDiff, Math.abs(num - (num ^ k)));
        }

        return changedCount % 2 == 0 ? maxSum : maxSum - minChangeDiff;
    }
}
