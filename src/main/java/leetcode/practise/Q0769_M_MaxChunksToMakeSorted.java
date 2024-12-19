package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-12-18
 */
public class Q0769_M_MaxChunksToMakeSorted {

  public static void main(String[] args) {
    Q0769_M_MaxChunksToMakeSorted q0769MMaxChunksToMakeSorted = new Q0769_M_MaxChunksToMakeSorted();
    System.out.println(q0769MMaxChunksToMakeSorted.maxChunksToSorted(new int[] {4, 3, 2, 1, 0}));
    System.out.println(q0769MMaxChunksToMakeSorted.maxChunksToSorted(new int[] {1, 0, 2, 3, 4}));
  }

  public int maxChunksToSorted(int[] arr) {
    int result = 0, n = arr.length;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, arr[i]);
      if (max == i) result++;
    }
    return result;
  }
}
