package leetcode.contest.weekly.w424_202411;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-11-16
 */
public class Q3354_E_MakeArrayElementsEqualToZero {
  public static void main(String[] args) {
    Q3354_E_MakeArrayElementsEqualToZero q3354EMakeArrayElementsEqualToZero =
        new Q3354_E_MakeArrayElementsEqualToZero();
    System.out.println(
        q3354EMakeArrayElementsEqualToZero.countValidSelections(new int[] {1, 0, 2, 0, 3}));
    System.out.println(
        q3354EMakeArrayElementsEqualToZero.countValidSelections(new int[] {2, 3, 4, 0, 4, 1, 0}));
  }

  public int countValidSelections(int[] nums) {
    int n = nums.length;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (nums[i] == 0) {
        int[] copy = Arrays.copyOf(nums, n);
        if (compute(copy, i, true)) cnt++;
        copy = Arrays.copyOf(nums, n);
        if (compute(copy, i, false)) cnt++;
      }
    }
    return cnt;
  }

  private boolean compute(int[] nums, int start, boolean flag) {
    int i = start, n = nums.length;
    while (i >= 0 && i < n) {
      if (nums[i] == 0) i += direction(flag);
      else if (nums[i] > 0) {
        nums[i]--;
        flag = !flag;
        i += direction(flag);
      }
    }
    for (i = 0; i < n; i++) if (nums[i] != 0) return false;
    return true;
  }

  private int direction(boolean flag) {
    return flag ? 1 : -1;
  }
}
