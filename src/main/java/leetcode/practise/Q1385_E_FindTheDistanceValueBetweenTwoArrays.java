package leetcode.practise;

import java.util.TreeMap;

public class Q1385_E_FindTheDistanceValueBetweenTwoArrays {

  public int findTheDistanceValue(int[] arr1, int[] arr2, int d) { // 10ms, beats 16.66%
    TreeMap<Integer, Integer> data = new TreeMap<>();
    for (int num : arr2) data.compute(num, (k, v) -> v == null ? 1 : v + 1);
    int cnt = 0;
    for (int num : arr1) {
      Integer floor = data.floorKey(num), ceil = data.ceilingKey(num);
      if (floor != null && ceil != null) {
        if (Math.abs(num - floor) > d && Math.abs(num - ceil) > d) cnt++;
      } else if (floor == null) {
        if (Math.abs(num - ceil) > d) cnt++;
      } else {
        if (Math.abs(num - floor) > d) cnt++;
      }
    }
    return cnt;
  }

  public static void main(String[] args) {
    Q1385_E_FindTheDistanceValueBetweenTwoArrays q1385EFindTheDistanceValueBetweenTwoArrays =
        new Q1385_E_FindTheDistanceValueBetweenTwoArrays();
    System.out.println(
        q1385EFindTheDistanceValueBetweenTwoArrays.findTheDistanceValue(
            new int[] {4, 5, 8}, new int[] {10, 9, 1, 8, 9}, 2));
    System.out.println(
        q1385EFindTheDistanceValueBetweenTwoArrays.findTheDistanceValue(
            new int[] {4, 5, 8}, new int[] {10, 9, 1, 8}, 2));
    System.out.println(
        q1385EFindTheDistanceValueBetweenTwoArrays.findTheDistanceValue(
            new int[] {1, 4, 2, 3}, new int[] {-4, -3, 6, 10, 20, 30}, 3));
    System.out.println(
        q1385EFindTheDistanceValueBetweenTwoArrays.findTheDistanceValue(
            new int[] {2, 1, 100, 3}, new int[] {-5, -2, 10, -3, 7}, 6));
  }
}
