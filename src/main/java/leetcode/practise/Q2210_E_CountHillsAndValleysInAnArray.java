package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 7/26/25
 */
public class Q2210_E_CountHillsAndValleysInAnArray {

  public static void main(String[] args) {
    Q2210_E_CountHillsAndValleysInAnArray q2210ECountHillsAndValleysInAnArray =
        new Q2210_E_CountHillsAndValleysInAnArray();
    System.out.println(
        q2210ECountHillsAndValleysInAnArray.countHillValley(new int[] {2, 4, 1, 1, 6, 5}));
    System.out.println(
        q2210ECountHillsAndValleysInAnArray.countHillValley(new int[] {6, 6, 5, 5, 4, 1}));
  }

  public int countHillValley(int[] nums) { // 0ms, beats 100%
    int cnt = 0, n = nums.length, p1 = 0, p2, p3;
    p2 = slideToNext(nums, p1);
    p3 = slideToNext(nums, p2);
    while (p3 < n) {
      if (isOp(nums[p1], nums[p2], nums[p3])) cnt++;
      p1 = p2;
      p2 = p3;
      p3 = slideToNext(nums, p3);
    }
    return cnt;
  }

  private int slideToNext(int[] nums, int index) {
    int src = index;
    while (index < nums.length) {
      if (nums[index] != nums[src]) break;
      index++;
    }
    return index;
  }

  private boolean isOp(int v1, int v2, int v3) {
    return (v1 < v2 && v2 > v3) || (v1 > v2 && v2 < v3);
  }

  public int countHillValley2(int[] nums) { // 2ms, beats 12.30%
    int cnt = 0, n = nums.length;
    List<Integer> list = new ArrayList<>();
    int prev = nums[0];
    list.add(prev);
    for (int i = 1; i < n; i++) {
      if (nums[i] != prev) list.add(nums[i]);
      prev = nums[i];
    }
    for (int i = 1; i < list.size() - 1; i++) {
      if ((list.get(i - 1) < list.get(i) && list.get(i) > list.get(i + 1))
          || (list.get(i - 1) > list.get(i) && list.get(i) < list.get(i + 1))) cnt++;
    }
    return cnt;
  }
}
