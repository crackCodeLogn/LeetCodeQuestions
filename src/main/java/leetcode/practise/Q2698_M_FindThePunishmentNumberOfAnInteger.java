package leetcode.practise;

import java.util.TreeSet;

/**
 * @author Vivek
 * @since 2025-02-14
 */
public class Q2698_M_FindThePunishmentNumberOfAnInteger {

  private static final TreeSet<Integer> set = new TreeSet<>();

  public static void main(String[] args) {
    Q2698_M_FindThePunishmentNumberOfAnInteger q2698MFindThePunishmentNumberOfAnInteger =
        new Q2698_M_FindThePunishmentNumberOfAnInteger();
    System.out.println(q2698MFindThePunishmentNumberOfAnInteger.punishmentNumber(10)); // 182
    System.out.println(q2698MFindThePunishmentNumberOfAnInteger.punishmentNumber(37)); // 1478
  }

  public int punishmentNumber(int n) { // 6ms, beats 80.25%
    if (set.isEmpty()) {
      for (int i = 1; i <= 1001; i++) compute(0, String.valueOf(i * i), i);
    }
    int sum = 0;
    for (int val : set) {
      if (val > n) break;
      sum += val * val;
    }
    return sum;
  }

  private void compute(int carry, String data, int base) {
    if (set.contains(base)) return;

    for (int i = 0; i < data.length(); i++) {
      String s1 = data.substring(0, i + 1);
      String s2 = data.substring(i + 1);
      int is1 = getVal(s1);
      if (carry + is1 + getVal(s2) == base) {
        // System.out.println("Match found for " + base + " >> " + carry + " >> " + is1 + " >> " +
        // s2);
        set.add(base);
        return;
      }
      compute(carry + is1, s2, base);
    }
  }

  private int getVal(String str) {
    if (str.isEmpty()) return 0;
    return Integer.parseInt(str);
  }
}
