package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-02-21
 */
public class Q0868_E_BinaryGap {
  public static void main(String[] args) {
    Q0868_E_BinaryGap q0868EBinaryGap = new Q0868_E_BinaryGap();
    System.out.println(q0868EBinaryGap.binaryGap(22));
    System.out.println(q0868EBinaryGap.binaryGap(8));
    System.out.println(q0868EBinaryGap.binaryGap(5));
    System.out.println(q0868EBinaryGap.binaryGap(1));
    System.out.println(q0868EBinaryGap.binaryGap(2));
    System.out.println(q0868EBinaryGap.binaryGap(3));
  }

  public int binaryGap(int n) { // 0ms, beats 100%
    int lastIndex = -1, maxLength = 0, j = 0;
    while (n > 0) {
      j++;
      boolean isOne = (n & 1) == 1;
      if (isOne) {
        if (lastIndex != -1) maxLength = Math.max(maxLength, j - lastIndex);
        lastIndex = j;
      }
      n >>= 1;
    }
    return maxLength;
  }
}
