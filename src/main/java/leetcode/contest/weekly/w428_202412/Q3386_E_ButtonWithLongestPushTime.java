package leetcode.contest.weekly.w428_202412;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Vivek
 * @since 2024-12-14
 */
public class Q3386_E_ButtonWithLongestPushTime {

  public static void main(String[] args) {
    Q3386_E_ButtonWithLongestPushTime q3386EButtonWithLongestPushTime =
        new Q3386_E_ButtonWithLongestPushTime();
    System.out.println(
        q3386EButtonWithLongestPushTime.buttonWithLongestTime(
            new int[][] {
              {1, 2},
              {2, 5},
              {3, 9},
              {1, 15},
            }));
    System.out.println(
        q3386EButtonWithLongestPushTime.buttonWithLongestTime(
            new int[][] {
              {10, 5},
              {1, 7},
            }));
  }

  public int buttonWithLongestTime(int[][] events) {
    Map<Integer, Integer> map = new TreeMap<>();
    int minIndex = events[0][0];
    int longestTime = events[0][1];
    map.put(longestTime, minIndex);

    for (int i = 1; i < events.length; i++) {
      int[] event = events[i];
      int index = event[0];
      int delta = event[1] - events[i - 1][1];
      if (delta > longestTime) {
        longestTime = delta;
        if (!map.containsKey(longestTime) || (index < map.get(longestTime))) {
          map.put(longestTime, index);
          minIndex = index;
        }
      } else if (delta == longestTime) {
        if (index < map.get(delta)) {
          minIndex = index;
          map.put(delta, index);
        }
      }
    }
    return minIndex;
  }
}
