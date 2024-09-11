package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-09-10
 */
public class Q2220_E_MinimumBitFlipsToConvertNumber {

  public static void main(String[] args) {
    // System.out.println(Integer.toBinaryString(82));

    Q2220_E_MinimumBitFlipsToConvertNumber q2220EMinimumBitFlipsToConvertNumber =
        new Q2220_E_MinimumBitFlipsToConvertNumber();
    System.out.println(q2220EMinimumBitFlipsToConvertNumber.minBitFlips(10, 7)); // 3
    System.out.println(q2220EMinimumBitFlipsToConvertNumber.minBitFlips(3, 4)); // 3
    System.out.println(q2220EMinimumBitFlipsToConvertNumber.minBitFlips(10, 82)); // 3
  }

  public int minBitFlips(int start, int goal) {
    int cnt = 0;
    while (start > 0 && goal > 0) {
      if ((start & 1) != (goal & 1)) cnt++;
      start >>= 1;
      goal >>= 1;
    }
    while (start > 0) {
      if ((start & 1) == 1) cnt++;
      start >>= 1;
    }
    while (goal > 0) {
      if ((goal & 1) == 1) cnt++;
      goal >>= 1;
    }
    return cnt;
  }
}
