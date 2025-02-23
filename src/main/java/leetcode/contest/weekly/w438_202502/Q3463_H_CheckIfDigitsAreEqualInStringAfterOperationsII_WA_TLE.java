package leetcode.contest.weekly.w438_202502;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2025-02-22
 */
public class Q3463_H_CheckIfDigitsAreEqualInStringAfterOperationsII_WA_TLE {

  public static void main(String[] args) {
    Q3463_H_CheckIfDigitsAreEqualInStringAfterOperationsII_WA_TLE
        q3463HCheckIfDigitsAreEqualInStringAfterOperationsIIWATLE =
            new Q3463_H_CheckIfDigitsAreEqualInStringAfterOperationsII_WA_TLE();
    System.out.println(
        q3463HCheckIfDigitsAreEqualInStringAfterOperationsIIWATLE.hasSameDigits(
            "2367679537183200808337444239103035091812101003664191823186564233"));
    System.out.println(
        q3463HCheckIfDigitsAreEqualInStringAfterOperationsIIWATLE.hasSameDigits("321881"));
    System.out.println(
        q3463HCheckIfDigitsAreEqualInStringAfterOperationsIIWATLE.hasSameDigits("3902"));
    System.out.println(
        q3463HCheckIfDigitsAreEqualInStringAfterOperationsIIWATLE.hasSameDigits("34789"));
  }

  public boolean hasSameDigits(String s) {
    long s1 = 0, s2 = 0;
    int n = s.length(), multiplier = n - 2;
    List<Long> pascalRow = getPascalRow(multiplier);
    s1 = convert(s, 0) + convert(s, n - 2);
    s1 %= 10;
    for (int i = 1, k = 1; i <= n - 3; i++, k++) s1 += (convert(s, i) * pascalRow.get(k)) % 10;

    s2 = convert(s, 1) + convert(s, n - 1);
    s2 %= 10;
    for (int i = 2, k = 1; i <= n - 2; i++, k++) s2 += (convert(s, i) * pascalRow.get(k)) % 10;

    System.out.println(pascalRow);
    // System.out.println(s1 + " " + s2);
    return s1 % 10 == s2 % 10;
  }

  private int convert(String s, int index) {
    return (s.charAt(index) - '0') % 10;
  }

  private List<Long> getPascalRow(int row) {
    List<Long> list = new ArrayList<>();
    long value = 1;
    list.add(value);
    for (int i = 1; i <= row; i++) {
      long curr = value * (row - i + 1) / i;
      curr %= Long.MAX_VALUE;
      list.add(curr);
      if (curr == 0) curr = 1;
      value = curr;
    }
    return list;
  }
}
