package leetcode.practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Vivek
 * @since 7/6/25
 */
public class Q1353_M_MaximumNumberOfEventsThatCanBeAttended {

  public static void main(String[] args) {
    Q1353_M_MaximumNumberOfEventsThatCanBeAttended q1353MMaximumNumberOfEventsThatCanBeAttended =
        new Q1353_M_MaximumNumberOfEventsThatCanBeAttended();
    System.out.println(
        q1353MMaximumNumberOfEventsThatCanBeAttended.maxEvents(
            new int[][] {{1, 2}, {1, 2}, {3, 3}, {1, 5}, {1, 5}}));
    System.out.println(
        q1353MMaximumNumberOfEventsThatCanBeAttended.maxEvents(
            new int[][] {{1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}}));
    System.out.println(
        q1353MMaximumNumberOfEventsThatCanBeAttended.maxEvents(
            new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 2}, {2, 3}}));
    System.out.println(
        q1353MMaximumNumberOfEventsThatCanBeAttended.maxEvents(
            new int[][] {{1, 2}, {2, 3}, {3, 4}}));
    System.out.println(
        q1353MMaximumNumberOfEventsThatCanBeAttended.maxEvents(
            new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 2}}));
  }

  /*public int maxEvents(int[][] events) { // failed line of reasoning for psvm's tc 1
    PriorityQueue<Node> queue = new PriorityQueue<>();
    for (int[] event : events) queue.add(new Node(event[0], event[1]));

    int tracker = 1, cnt = 0;
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      int v = Math.max(node.start, tracker);
      if (v <= node.end) {
        cnt++;
        tracker = v + 1;
      }
    }
    return cnt;
  } */

  public int maxEvents(int[][] events) { // 67ms, beats 49.53%
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int tracker = 1, cnt = 0, i = 0;
    List<Node> nodes = new ArrayList<>();
    for (int[] event : events) nodes.add(new Node(event[0], event[1]));
    Collections.sort(nodes);

    while (!pq.isEmpty() || i < nodes.size()) {
      if (pq.isEmpty()) tracker = nodes.get(i).start;
      while (i < nodes.size() && nodes.get(i).start == tracker) {
        pq.offer(nodes.get(i).end);
        i++;
      }
      pq.poll(); // attend the earliest available event
      cnt++;
      tracker++;
      // discard events which cannot be attended
      while (!pq.isEmpty() && pq.peek() < tracker) {
        pq.poll();
      }
    }
    return cnt;
  }

  private record Node(int start, int end) implements Comparable<Node> {
    @Override
    public int compareTo(Node o) {
      if (start == o.start) return end - o.end;
      return start - o.start;
    }
  }
}
