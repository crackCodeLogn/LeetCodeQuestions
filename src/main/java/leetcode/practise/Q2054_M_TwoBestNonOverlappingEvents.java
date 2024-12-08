package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-12-07
 */
public class Q2054_M_TwoBestNonOverlappingEvents {
  public static void main(String[] args) {
    Q2054_M_TwoBestNonOverlappingEvents q2054MTwoBestNonOverlappingEvents =
        new Q2054_M_TwoBestNonOverlappingEvents();
    System.out.println(
        q2054MTwoBestNonOverlappingEvents.maxTwoEvents(
            new int[][] {
              {1, 3, 2},
              {4, 5, 2},
              {2, 4, 3}
            }));
    System.out.println(
        q2054MTwoBestNonOverlappingEvents.maxTwoEvents(
            new int[][] {
              {1, 3, 2},
              {4, 5, 2},
              {1, 5, 5}
            }));
    System.out.println(
        q2054MTwoBestNonOverlappingEvents.maxTwoEvents(
            new int[][] {
              {1, 5, 3},
              {1, 5, 1},
              {6, 6, 5}
            }));
  }

  public int maxTwoEvents(int[][] events) {
    int result = 0;
    int maxValue = 0;
    Event[] events1 = new Event[events.length * 2];

    for (int i = 0; i < events.length; ++i) {
      final int start = events[i][0];
      final int end = events[i][1];
      final int value = events[i][2];
      events1[i * 2] = new Event(start, value, 1);
      events1[i * 2 + 1] = new Event(end + 1, value, 0);
    }

    Arrays.sort(
        events1,
        (a, b) ->
            a.time == b.time
                ? Integer.compare(a.isStart, b.isStart)
                : Integer.compare(a.time, b.time));

    for (Event evt : events1) {
      if (evt.isStart == 1) result = Math.max(result, evt.value + maxValue);
      else maxValue = Math.max(maxValue, evt.value);
    }

    return result;
  }

  private record Event(int time, int value, int isStart) {}
}
