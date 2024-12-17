package leetcode.practise;

import java.util.PriorityQueue;

/**
 * @author Vivek
 * @since 2024-12-16
 */
public class Q2182_M_ConstructStringWithRepeatLimit {

  public static void main(String[] args) {
    Q2182_M_ConstructStringWithRepeatLimit q2182MConstructStringWithRepeatLimit =
        new Q2182_M_ConstructStringWithRepeatLimit();
    System.out.println(q2182MConstructStringWithRepeatLimit.repeatLimitedString("cczazcc", 3));
    System.out.println(q2182MConstructStringWithRepeatLimit.repeatLimitedString("aababab", 2));
    System.out.println(
        q2182MConstructStringWithRepeatLimit.repeatLimitedString(
            "robnsdvpuxbapuqgopqvxdrchivlifeepy", 2));
    // yxxvvuvusrrqqppopponliihgfeeddcbba - expected
    // yxxvvuvusrrqqppopponliihgfeeddcbba
  }

  public String repeatLimitedString(String s, int repeatLimit) { // 86 ms, beats 23.73%
    StringBuilder data = new StringBuilder();
    Node[] nodes = new Node[26];
    PriorityQueue<Node> queue = new PriorityQueue<>();
    for (int i = 0; i < 26; i++) nodes[i] = new Node((char) (i + 'a'));
    for (int i = 0; i < s.length(); i++) nodes[s.charAt(i) - 'a'].increment();
    for (int i = 0; i < 26; i++) if (nodes[i].count > 0) queue.add(nodes[i]);

    Node store;
    int consecutive = 0;
    char lastCh = '\0';
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (lastCh != node.ch) {
        consecutive = 0;
        lastCh = node.ch;
      }
      if (consecutive == repeatLimit) {
        store = node;

        if (queue.isEmpty()) break;
        node = queue.poll();
        consecutive = 1;
        queue.add(store);

        data.append(node.ch);
        lastCh = node.ch;
        node.decrement();
        if (node.count > 0) queue.add(node);

      } else if (consecutive < repeatLimit) {
        consecutive++;
        data.append(node.ch);
        node.decrement();
        if (node.count > 0) queue.add(node);
      }
    }

    return data.toString();
  }

  private static final class Node implements Comparable<Node> {
    final char ch;
    int count;

    public Node(char ch) {
      this.ch = ch;
      this.count = 0;
    }

    public void increment() {
      count++;
    }

    public void decrement() {
      count--;
    }

    @Override
    public int compareTo(Node o) {
      return o.ch - this.ch;
    }
  }
}
