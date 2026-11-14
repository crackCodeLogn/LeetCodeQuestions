package leetcode.practise;

import java.util.List;

public class Q3364_E_MinimumPositiveSumSubarray {

  public int minimumSumSubarray(List<Integer> nums, int l, int r) { // 4ms, beats 75.51%
    int minSum = Integer.MAX_VALUE;
    for (int window = l; window <= r; window++) {
      int sum = nums.get(0), i;
      for (i = 1; i < window; i++) sum += nums.get(i);
      if (sum > 0 && sum < minSum) minSum = sum;
      for (; i < nums.size(); i++) {
        sum += nums.get(i);
        sum -= nums.get(i - window);
        if (sum > 0 && sum < minSum) minSum = sum;
      }
    }
    return minSum == Integer.MAX_VALUE ? -1 : minSum;
  }

  public static void main(String[] args) {
    Q3364_E_MinimumPositiveSumSubarray q3364EMinimumPositiveSumSubarray =
        new Q3364_E_MinimumPositiveSumSubarray();
    System.out.println(
        q3364EMinimumPositiveSumSubarray.minimumSumSubarray(List.of(3, -2, 1, 4), 2, 3));
    System.out.println(
        q3364EMinimumPositiveSumSubarray.minimumSumSubarray(List.of(-2, 2, -3, 1), 2, 3));
    System.out.println(
        q3364EMinimumPositiveSumSubarray.minimumSumSubarray(List.of(1, 2, 3, 4), 2, 4));
  }
}
