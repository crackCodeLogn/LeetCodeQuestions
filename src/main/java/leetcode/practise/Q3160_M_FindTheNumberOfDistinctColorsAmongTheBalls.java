package leetcode.practise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Vivek
 * @since 2025-02-06
 */
public class Q3160_M_FindTheNumberOfDistinctColorsAmongTheBalls {

  public static void main(String[] args) {
    Q3160_M_FindTheNumberOfDistinctColorsAmongTheBalls
        q3160MFindTheNumberOfDistinctColorsAmongTheBalls =
            new Q3160_M_FindTheNumberOfDistinctColorsAmongTheBalls();
    System.out.println(
        Arrays.toString(
            q3160MFindTheNumberOfDistinctColorsAmongTheBalls.queryResults(
                4,
                new int[][] {
                  {1, 4},
                  {2, 5},
                  {1, 3},
                  {3, 4},
                })));
    System.out.println(
        Arrays.toString(
            q3160MFindTheNumberOfDistinctColorsAmongTheBalls.queryResults(
                4,
                new int[][] {
                  {0, 1},
                  {1, 2},
                  {2, 2},
                  {3, 4},
                  {4, 5},
                })));
  }

  public int[] queryResults(int limit, int[][] queries) { // 54ms, beats 10.04%
    int[] result = new int[queries.length];
    Map<Integer, Integer> ballColor = new HashMap<>();
    Map<Integer, Set<Integer>> colorBallSet = new HashMap<>();
    int res = 0;
    for (int[] query : queries) {
      int ball = query[0], color = query[1];
      if (ballColor.containsKey(ball)) {
        int preColor = ballColor.put(ball, color);
        if (preColor != color) {
          Set<Integer> set = colorBallSet.get(preColor);
          if (set != null && set.contains(ball)) {
            set.remove(ball);
            if (set.isEmpty()) colorBallSet.remove(preColor);
          }
        }

      } else {
        ballColor.put(ball, color);
      }
      colorBallSet.compute(color, (k, v) -> v == null ? new HashSet<>() : v).add(ball);
      result[res++] = colorBallSet.size();
    }
    return result;
  }
}
