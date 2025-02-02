package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2025-02-01
 */
public class Q1752_E_CheckIfArrayIsSortedAndRotated {

  public static void main(String[] args) {
    Q1752_E_CheckIfArrayIsSortedAndRotated q1752ECheckIfArrayIsSortedAndRotated =
        new Q1752_E_CheckIfArrayIsSortedAndRotated();
    System.out.println(q1752ECheckIfArrayIsSortedAndRotated.check(new int[] {7, 9, 1, 1, 1, 3}));
    System.out.println(q1752ECheckIfArrayIsSortedAndRotated.check(new int[] {1, 2, 3, 1}));
    System.out.println(q1752ECheckIfArrayIsSortedAndRotated.check(new int[] {6}));
    System.out.println(q1752ECheckIfArrayIsSortedAndRotated.check(new int[] {3, 4, 5, 1, 2}));
    System.out.println(q1752ECheckIfArrayIsSortedAndRotated.check(new int[] {2, 1, 3, 4}));
    System.out.println(q1752ECheckIfArrayIsSortedAndRotated.check(new int[] {1, 2, 3}));
    System.out.println(q1752ECheckIfArrayIsSortedAndRotated.check(new int[] {1, 2, 3, 3, 4}));
    System.out.println(q1752ECheckIfArrayIsSortedAndRotated.check(new int[] {1, 2, 3, 3, 4, 10}));
  }

  public boolean check(int[] nums) { // 0ms, beats 100%
    int n = nums.length;
    if (n == 0) return true;

    int last = n - 1;
    while (last >= 0) {
      if (nums[last] != nums[0]) break;
      last--;
    }
    if (last < 0) return true;
    n = last + 1;
    int minPos = 0, minV = nums[0];
    for (int i = 1; i < n; i++)
      if (nums[i] < minV) {
        minV = nums[i];
        minPos = i;
      }
    int val = minV;
    for (int j = (minPos + 1) % n; j != minPos; j = (j + 1) % n) {
      if (nums[j] < val) return false;
      val = nums[j];
    }
    return true;
  }

  public boolean check2(int[] nums) { // 1ms, beats 5.83%
    int n = nums.length;
    if (n == 0) return true;

    List<Integer> data = new ArrayList<>(n);
    int last = -1;
    for (int i = 0; i < n; i++) {
      if (nums[i] != last) data.add(nums[i]);
      last = nums[i];
    }
    n = data.size();
    if (data.get(0) == data.get(n - 1)) data.remove(n - 1);
    if (data.isEmpty()) return true;
    n = data.size();

    int minPos = 0, minV = data.get(0);
    for (int i = 1; i < n; i++)
      if (data.get(i) < minV) {
        minV = data.get(i);
        minPos = i;
      }
    int i = minPos;
    int val = minV;
    for (int j = (i + 1) % n; j != i; j = (j + 1) % n) {
      if (data.get(j) < val) return false;
      val = data.get(j);
    }
    return true;
  }
}
