package leetcode.practise;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-10-12
 */
public class Q2406_M_DivideIntervalsIntoMinimumNumberOfGroups {

  public static void main(String[] args) {
    Q2406_M_DivideIntervalsIntoMinimumNumberOfGroups
        q2406MDivideIntervalsIntoMinimumNumberOfGroups =
            new Q2406_M_DivideIntervalsIntoMinimumNumberOfGroups();
    System.out.println(
        q2406MDivideIntervalsIntoMinimumNumberOfGroups.minGroups(
            new int[][] {
              {5, 10},
              {6, 8},
              {1, 5},
              {2, 3},
              {1, 10},
            }));
    System.out.println(
        q2406MDivideIntervalsIntoMinimumNumberOfGroups.minGroups(
            new int[][] {
              {1, 3},
              {5, 6},
              {8, 10},
              {11, 13},
            }));
  }

  public int minGroups(int[][] intervals) {
    // Stores `right`s.
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

    for (int[] interval : intervals) {
      if (!minHeap.isEmpty() && interval[0] > minHeap.peek()) minHeap.poll();
      minHeap.offer(interval[1]);
    }

    return minHeap.size();
  }
}
