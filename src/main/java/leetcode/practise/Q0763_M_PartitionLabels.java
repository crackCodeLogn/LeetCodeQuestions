package leetcode.practise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vivek
 * @since 2025-03-29
 */
public class Q0763_M_PartitionLabels {

  public static void main(String[] args) {
    Q0763_M_PartitionLabels q0763MPartitionLabels = new Q0763_M_PartitionLabels();
    System.out.println(q0763MPartitionLabels.partitionLabels("ababcbacadefegdehijhklij"));
    System.out.println(q0763MPartitionLabels.partitionLabels("eccbbbbdec"));
  }

  public List<Integer> partitionLabels(String s) { // 13ms, beats 7.63%
    List<Integer> result = new ArrayList<>();
    Map<Character, Node> map = new HashMap<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      int finalI = i;
      map.compute(ch, (k, v) -> v == null ? new Node(ch, finalI) : v).setEnd(i);
    }
    List<Node> nodes =
        map.values().stream().sorted(Comparator.comparingInt(Node::getStart)).toList();
    Node node = nodes.get(0);
    int start = node.getStart(), end = node.getEnd();
    for (int i = 1; i < nodes.size(); i++) {
      node = nodes.get(i);
      if (node.getStart() > end) { // new block switch
        result.add(end - start + 1);
        start = node.getStart();
        end = node.getEnd();
      } else {
        end = Math.max(end, node.getEnd());
      }
    }
    result.add(end - start + 1);
    return result;
  }

  private static class Node {
    private final char ch;
    private final int start;
    private int end;

    public Node(char ch, int start) {
      this.ch = ch;
      this.start = start;
      this.end = start;
    }

    public int getStart() {
      return start;
    }

    public int getEnd() {
      return end;
    }

    public void setEnd(int end) {
      this.end = end;
    }

    @Override
    public String toString() {
      return String.format("%c :: %d->%d", ch, start, end);
    }
  }
}
