package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-01-14
 */
public class Q2429_M_MinimizeXor {

  public static void main(String[] args) {
    Q2429_M_MinimizeXor q2429MMinimizeXor = new Q2429_M_MinimizeXor();
    System.out.println(q2429MMinimizeXor.minimizeXor(41, 3)); // 40
    System.out.println(q2429MMinimizeXor.minimizeXor(41, 15)); // 43
    System.out.println(q2429MMinimizeXor.minimizeXor(3, 5));
    System.out.println(q2429MMinimizeXor.minimizeXor(1, 12));
  }

  public int minimizeXor(int num1, int num2) { // 1ms, beats 15.09%
    int bits2 = setBits(num2);
    int bits1 = setBits(num1);
    if (bits1 == bits2) return num1;

    StringBuilder data = new StringBuilder(Integer.toBinaryString(num1));
    if (bits1 > bits2) {
      for (int i = 0; i < data.length(); i++) {
        boolean set = data.charAt(i) == '1';
        if (set) {
          if (bits2 > 0) bits2--;
          else data.setCharAt(i, '0');
        }
      }
    } else {
      bits2 -= bits1;
      for (int i = data.length() - 1; i >= 0; i--) {
        boolean set = data.charAt(i) == '1';
        if (!set && bits2-- > 0) data.setCharAt(i, '1');
      }
      while (bits2-- > 0) data.insert(0, '1');
    }

    return Integer.parseInt(data.toString(), 2);
  }

  private int setBits(int num) {
    int set = 0;
    while (num > 0) {
      if ((num & 1) == 1) set++;
      num >>= 1;
    }
    return set;
  }
}
