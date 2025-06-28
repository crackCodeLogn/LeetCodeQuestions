package leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Vivek
 * @since 2025-06-27
 */
public class Q2099_E_FindSubsequenceOfLengthKWithTheLargestSum {

  public static void main(String[] args) {
    Q2099_E_FindSubsequenceOfLengthKWithTheLargestSum
        q2099EFindSubsequenceOfLengthKWithTheLargestSum =
            new Q2099_E_FindSubsequenceOfLengthKWithTheLargestSum();
    System.out.println(
        Arrays.toString(
            q2099EFindSubsequenceOfLengthKWithTheLargestSum.maxSubsequence(
                new int[] {
                  50, -75,
                },
                2)));
    System.out.println(
        Arrays.toString(
            q2099EFindSubsequenceOfLengthKWithTheLargestSum.maxSubsequence(
                new int[] {2, 1, 3, 3}, 2)));
    System.out.println(
        Arrays.toString(
            q2099EFindSubsequenceOfLengthKWithTheLargestSum.maxSubsequence(
                new int[] {-1, -2, 3, 4}, 3)));
    System.out.println(
        Arrays.toString(
            q2099EFindSubsequenceOfLengthKWithTheLargestSum.maxSubsequence(
                new int[] {
                  3, 4, 3, 3,
                },
                2)));
  }

  public int[] maxSubsequence3(int[] nums, int k) { // 11ms, beats 18.90%
    int[] data = new int[k];
    List<Node> nodes = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) nodes.add(new Node(i, nums[i]));
    nodes.sort(Comparator.comparingInt(Node::value));
    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::i));
    for (int i = nums.length - 1; k-- > 0; i--) queue.add(nodes.get(i));

    int j = 0;
    while (!queue.isEmpty()) data[j++] = queue.poll().value();
    return data;
  }

  public int[] maxSubsequence(int[] nums, int k) { // 10ms, beats 25.59%
    int[] data = new int[k];
    List<Node> nodes = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) nodes.add(new Node(i, nums[i]));
    nodes.sort(Comparator.comparingInt(Node::value));
    nodes = nodes.subList(nums.length - k, nodes.size());
    nodes.sort(Comparator.comparingInt(Node::i));
    int j = 0;
    for (Node node : nodes) data[j++] = node.value;
    return data;
  }

  private record Node(int i, int value) {}
}
