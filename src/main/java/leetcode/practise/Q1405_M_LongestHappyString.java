package leetcode.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Vivek
 * @since 2024-10-15
 */
public class Q1405_M_LongestHappyString {

  public static void main(String[] args) {
    Q1405_M_LongestHappyString q1405MLongestHappyString = new Q1405_M_LongestHappyString();
    //    System.out.println(q1405MLongestHappyString.longestDiverseString(1, 1, 7));
    //    System.out.println(q1405MLongestHappyString.longestDiverseString(7, 1, 0));
    //    System.out.println(q1405MLongestHappyString.longestDiverseString(0, 8, 11));
    //    System.out.println(q1405MLongestHappyString.longestDiverseString(0, 1, 1));
    System.out.println(q1405MLongestHappyString.longestDiverseString(4, 42, 7));
  }

  public String longestDiverseString(int a, int b, int c) {
    PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n2.getCount() - n1.getCount());
    // PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.getCount() - n2.getCount());
    if (a > 0) queue.offer(new Node('a', a));
    if (b > 0) queue.offer(new Node('b', b));
    if (c > 0) queue.offer(new Node('c', c));

    StringBuilder data = new StringBuilder();
    int noChange = 0;
    char lastCh = '\0';
    while (!queue.isEmpty() && noChange < 10) {
      Node node = queue.poll();
      List<Node> repush = new ArrayList<>();
      if (node.getCh() == lastCh) {
        if (!queue.isEmpty()) {
          repush.add(node);
          node = queue.poll(); // has to be a diff one
        } else { // no other option left
          queue.add(node);
          break;
        }
      }

      if (node.getCount() <= 0) {
        noChange++;
        queue.addAll(repush);
        continue;
      }
      if (isLastTwoSame(data, node.getCh())) {
        noChange++;
        queue.offer(node);
        queue.addAll(repush);
        continue;
      }

      data.append(node.getCh());
      noChange = 0;
      node.reduce();
      lastCh = node.getCh();

      if (node.getCount() > 0 && !isLastTwoSame(data, node.getCh())) {
        data.append(node.getCh());
        node.reduce();
      }

      if (node.getCount() > 0 && !isFirstTwoSame(data, node.getCh())) {
        data.insert(0, node.getCh());
        node.reduce();
      }

      if (node.getCount() > 0 && !isFirstTwoSame(data, node.getCh())) {
        data.insert(0, node.getCh());
        node.reduce();
      }

      if (node.getCount() > 0) queue.offer(node);

      queue.addAll(repush);
    }

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      int i = 0;
      while (i < data.length() && node.getCount() > 0) {
        if (i < data.length() - 2
            && data.charAt(i) != node.getCh()
            && data.charAt(i + 1) != node.getCh()) {
          data.insert(i + 1, node.getCh());
          node.reduce();
        } else if (i > 0
            && i < data.length() - 1
            && data.charAt(i) == node.getCh()
            && data.charAt(i + 1) != node.getCh()
            && data.charAt(i - 1) != node.getCh()) {
          data.insert(i + 1, node.getCh());
          node.reduce();
        }
        i++;
      }
    }
    return data.toString();
  }

  private boolean isLastTwoSame(StringBuilder data, char ch) {
    return data.length() >= 2
        && data.charAt(data.length() - 1) == ch
        && data.charAt(data.length() - 2) == ch;
  }

  private boolean isFirstTwoSame(StringBuilder data, char ch) {
    return data.length() >= 2 && data.charAt(0) == ch && data.charAt(1) == ch;
  }

  private static final class Node {
    private final char ch;
    private int count;

    public Node(char ch, int count) {
      this.ch = ch;
      this.count = count;
    }

    @Override
    public String toString() {
      return ch + "=" + count;
    }

    public char getCh() {
      return ch;
    }

    public int getCount() {
      return count;
    }

    public void reduce() {
      this.count--;
    }
  }
}
