package leetcode.practise;

/**
 * @author Vivek
 * @since 8/15/25
 */
public class Q1323_E_Maximum69Number {
  public static void main(String[] args) {
    Q1323_E_Maximum69Number q1323EMaximum69Number = new Q1323_E_Maximum69Number();
    System.out.println(q1323EMaximum69Number.maximum69Number(9669));
    System.out.println(q1323EMaximum69Number.maximum69Number(9996));
    System.out.println(q1323EMaximum69Number.maximum69Number(9999));
  }

  public int maximum69Number(int num) { // 0ms, beats 100%
    StringBuilder s = new StringBuilder(String.valueOf(num));
    for (int i = 0; i < s.length(); i++)
      if (s.charAt(i) == '6') {
        s.setCharAt(i, '9');
        break;
      }
    return Integer.parseInt(s.toString());
  }
}
