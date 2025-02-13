package leetcode.practise;

import java.util.PriorityQueue;

/**
 * @author Vivek
 * @since 2025-02-12
 */
public class Q3066_M_MinimumOperationsToExceedThresholdValueII {
  public static void main(String[] args) {
    Q3066_M_MinimumOperationsToExceedThresholdValueII
        q3066MMinimumOperationsToExceedThresholdValueII =
            new Q3066_M_MinimumOperationsToExceedThresholdValueII();
    System.out.println(
        q3066MMinimumOperationsToExceedThresholdValueII.minOperations(
            new int[] {999999999, 999999999, 999999999}, 1000000000));
    System.out.println(
        q3066MMinimumOperationsToExceedThresholdValueII.minOperations(
            new int[] {2, 11, 10, 1, 3}, 10));
    System.out.println(
        q3066MMinimumOperationsToExceedThresholdValueII.minOperations(
            new int[] {1, 1, 2, 4, 9}, 20));
  }

  public int minOperations(int[] nums, int k) { // 131ms, beats 96.30%
    int moves = 0;
    PriorityQueue<Long> pq = new PriorityQueue<>();
    for (int i = 0; i < nums.length; i++) if (nums[i] < k) pq.offer((long) nums[i]);

    while (pq.size() >= 2) {
      moves++;
      long n1 = pq.poll(), n2 = pq.poll();
      long val = Math.min(n1, n2) * 2 + Math.max(n1, n2);
      if (val < k) pq.offer(val);
    }
    return moves + pq.size(); // pq.size() would only be either 1 or 0
  }
}
