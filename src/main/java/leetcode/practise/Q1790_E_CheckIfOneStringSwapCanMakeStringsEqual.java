package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2025-02-04
 */
public class Q1790_E_CheckIfOneStringSwapCanMakeStringsEqual {
  public static void main(String[] args) {
    Q1790_E_CheckIfOneStringSwapCanMakeStringsEqual q1790ECheckIfOneStringSwapCanMakeStringsEqual =
        new Q1790_E_CheckIfOneStringSwapCanMakeStringsEqual();
    System.out.println(q1790ECheckIfOneStringSwapCanMakeStringsEqual.areAlmostEqual("aa", "ac"));
    System.out.println(
        q1790ECheckIfOneStringSwapCanMakeStringsEqual.areAlmostEqual("bank", "kanb"));
    System.out.println(
        q1790ECheckIfOneStringSwapCanMakeStringsEqual.areAlmostEqual("attack", "defend"));
    System.out.println(
        q1790ECheckIfOneStringSwapCanMakeStringsEqual.areAlmostEqual("kelb", "kelb"));
  }

  public boolean areAlmostEqual(String s1, String s2) {
    int n = s1.length();
    List<Integer> missing = new ArrayList<>(n);
    for (int i = 0; i < n; i++) if (s1.charAt(i) != s2.charAt(i)) missing.add(i);
    if (missing.isEmpty()) return true;
    if (missing.size() != 2) return false;
    return s1.charAt(missing.get(0)) == s2.charAt(missing.get(1))
        && s1.charAt(missing.get(1)) == s2.charAt(missing.get(0));
  }
}
