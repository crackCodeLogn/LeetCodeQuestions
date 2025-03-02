package leetcode.practise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2025-03-01
 */
public class Q2570_E_MergeTwo2dArraysBySummingValues {
  public static void main(String[] args) {
    Q2570_E_MergeTwo2dArraysBySummingValues q2570EMergeTwo2dArraysBySummingValues =
        new Q2570_E_MergeTwo2dArraysBySummingValues();
    System.out.println(
        Arrays.deepToString(
            q2570EMergeTwo2dArraysBySummingValues.mergeArrays(
                new int[][] {
                  {1, 2},
                  {2, 3},
                  {4, 5},
                },
                new int[][] {
                  {1, 4},
                  {3, 2},
                  {4, 1},
                })));
    System.out.println(
        Arrays.deepToString(
            q2570EMergeTwo2dArraysBySummingValues.mergeArrays(
                new int[][] {
                  {2, 4},
                  {3, 6},
                  {5, 5},
                },
                new int[][] {
                  {1, 3},
                  {4, 3},
                })));
  }

  public int[][] mergeArrays(int[][] nums1, int[][] nums2) { // 1ms, beats 86.98%
    Queue<int[]> pairs = new LinkedList<>();
    int p1 = 0, p2 = 0;

    while (p1 < nums1.length && p2 < nums2.length) {
      if (nums1[p1][0] == nums2[p2][0]) {
        pairs.offer(new int[] {nums1[p1][0], nums1[p1][1] + nums2[p2][1]});
        p1++;
        p2++;
      } else if (nums1[p1][0] < nums2[p2][0]) {
        pairs.offer(new int[] {nums1[p1][0], nums1[p1][1]});
        p1++;
      } else {
        pairs.offer(new int[] {nums2[p2][0], nums2[p2][1]});
        p2++;
      }
    }
    while (p1 < nums1.length) {
      pairs.offer(new int[] {nums1[p1][0], nums1[p1][1]});
      p1++;
    }
    while (p2 < nums2.length) {
      pairs.offer(new int[] {nums2[p2][0], nums2[p2][1]});
      p2++;
    }

    int[][] data = new int[pairs.size()][2];
    int i = 0;
    while (!pairs.isEmpty()) data[i++] = pairs.poll();
    return data;
  }
}
