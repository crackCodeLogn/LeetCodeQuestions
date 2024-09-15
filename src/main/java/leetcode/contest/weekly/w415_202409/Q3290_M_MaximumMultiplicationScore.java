package leetcode.contest.weekly.w415_202409;

/**
 * @author Vivek
 * @since 2024-09-14
 */
public class Q3290_M_MaximumMultiplicationScore {
  long[][] data2;

  public static void main(String[] args) {
    Q3290_M_MaximumMultiplicationScore q3290MMaximumMultiplicationScore =
        new Q3290_M_MaximumMultiplicationScore();
    System.out.println(
        q3290MMaximumMultiplicationScore.maxScore(
            new int[] {3, 2, 5, 6}, new int[] {2, -6, 4, -5, -3, 2, -7}));
    System.out.println(
        q3290MMaximumMultiplicationScore.maxScore(
            new int[] {-1, 4, 5, -2}, new int[] {-5, -1, -3, -2, -4}));
  }

  public long maxScore(int[] a, int[] b) {
    data2 = new long[4][b.length + 1];
    return compute(0, 0, a, b);
  }

  private long compute(int i, int j, int[] a, int[] b) {
    if (i >= 4 || j >= b.length) return 0;
    if (data2[i][j] != 0) return data2[i][j];

    if (4 - i == b.length - j) {
      long cnt = 0;
      while (i < a.length) {
        cnt += ((long) a[i++]) * b[j++];
      }
      return cnt;
    }
    long v1 = compute(i, j + 1, a, b);
    long v2 = (long) a[i] * b[j] + compute(i + 1, j + 1, a, b);
    long v = Math.max(v1, v2);
    data2[i][j] = v;
    return v;
  }
}
