package leetcode.practise;

/**
 * @author Vivek
 * @since 8/14/25
 */
public class Q0342_E_PowerOfFour {
  private static final double LOG4 = Math.log10(4);

  public static void main(String[] args) {
    Q0342_E_PowerOfFour q0342EPowerOfFour = new Q0342_E_PowerOfFour();
    System.out.println(q0342EPowerOfFour.isPowerOfFour(16));
    System.out.println(q0342EPowerOfFour.isPowerOfFour(5));
    System.out.println(q0342EPowerOfFour.isPowerOfFour(1));
  }

  public boolean isPowerOfFour(int n) {
    return String.valueOf(Math.log10(n) / LOG4).endsWith(".0");
  }
}
