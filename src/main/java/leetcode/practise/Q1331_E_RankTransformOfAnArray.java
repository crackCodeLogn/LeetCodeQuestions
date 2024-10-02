package leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-10-01
 */
public class Q1331_E_RankTransformOfAnArray {
  public static void main(String[] args) {
    Q1331_E_RankTransformOfAnArray q1331ERankTransformOfAnArray =
        new Q1331_E_RankTransformOfAnArray();
    System.out.println(
        Arrays.toString(
            q1331ERankTransformOfAnArray.arrayRankTransform(new int[] {40, 10, 20, 30})));
    System.out.println(
        Arrays.toString(
            q1331ERankTransformOfAnArray.arrayRankTransform(new int[] {100, 100, 100})));
    System.out.println(
        Arrays.toString(
            q1331ERankTransformOfAnArray.arrayRankTransform(
                new int[] {37, 12, 28, 9, 100, 56, 80, 5, 12})));
  }

  public int[] arrayRankTransform(int[] arr) {
    int[] ranks = new int[arr.length];
    if (arr.length == 0) return ranks;

    int rank = 1, n = arr.length;
    List<Node> data = new ArrayList<>(arr.length);
    for (int i = 0; i < arr.length; i++) data.add(new Node(i, arr[i]));
    data.sort(Comparator.comparingInt(Node::data));
    ranks[data.get(0).index()] = 1;
    int track = data.get(0).data();
    for (int i = 1; i < n; i++) {
      if (data.get(i).data() != track) {
        rank++;
        track = data.get(i).data();
      }
      ranks[data.get(i).index()] = rank;
    }
    return ranks;
  }

  private record Node(int index, int data) {
    public String toString() {
      return index + " " + data;
    }
  }
}
