package leetcode.practise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vivek
 * @since 2025-04-08
 */
public class Q3375_E_MinimumOperationsToMakeArrayValuesEqualToK {
  public static void main(String[] args) {
    Q3375_E_MinimumOperationsToMakeArrayValuesEqualToK
        q3375EMinimumOperationsToMakeArrayValuesEqualToK =
            new Q3375_E_MinimumOperationsToMakeArrayValuesEqualToK();
    System.out.println(
        q3375EMinimumOperationsToMakeArrayValuesEqualToK.minOperations(
            new int[] {5, 2, 5, 4, 5}, 2));
    System.out.println(
        q3375EMinimumOperationsToMakeArrayValuesEqualToK.minOperations(new int[] {2, 1, 2}, 2));
    System.out.println(
        q3375EMinimumOperationsToMakeArrayValuesEqualToK.minOperations(new int[] {9, 7, 5, 3}, 1));
  }

  public int minOperations(int[] nums, int k) {
    for (int num : nums) if (num < k) return -1;
    Set<Integer> set = new HashSet<>();
    for (int num : nums) if (num > k) set.add(num);
    return set.size();
  }
}
