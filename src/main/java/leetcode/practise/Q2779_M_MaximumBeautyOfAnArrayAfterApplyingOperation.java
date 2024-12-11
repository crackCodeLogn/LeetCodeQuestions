package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-12-10
 */
public class Q2779_M_MaximumBeautyOfAnArrayAfterApplyingOperation {

  public static void main(String[] args) {
    Q2779_M_MaximumBeautyOfAnArrayAfterApplyingOperation
        q2779MMaximumBeautyOfAnArrayAfterApplyingOperation =
            new Q2779_M_MaximumBeautyOfAnArrayAfterApplyingOperation();
    System.out.println(
        q2779MMaximumBeautyOfAnArrayAfterApplyingOperation.maximumBeauty(
            new int[] {4, 6, 1, 2}, 2));
    System.out.println(
        q2779MMaximumBeautyOfAnArrayAfterApplyingOperation.maximumBeauty(
            new int[] {1, 1, 1, 1}, 10));
  }

  public int maximumBeauty(int[] nums, int k) {
    int result = 0;
    Arrays.sort(nums);

    for (int l = 0, r = 0; r < nums.length; r++) {
      while (nums[r] - nums[l] > 2 * k) l++;
      result = Math.max(result, r - l + 1);
    }

    return result;
  }
}
