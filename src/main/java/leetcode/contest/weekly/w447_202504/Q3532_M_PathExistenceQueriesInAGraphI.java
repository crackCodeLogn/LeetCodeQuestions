package leetcode.contest.weekly.w447_202504;

import java.util.*;

/**
 * @author Vivek
 * @since 2025-04-26
 */
public class Q3532_M_PathExistenceQueriesInAGraphI {

  public static void main(String[] args) {
    Q3532_M_PathExistenceQueriesInAGraphI q3532MPathExistenceQueriesInAGraphI =
        new Q3532_M_PathExistenceQueriesInAGraphI();
    System.out.println(
        Arrays.toString(
            q3532MPathExistenceQueriesInAGraphI.pathExistenceQueries(
                15,
                new int[] {1, 2, 2, 2, 2, 2, 2, 2, 5, 6, 8, 8, 8, 9, 12},
                2,
                new int[][] {
                  {0, 0},
                  {0, 14},
                  {6, 14},
                  {12, 14},
                  {8, 10},
                })));
    System.out.println(
        Arrays.toString(
            q3532MPathExistenceQueriesInAGraphI.pathExistenceQueries(
                2,
                new int[] {1, 3},
                1,
                new int[][] {
                  {0, 0},
                  {0, 1},
                })));
    System.out.println(
        Arrays.toString(
            q3532MPathExistenceQueriesInAGraphI.pathExistenceQueries(
                4,
                new int[] {2, 5, 6, 8},
                2,
                new int[][] {
                  {0, 1},
                  {0, 2},
                  {1, 3},
                  {2, 3},
                })));
  }

  public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
    Set<Integer> set = new HashSet<>();
    List<Integer> values = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      if (!set.contains(nums[i])) {
        set.add(nums[i]);
        values.add(nums[i]);
      }
    }
    Map<Integer, Integer> valColorMap = new HashMap<>();
    int color = 0;
    int prev = values.get(0);
    valColorMap.put(prev, color);
    for (int i = 1; i < values.size(); i++) {
      if (abs(values.get(i), prev, maxDiff)) {
        valColorMap.put(values.get(i), color);
      } else {
        valColorMap.put(values.get(i), ++color);
      }
      prev = values.get(i);
    }
    int[] data = new int[n];
    for (int i = 0; i < n; i++) data[i] = valColorMap.get(nums[i]);
    boolean[] result = new boolean[queries.length];
    for (int i = 0; i < queries.length; i++) result[i] = data[queries[i][0]] == data[queries[i][1]];
    return result;
  }

  public boolean[] pathExistenceQueries2(int n, int[] nums, int maxDiff, int[][] queries) {
    TreeMap<Integer, Integer> startPointMap = new TreeMap<>();
    List<Integer> values = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      if (!startPointMap.containsKey(nums[i])) {
        startPointMap.put(nums[i], i);
        values.add(nums[i]);
      }
    }
    Map<Integer, Integer> valColorMap = new HashMap<>();
    int color = 0;
    int prev = values.get(0);
    valColorMap.put(prev, color);
    for (int i = 1; i < values.size(); i++) {
      if (abs(values.get(i), prev, maxDiff)) {
        valColorMap.put(values.get(i), color);
      } else {
        valColorMap.put(values.get(i), ++color);
      }
      prev = values.get(i);
    }
    int[] data = new int[n];
    for (int i = 0; i < n; i++) data[i] = valColorMap.get(nums[i]);
    boolean[] result = new boolean[queries.length];
    for (int i = 0; i < queries.length; i++) result[i] = data[queries[i][0]] == data[queries[i][1]];
    return result;
  }

  private boolean abs(int a, int b, int diff) {
    return Math.abs(a - b) <= diff;
  }
}
