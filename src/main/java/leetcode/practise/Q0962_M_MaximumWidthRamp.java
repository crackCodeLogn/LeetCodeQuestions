package leetcode.practise;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Vivek
 * @since 2024-10-09
 */
public class Q0962_M_MaximumWidthRamp {

  public static void main(String[] args) {
    Q0962_M_MaximumWidthRamp q0962MMaximumWidthRamp = new Q0962_M_MaximumWidthRamp();
    System.out.println(q0962MMaximumWidthRamp.maxWidthRamp(new int[] {6, 0, 8, 2, 1, 5})); // 4
    System.out.println(
        q0962MMaximumWidthRamp.maxWidthRamp(new int[] {9, 8, 1, 0, 1, 9, 4, 0, 4, 1})); // 7
  }

  public int maxWidthRamp(int[] nums) {
    int ans = 0;
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < nums.length; ++i)
      if (stack.isEmpty() || nums[i] < nums[stack.peek()]) stack.push(i);

    for (int i = nums.length - 1; i > ans; --i)
      while (!stack.isEmpty() && nums[i] >= nums[stack.peek()])
        ans = Math.max(ans, i - stack.pop());

    return ans;
  }
}
