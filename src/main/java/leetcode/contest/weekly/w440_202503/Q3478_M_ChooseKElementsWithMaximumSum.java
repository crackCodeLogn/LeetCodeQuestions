package leetcode.contest.weekly.w440_202503;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Vivek
 * @since 2025-03-08
 */
public class Q3478_M_ChooseKElementsWithMaximumSum {

  public static void main(String[] args) {
    Q3478_M_ChooseKElementsWithMaximumSum q3478MChooseKElementsWithMaximumSum =
        new Q3478_M_ChooseKElementsWithMaximumSum();
    System.out.println(
        Arrays.toString(
            q3478MChooseKElementsWithMaximumSum.findMaxSum(
                new int[] {1, 2, 2, 2, 5}, new int[] {10, 20, 30, 40, 50}, 1)));
    System.out.println(
        Arrays.toString(
            q3478MChooseKElementsWithMaximumSum.findMaxSum(
                new int[] {4, 2, 1, 5, 3}, new int[] {10, 20, 30, 40, 50}, 2)));
    System.out.println(
        Arrays.toString(
            q3478MChooseKElementsWithMaximumSum.findMaxSum(
                new int[] {2, 2, 2, 2}, new int[] {3, 1, 2, 3}, 1)));
  }

  public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
    int n = nums1.length;
    long[] answer = new long[n];

    Integer[] indices = new Integer[n];
    for (int i = 0; i < n; i++) indices[i] = i;
    Arrays.sort(indices, Comparator.comparingInt(i -> nums1[i]));

    List<int[]> sortedPairs = new ArrayList<>();
    for (int i = 0; i < n; i++) sortedPairs.add(new int[] {nums1[i], nums2[i]});
    sortedPairs.sort(Comparator.comparingInt(a -> a[0]));

    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
    long sum = 0;
    int ptr = 0;

    for (int i : indices) {
      int currVal = nums1[i];
      while (ptr < n && sortedPairs.get(ptr)[0] < currVal) {
        int num2Val = sortedPairs.get(ptr)[1];
        if (minHeap.size() < k) {
          minHeap.add(num2Val);
          sum += num2Val;
        } else if (!minHeap.isEmpty() && num2Val > minHeap.peek()) {
          sum += num2Val - minHeap.poll();
          minHeap.add(num2Val);
        }
        ptr++;
      }
      answer[i] = sum;
    }
    return answer;
  }

  public long[] findMaxSum2(int[] nums1, int[] nums2, int k) {
    int n = nums1.length;
    long[] data = new long[n];
    List<Node> nodes = new ArrayList<>(n);
    List<Pair> pairs = new ArrayList<>(n);
    Map<Integer, List<Integer>> nums1Map = new HashMap<>(n);
    for (int i = 0; i < n; i++) {
      pairs.add(new Pair(nums1[i], i));
      nums1Map.compute(nums1[i], (k1, k2) -> k2 == null ? new ArrayList<>() : k2).add(nums2[i]);
    }
    pairs.sort(Comparator.comparingInt(Pair::num));

    return data;
  }

  private record Pair(int num, int index) {}

  private record Node(int num, int buff, int index) {}
}
