package leetcode.practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Q1262_M_GreatestSumDivisibleByThree {

  public static void main(String[] args) {
    Q1262_M_GreatestSumDivisibleByThree q1262MGreatestSumDivisibleByThree =
        new Q1262_M_GreatestSumDivisibleByThree();
    System.out.println(q1262MGreatestSumDivisibleByThree.maxSumDivThree(new int[] {1, 1, 5, 4, 7}));
    System.out.println(q1262MGreatestSumDivisibleByThree.maxSumDivThree(new int[] {2, 6, 2, 2, 7}));
    System.out.println(q1262MGreatestSumDivisibleByThree.maxSumDivThree(new int[] {1, 2, 3, 4, 4}));
    System.out.println(q1262MGreatestSumDivisibleByThree.maxSumDivThree(new int[] {3, 6, 5, 1, 8}));
    System.out.println(q1262MGreatestSumDivisibleByThree.maxSumDivThree(new int[] {4}));
  }

  public int maxSumDivThree(int[] nums) {
    int[] dp = new int[3]; // dp[i] := the maximum sum so far s.t. sum % 3 == i

    for (final int num : nums)
      for (final int sum : dp.clone())
        dp[(sum + num) % 3] = Math.max(dp[(sum + num) % 3], sum + num);

    return dp[0];
  }

  public int maxSumDivThree2(int[] nums) { // doesn't work for tc 41 /43
    PriorityQueue<Integer> pq0 = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

    for (int num : nums)
      switch (num % 3) {
        case 0:
          pq0.offer(num);
          break;
        case 1:
          pq1.offer(num);
          break;
        case 2:
          pq2.offer(num);
          break;
      }

    int sum = 0;
    while (!pq0.isEmpty()) sum += pq0.poll();
    List<Integer> tmp1 = new ArrayList<>(3);
    List<Integer> tmp2 = new ArrayList<>(3);
    while (!pq1.isEmpty() && !pq2.isEmpty()) {
      tmp1.clear();
      tmp2.clear();
      int s1 = -1, s2 = -1, s3 = -1;
      if (!pq1.isEmpty() && !pq2.isEmpty()) {
        s1 = pq1.peek() + pq2.peek();
      }
      if (pq1.size() >= 3) {
        tmp1.add(pq1.poll());
        tmp1.add(pq1.poll());
        tmp1.add(pq1.poll());
        s2 = tmp1.get(0) + tmp1.get(1) + tmp1.get(2);
      }
      if (pq2.size() >= 3) {
        tmp2.add(pq2.poll());
        tmp2.add(pq2.poll());
        tmp2.add(pq2.poll());
        s3 = tmp2.get(0) + tmp2.get(1) + tmp2.get(2);
      }
      if (s1 == s2 && s3 == s1 && s1 == -1) break;
      if (s1 >= s2 && s1 >= s3) {
        sum += s1;
        pq1.addAll(tmp1);
        pq2.addAll(tmp2);
        pq1.poll();
        pq2.poll();
        /*if (!tmp1.isEmpty()) {
          pq1.add(tmp1.get(1));
          pq1.add(tmp1.get(2));
        }
        if (!tmp2.isEmpty()) {
          pq2.add(tmp2.get(1));
          pq2.add(tmp2.get(2));
        }*/
      } else if (s2 >= s1 && s2 >= s3) {
        pq2.addAll(tmp2);
        sum += s2;
      } else if (s3 >= s1 && s3 >= s2) {
        pq1.addAll(tmp1);
        sum += s3;
      }
    }
    while (!pq2.isEmpty() && pq2.size() >= 3) sum += pq2.poll() + pq2.poll() + pq2.poll();
    while (!pq1.isEmpty() && pq1.size() >= 3) sum += pq1.poll() + pq1.poll() + pq1.poll();
    while (!pq1.isEmpty() && !pq2.isEmpty()) sum += pq1.poll() + pq2.poll();
    return sum;
  }
}
