package leetcode.practise;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2024-10-14
 */
public class Q2530_M_MaximalScoreAfterApplyingKOperations {

  public static void main(String[] args) {
    Q2530_M_MaximalScoreAfterApplyingKOperations q2530MMaximalScoreAfterApplyingKOperations =
        new Q2530_M_MaximalScoreAfterApplyingKOperations();
    System.out.println(
        q2530MMaximalScoreAfterApplyingKOperations.maxKelements(
            new int[] {10, 10, 10, 10, 10}, 5)); // 50
    System.out.println(
        q2530MMaximalScoreAfterApplyingKOperations.maxKelements(
            new int[] {1, 10, 3, 3, 3}, 3)); // 17
  }

  public long maxKelements(int[] nums, int k) {
    long ans = 0;
    Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    for (int num : nums) maxHeap.offer(num);

    for (int i = 0; i < k; ++i) {
      int num = maxHeap.poll();
      ans += num;
      maxHeap.offer((num + 2) / 3);
    }

    return ans;
  }
}
