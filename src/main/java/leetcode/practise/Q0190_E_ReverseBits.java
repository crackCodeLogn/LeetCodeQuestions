package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-02-15
 */
public class Q0190_E_ReverseBits {

  public static void main(String[] args) {
    Q0190_E_ReverseBits q0190EReverseBits = new Q0190_E_ReverseBits();
    System.out.println(q0190EReverseBits.reverseBits(43261596));
    System.out.println(q0190EReverseBits.reverseBits(2147483644));
  }

  public int reverseBits(int n) { // 1ms, beats 60.34%
    int n2 = 0, v = 32;
    while (v-- > 0) {
      int bit = n > 0 ? n & 1 : 0;
      n >>= 1;
      n2 = (n2 << 1) | bit;
    }
    return n2;
  }
}
