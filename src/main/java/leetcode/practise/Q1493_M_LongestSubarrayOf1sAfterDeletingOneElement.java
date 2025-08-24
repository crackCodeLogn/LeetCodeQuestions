package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 8/23/25
 */
public class Q1493_M_LongestSubarrayOf1sAfterDeletingOneElement {
  public static void main(String[] args) {
    Q1493_M_LongestSubarrayOf1sAfterDeletingOneElement
        q1493MLongestSubarrayOf1sAfterDeletingOneElement =
            new Q1493_M_LongestSubarrayOf1sAfterDeletingOneElement();
    System.out.println(
        q1493MLongestSubarrayOf1sAfterDeletingOneElement.longestSubarray(
            new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1}));

    System.out.println(
        q1493MLongestSubarrayOf1sAfterDeletingOneElement.longestSubarray(new int[] {1, 0, 0}));
    System.out.println(
        q1493MLongestSubarrayOf1sAfterDeletingOneElement.longestSubarray(new int[] {0, 0, 0}));
    System.out.println(
        q1493MLongestSubarrayOf1sAfterDeletingOneElement.longestSubarray(new int[] {0, 1, 0}));
    System.out.println(
        q1493MLongestSubarrayOf1sAfterDeletingOneElement.longestSubarray(new int[] {0, 0, 1}));
    System.out.println(
        q1493MLongestSubarrayOf1sAfterDeletingOneElement.longestSubarray(new int[] {1, 1, 0, 1}));
    System.out.println(
        q1493MLongestSubarrayOf1sAfterDeletingOneElement.longestSubarray(
            new int[] {0, 1, 1, 1, 0, 1, 1, 0, 1}));
    System.out.println(
        q1493MLongestSubarrayOf1sAfterDeletingOneElement.longestSubarray(new int[] {1, 1, 1}));
  }

  public int longestSubarray(int[] nums) { // 3ms, beats 77.92%
    int c0 = 0, c1 = 0, n = nums.length, max = 0, counter = 0;
    List<Integer> data = new ArrayList<>(n);

    for (int i = 0; i < n; i++) {
      if (nums[i] == 0) {
        c0++;
        if (counter > 0) data.add(counter);
        max = Math.max(max, counter);
        counter = 0;
        data.add(0);
      } else {
        c1++;
        counter++;
      }
    }
    if (counter > 0) data.add(counter);
    max = Math.max(max, counter);
    if (c0 == 0) return counter - 1;
    if (c1 == 0) return 0;

    for (int i = 1; i < data.size() - 1; i++) {
      if (data.get(i) == 0 && data.get(i + 1) != 0 && data.get(i - 1) != 0) {
        max = Math.max(max, data.get(i - 1) + data.get(i + 1));
      }
    }

    return max;
  }
}
