package leetcode.practise;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Vivek
 * @since 2025-02-11
 */
public class Q2342_M_MaxSumOfAPairWithEqualSumOfDigits {

  // private static final Map<Integer, Long> sumOfDigits = new HashMap<>();
  // weird, that using this overhead map of storing sum of digits was running slower instead

  public static void main(String[] args) {
    Q2342_M_MaxSumOfAPairWithEqualSumOfDigits q2342MMaxSumOfAPairWithEqualSumOfDigits =
        new Q2342_M_MaxSumOfAPairWithEqualSumOfDigits();
    System.out.println(q2342MMaxSumOfAPairWithEqualSumOfDigits.maximumSum(new int[] {4, 6, 10, 6}));
    System.out.println(
        q2342MMaxSumOfAPairWithEqualSumOfDigits.maximumSum(new int[] {18, 43, 36, 13, 7}));
    System.out.println(
        q2342MMaxSumOfAPairWithEqualSumOfDigits.maximumSum(new int[] {10, 12, 19, 14}));
  }

  public int maximumSum(int[] nums) { // 55ms, beats 33.04%
    int data = -1;
    Map<Long, PriorityQueue<Integer>> map = new HashMap<>();
    for (int num : nums)
      map.compute(
              findDigitSum(num),
              (k, v) -> v == null ? new PriorityQueue<>(Comparator.reverseOrder()) : v)
          .add(num);

    for (PriorityQueue<Integer> pq : map.values()) {
      if (pq.size() >= 2) {
        data = Math.max(data, pq.poll() + pq.poll());
      }
    }
    return data;
  }

  private long findDigitSum(int num) {
    //    if (sumOfDigits.containsKey(num)) return sumOfDigits.get(num);
    long sum = 0;
    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }
    //    sumOfDigits.put(num, sum);
    return sum;
  }
}
