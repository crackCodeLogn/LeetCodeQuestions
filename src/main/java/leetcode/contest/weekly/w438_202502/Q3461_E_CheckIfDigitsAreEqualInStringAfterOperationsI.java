package leetcode.contest.weekly.w438_202502;

/**
 * @author Vivek
 * @since 2025-02-22
 */
public class Q3461_E_CheckIfDigitsAreEqualInStringAfterOperationsI {

  public static void main(String[] args) {
    Q3461_E_CheckIfDigitsAreEqualInStringAfterOperationsI
        q3461ECheckIfDigitsAreEqualInStringAfterOperationsI =
            new Q3461_E_CheckIfDigitsAreEqualInStringAfterOperationsI();
    System.out.println(q3461ECheckIfDigitsAreEqualInStringAfterOperationsI.hasSameDigits("321881"));
    System.out.println(q3461ECheckIfDigitsAreEqualInStringAfterOperationsI.hasSameDigits("3902"));
    System.out.println(q3461ECheckIfDigitsAreEqualInStringAfterOperationsI.hasSameDigits("34789"));
  }

  public boolean hasSameDigits(String data) {
    while (data.length() != 2) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < data.length() - 1; i++) {
        sb.append(compute(data.charAt(i), data.charAt(i + 1)));
      }
      data = sb.toString();
    }
    return data.charAt(0) == data.charAt(1);
  }

  private int compute(char ch1, char ch2) {
    return ((ch1 - '0') + (ch2 - '0')) % 10;
  }
}
