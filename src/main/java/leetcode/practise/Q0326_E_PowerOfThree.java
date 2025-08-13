package leetcode.practise;

/**
 * @author Vivek
 * @since 8/12/25
 */
public class Q0326_E_PowerOfThree {
  private static final double LOG3 = Math.log10(3);

  public static void main(String[] args) {
    Q0326_E_PowerOfThree q0326EPowerOfThree = new Q0326_E_PowerOfThree();
    System.out.println(q0326EPowerOfThree.isPowerOfThree(27));
    System.out.println(q0326EPowerOfThree.isPowerOfThree(0));
    System.out.println(q0326EPowerOfThree.isPowerOfThree(-1));
    System.out.println(q0326EPowerOfThree.isPowerOfThree(243));
  }

  public boolean isPowerOfThree(int n) { // 15ms, beats 5.88%
    return String.valueOf(Math.log10(n) / LOG3).endsWith(".0");
  }
}
