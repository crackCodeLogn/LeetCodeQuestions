package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-12-13
 */
public class Q1464_E_MaximumProductOfTwoElementsInArray {
    public int maxProduct(int[] nums) {
        int max = -1, max2 = -1, maxi = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++)
            if (nums[i] > max) {
                max = nums[i];
                maxi = i;
            }
        for (int i = 0; i < n; i++) if (nums[i] > max2 && i != maxi) max2 = nums[i];
        return (max - 1) * (max2 - 1);
    }
}
