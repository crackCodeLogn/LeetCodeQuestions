package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-02-17
 */
public class Q0693_E_BinaryNumberWithAlternatingBits {

  public static void main(String[] args) {
    Q0693_E_BinaryNumberWithAlternatingBits q0693EBinaryNumberWithAlternatingBits =
        new Q0693_E_BinaryNumberWithAlternatingBits();
    System.out.println(q0693EBinaryNumberWithAlternatingBits.hasAlternatingBits(5));
    System.out.println(q0693EBinaryNumberWithAlternatingBits.hasAlternatingBits(7));
    System.out.println(q0693EBinaryNumberWithAlternatingBits.hasAlternatingBits(11));
    System.out.println(q0693EBinaryNumberWithAlternatingBits.hasAlternatingBits(4));
  }

  public boolean hasAlternatingBits(int n) { // 0 ms, beats 100%
    int flag = n & 1;
    n >>= 1;
    while (n > 0) {
      int v = n & 1;
      if ((flag ^ v) == 0) return false;
      flag = v;
      n >>= 1;
    }
    return true;
  }
}
