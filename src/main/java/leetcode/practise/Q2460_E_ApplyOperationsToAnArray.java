package leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vivek
 * @since 2025-02-28
 */
public class Q2460_E_ApplyOperationsToAnArray {
  public static void main(String[] args) {
    Q2460_E_ApplyOperationsToAnArray q2460EApplyOperationsToAnArray =
        new Q2460_E_ApplyOperationsToAnArray();
    System.out.println(
        Arrays.toString(
            q2460EApplyOperationsToAnArray.applyOperations(new int[] {1, 2, 2, 1, 1, 0})));
    System.out.println(
        Arrays.toString(q2460EApplyOperationsToAnArray.applyOperations(new int[] {0, 1})));
  }

  public int[] applyOperations(int[] nums) { // 2ms, beats 8.49%
    int n = nums.length;
    List<Integer> list = new ArrayList<>();
    int i;
    for (i = 0; i < n - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        nums[i] *= 2;
        nums[i + 1] = 0;
      }
      if (nums[i] != 0) list.add(nums[i]);
    }
    if (nums[i] != 0) list.add(nums[i]);
    Arrays.fill(nums, 0);
    for (i = 0; i < list.size(); i++) nums[i] = list.get(i);
    return nums;
  }
}
