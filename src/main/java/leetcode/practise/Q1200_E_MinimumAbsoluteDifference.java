package leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vivek
 * @since 2026-01-25
 */
public class Q1200_E_MinimumAbsoluteDifference {
  public static void main(String[] args) {
    Q1200_E_MinimumAbsoluteDifference q1200EMinimumAbsoluteDifference =
        new Q1200_E_MinimumAbsoluteDifference();
    System.out.println(
        q1200EMinimumAbsoluteDifference.minimumAbsDifference(new int[] {4, 2, 1, 3}));
    System.out.println(
        q1200EMinimumAbsoluteDifference.minimumAbsDifference(new int[] {1, 3, 6, 10, 15}));
    System.out.println(
        q1200EMinimumAbsoluteDifference.minimumAbsDifference(
            new int[] {3, 8, -10, 23, 19, -4, -14, 27}));
  }

  public List<List<Integer>> minimumAbsDifference(int[] arr) { // 23ms, beats 17.74%
    Arrays.sort(arr);
    int minDiff = Integer.MAX_VALUE;
    List<List<Integer>> res = new ArrayList<>();

    for (int i = 1; i < arr.length; i++) {
      int delta = Math.abs(arr[i] - arr[i - 1]);
      if (delta <= minDiff) {
        if (delta < minDiff) res.clear();
        List<Integer> list = new ArrayList<>();
        list.add(arr[i - 1]);
        list.add(arr[i]);
        res.add(list);
        minDiff = delta;
      }
    }

    return res;
  }
}
