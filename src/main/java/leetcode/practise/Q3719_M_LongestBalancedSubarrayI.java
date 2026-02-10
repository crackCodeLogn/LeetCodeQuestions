package leetcode.practise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vivek
 * @since 2026-02-09
 */
public class Q3719_M_LongestBalancedSubarrayI {

  public static void main(String[] args) {
    Q3719_M_LongestBalancedSubarrayI q3719MLongestBalancedSubarrayI =
        new Q3719_M_LongestBalancedSubarrayI();
    System.out.println(q3719MLongestBalancedSubarrayI.longestBalanced(new int[] {2, 5, 4, 3}));
    System.out.println(q3719MLongestBalancedSubarrayI.longestBalanced(new int[] {3, 2, 2, 5, 4}));
    System.out.println(q3719MLongestBalancedSubarrayI.longestBalanced(new int[] {1, 2, 3, 2}));
  }

  public int longestBalanced(int[] nums) { // 318ms, beats 59.67%
    int maxLength = 0;
    for (int i = 0; i < nums.length; i++) {
      Set<Integer> set = new HashSet<>();
      int evens = 0, odds = 0;
      for (int j = i; j < nums.length; j++) {
        if (set.add(nums[j])) {
          if ((nums[j] & 1) == 1) odds++;
          else evens++;
        }

        if (evens == odds) maxLength = Math.max(maxLength, j - i + 1);
      }
    }
    return maxLength;
  }
}
