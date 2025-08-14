package leetcode.practise;

/**
 * @author Vivek
 * @since 8/13/25
 */
public class Q2264_E_Largest3SameDigitNumberInString {
  public static void main(String[] args) {
    Q2264_E_Largest3SameDigitNumberInString q2264ELargest3SameDigitNumberInString =
        new Q2264_E_Largest3SameDigitNumberInString();
    System.out.println(q2264ELargest3SameDigitNumberInString.largestGoodInteger("6777133339"));
    System.out.println(q2264ELargest3SameDigitNumberInString.largestGoodInteger("2300019"));
    System.out.println(q2264ELargest3SameDigitNumberInString.largestGoodInteger("42352338"));
  }

  public String largestGoodInteger(String num) { // 5ms, beats 33.56%
    int v = -1;

    for (int i = 0; i < num.length() - 2; i++) {
      if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
        v = Math.max(v, num.charAt(i) - '0');
        i += 2;
      }
    }

    return v == -1 ? "" : String.format("%d%d%d", v, v, v);
  }
}
