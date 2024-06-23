package leetcode.contest.weekly.w403_202406;

/**
 * @author Vivek
 * @since 2024-06-23
 */
public class Q3196_M_MaximizeTotalCostOfAlternatingSubarrays {

    public static void main(String[] args) {
        Q3196_M_MaximizeTotalCostOfAlternatingSubarrays q3196MMaximizeTotalCostOfAlternatingSubarrays = new Q3196_M_MaximizeTotalCostOfAlternatingSubarrays();
        System.out.println(q3196MMaximizeTotalCostOfAlternatingSubarrays.maximumTotalCost(new int[]{1, -2, 3, 4})); // 10
        System.out.println(q3196MMaximizeTotalCostOfAlternatingSubarrays.maximumTotalCost(new int[]{1, -1, 1, -1})); // 4
        System.out.println(q3196MMaximizeTotalCostOfAlternatingSubarrays.maximumTotalCost(new int[]{0})); // 0
        System.out.println(q3196MMaximizeTotalCostOfAlternatingSubarrays.maximumTotalCost(new int[]{1, -1})); // 2
        System.out.println(q3196MMaximizeTotalCostOfAlternatingSubarrays.maximumTotalCost(new int[]{-14, -13, -20})); // -7
        System.out.println(q3196MMaximizeTotalCostOfAlternatingSubarrays.maximumTotalCost(new int[]{4, -5, -3, -2, -4, 4})); // 12
    }

    public long maximumTotalCost(int[] nums) {
        long res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) res += nums[i];
            else {
                int j = i + 1;
                while (j < nums.length && nums[j] < 0) j++;
                res += process(nums, i, j - 1);
                i = j - 1;
            }
        }
        return res;
    }

    public long process(int[] nums, int lb, int ub) { //negatives only
        if (lb > ub) return 0;

        long v1 = -nums[lb] + (lb + 1 <= ub ? nums[lb + 1] : 0) + process(nums, lb + 2, ub);
        long v2 = nums[lb] + process(nums, lb + 1, ub);
        return Math.max(v1, v2);
    }
}
