package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2026-07-25
 */
public class Q0628_E_MaximumProductOfThreeNumbers {
  public int maximumProduct(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    int max = nums[n - 1] * nums[n - 2] * nums[n - 3];
    return Math.max(max, nums[0] * nums[1] * nums[n - 1]);
  }

  public static void main(String[] args) {
    Q0628_E_MaximumProductOfThreeNumbers q0628EMaximumProductOfThreeNumbers =
        new Q0628_E_MaximumProductOfThreeNumbers();
    System.out.println(q0628EMaximumProductOfThreeNumbers.maximumProduct(new int[] {1, 2, 3}));
    System.out.println(q0628EMaximumProductOfThreeNumbers.maximumProduct(new int[] {1, 2, 3, 4}));
    System.out.println(q0628EMaximumProductOfThreeNumbers.maximumProduct(new int[] {-1, -2, -3}));
  }
}
