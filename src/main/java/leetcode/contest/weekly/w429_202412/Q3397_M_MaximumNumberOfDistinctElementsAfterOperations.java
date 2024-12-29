package leetcode.contest.weekly.w429_202412;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-12-21
 */
public class Q3397_M_MaximumNumberOfDistinctElementsAfterOperations {

  public static void main(String[] args) {
    Q3397_M_MaximumNumberOfDistinctElementsAfterOperations
        q3397MMaximumNumberOfDistinctElementsAfterOperations =
            new Q3397_M_MaximumNumberOfDistinctElementsAfterOperations();
    System.out.println(
        q3397MMaximumNumberOfDistinctElementsAfterOperations.maxDistinctElements(
            new int[] {1, 2, 2, 3, 3, 4}, 2));
    System.out.println(
        q3397MMaximumNumberOfDistinctElementsAfterOperations.maxDistinctElements(
            new int[] {4, 4, 4, 4}, 1));
    System.out.println(
        q3397MMaximumNumberOfDistinctElementsAfterOperations.maxDistinctElements(
            new int[] {1, 2, 2, 2, 2, 3, 3, 4}, 2));
  }

  public int maxDistinctElements(int[] nums, int k) {
    Arrays.sort(nums);
    Set<Integer> set = new HashSet<>();
    int next = Integer.MIN_VALUE;

    for (int num : nums) {
      int start = Math.max(num - k, next);
      if (start <= num + k) {
        set.add(start);
        next = start + 1;
      }
    }

    return set.size();
  }

  public int maxDistinctElements2(int[] nums, int k) { // tle
    Arrays.sort(nums);
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      for (int i = num - k; i <= num + k; i++) {
        if (!set.contains(i)) {
          set.add(i);
          break;
        }
      }
    }

    return set.size();
  }
}
