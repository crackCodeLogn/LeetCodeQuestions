package leetcode.practise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2025-03-02
 */
public class Q2161_M_PartitionArrayAccordingToGivenPivot {

  public static void main(String[] args) {
    Q2161_M_PartitionArrayAccordingToGivenPivot q2161MPartitionArrayAccordingToGivenPivot =
        new Q2161_M_PartitionArrayAccordingToGivenPivot();
    System.out.println(
        Arrays.toString(
            q2161MPartitionArrayAccordingToGivenPivot.pivotArray(
                new int[] {9, 12, 5, 10, 14, 3, 10}, 10)));
    System.out.println(
        Arrays.toString(
            q2161MPartitionArrayAccordingToGivenPivot.pivotArray(new int[] {-3, 4, 3, 2}, 2)));
  }

  public int[] pivotArray(int[] nums, int pivot) { // 5ms, beats 85.39%
    int[] data = new int[nums.length];
    int i = 0;
    for (int num : nums) if (num < pivot) data[i++] = num;
    for (int num : nums) if (num == pivot) data[i++] = num;
    for (int num : nums) if (num > pivot) data[i++] = num;
    return data;
  }

  public int[] pivotArray2(int[] nums, int pivot) { // 14ms, beats 22.82%
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    int cnt = 0;
    for (int num : nums) {
      if (num < pivot) q1.offer(num);
      else if (num == pivot) cnt++;
      else q2.offer(num);
    }
    int i = 0;
    while (!q1.isEmpty()) nums[i++] = q1.poll();
    while (cnt-- > 0) nums[i++] = pivot;
    while (!q2.isEmpty()) nums[i++] = q2.poll();
    return nums;
  }
}
