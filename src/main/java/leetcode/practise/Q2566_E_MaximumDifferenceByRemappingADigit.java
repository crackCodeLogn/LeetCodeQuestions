package leetcode.practise;

import static org.junit.Assert.assertEquals;

public class Q2566_E_MaximumDifferenceByRemappingADigit {

  public static void main(String[] args) {
    Q2566_E_MaximumDifferenceByRemappingADigit q2566EMaximumDifferenceByRemappingADigit =
        new Q2566_E_MaximumDifferenceByRemappingADigit();
    assertEquals(99009, q2566EMaximumDifferenceByRemappingADigit.minMaxDifference(11891));
    assertEquals(99, q2566EMaximumDifferenceByRemappingADigit.minMaxDifference(90));
  }

  public int minMaxDifference(int num) {
    String v = String.valueOf(num);
    int p = -1, p0 = -1, n = v.length();
    for (int i = 0; i < n; i++) {
      if (p == -1 && v.charAt(i) != '9') p = i;
      if (p0 == -1 && v.charAt(i) != '0') p0 = i;
    }
    int v1 = p != -1 ? Integer.parseInt(v.replaceAll(v.charAt(p) + "", "9")) : num;
    int v2 = p0 != -1 ? Integer.parseInt(v.replaceAll(v.charAt(p0) + "", "0")) : num;
    return Math.abs(v1 - v2);
  }
}
