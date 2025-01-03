package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-01-02
 */
public class Q2270_M_NumberOfWaysToSplitArray {
  public static void main(String[] args) {
    Q2270_M_NumberOfWaysToSplitArray q2270MNumberOfWaysToSplitArray =
        new Q2270_M_NumberOfWaysToSplitArray();
    System.out.println(
        q2270MNumberOfWaysToSplitArray.waysToSplitArray(new int[] {10, 4, -8, 7})); // 2
    System.out.println(
        q2270MNumberOfWaysToSplitArray.waysToSplitArray(new int[] {2, 3, 1, 0})); // 2
  }

  public int waysToSplitArray(int[] nums) { // 3ms, beats 59.69%
    int n = nums.length, cnt = 0;
    long[] data = new long[n];
    data[0] = nums[0];
    for (int i = 1; i < n; i++) data[i] = data[i - 1] + nums[i];
    long last = data[n - 1];

    for (int i = 0; i < n - 1; i++) if (data[i] >= last - data[i]) cnt++;
    return cnt;
  }
}
