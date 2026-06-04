package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-06-03
 */
public class Q3751_M_TotalWavinessOfNumbersInRangeI {
  private static final int[] COUNT_PEAK_VALLEY = new int[100_001];

  public static void main(String[] args) {
    Q3751_M_TotalWavinessOfNumbersInRangeI q3751MTotalWavinessOfNumbersInRangeI =
        new Q3751_M_TotalWavinessOfNumbersInRangeI();
    System.out.println(q3751MTotalWavinessOfNumbersInRangeI.totalWaviness(120, 130));
    System.out.println(q3751MTotalWavinessOfNumbersInRangeI.totalWaviness(198, 202));
    System.out.println(q3751MTotalWavinessOfNumbersInRangeI.totalWaviness(4848, 4848));
  }

  public int totalWaviness(int num1, int num2) { // 30ms, beats 31.23% without pre-caching
    // 9ms, beats 100% with pre-caching
    if (COUNT_PEAK_VALLEY[131] == 0)
      for (int i = 1; i <= 100_000; i++) COUNT_PEAK_VALLEY[i] = calc(i);

    int cnt = 0;
    for (int i = num1; i <= num2; i++) cnt += COUNT_PEAK_VALLEY[i];
    return cnt;
  }

  private int calc(int n) {
    if (n <= 99) return 0;
    String v = String.valueOf(n);
    int cnt = 0;
    for (int i = 1; i < v.length() - 1; i++)
      if ((v.charAt(i) > v.charAt(i + 1) && v.charAt(i) > v.charAt(i - 1))
          || (v.charAt(i) < v.charAt(i - 1) && v.charAt(i) < v.charAt(i + 1))) cnt++;
    return cnt;
  }
}
