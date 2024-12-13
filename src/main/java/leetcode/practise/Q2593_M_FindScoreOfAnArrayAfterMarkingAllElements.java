package leetcode.practise;

import java.util.PriorityQueue;

/**
 * @author Vivek
 * @since 2024-12-12
 */
public class Q2593_M_FindScoreOfAnArrayAfterMarkingAllElements {
  public static void main(String[] args) {
    Q2593_M_FindScoreOfAnArrayAfterMarkingAllElements
        q2593MFindScoreOfAnArrayAfterMarkingAllElements =
            new Q2593_M_FindScoreOfAnArrayAfterMarkingAllElements();
    System.out.println(
        q2593MFindScoreOfAnArrayAfterMarkingAllElements.findScore(new int[] {2, 1, 3, 4, 5, 2}));
    System.out.println(
        q2593MFindScoreOfAnArrayAfterMarkingAllElements.findScore(new int[] {2, 3, 5, 1, 3, 2}));
  }

  public long findScore(int[] nums) { // 165 ms, beats 56.37%
    long score = 0;
    int n = nums.length;
    boolean[] marked = new boolean[n];
    PriorityQueue<Node> queue = new PriorityQueue<>();
    for (int i = 0; i < n; i++) queue.add(new Node(nums[i], i));

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (marked[node.index]) continue;
      marked[node.index] = true;
      score += node.value;
      if (node.index > 0) marked[node.index - 1] = true;
      if (node.index < n - 1) marked[node.index + 1] = true;
    }
    return score;
  }

  private record Node(int value, int index) implements Comparable<Node> {
    @Override
    public int compareTo(Node o) {
      if (this.value == o.value) return this.index - o.index;
      return this.value - o.value;
    }
  }
}
