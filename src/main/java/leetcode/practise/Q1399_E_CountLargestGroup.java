package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2025-04-22
 */
public class Q1399_E_CountLargestGroup {
  private static final int[] SUM = new int[10001];

  public static void main(String[] args) {
    Q1399_E_CountLargestGroup q1399ECountLargestGroup = new Q1399_E_CountLargestGroup();
    System.out.println(q1399ECountLargestGroup.countLargestGroup(13)); // 4
    System.out.println(q1399ECountLargestGroup.countLargestGroup(2)); // 2
  }

  public int countLargestGroup(int n) { // 3ms, beats 95.34%
    if (SUM[1] == 0) {
      for (int i = 1; i < SUM.length; i++) SUM[i] = sumOfDigits(i);
    }
    int[] groupCount = new int[40]; // cause max sum of largest num sum 9999 => 36
    int max = Integer.MIN_VALUE;
    for (int i = 1; i <= n; i++) {
      groupCount[SUM[i]]++;
      max = Math.max(max, groupCount[SUM[i]]);
    }
    int cnt = 0;
    for (int val : groupCount) if (val == max) cnt++;
    return cnt;
  }

  public int countLargestGroup2(int n) { // 10ms, beats 45.52%
    if (SUM[1] == 0) {
      for (int i = 1; i < SUM.length; i++) SUM[i] = sumOfDigits(i);
    }
    Map<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;
    for (int i = 1; i <= n; i++) {
      int sum = SUM[i];
      int val = map.compute(sum, (k, v) -> v == null ? 1 : v + 1);
      max = Math.max(max, val);
    }
    int cnt = 0;
    for (Integer val : map.values()) if (val == max) cnt++;
    return cnt;
  }

  private int sumOfDigits(int n) {
    int sum = 0;
    while (n > 0) {
      sum += n % 10;
      n /= 10;
    }
    return sum;
  }
}
