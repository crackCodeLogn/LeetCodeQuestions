package leetcode.practise;

import java.util.TreeSet;

/**
 * @author Vivek
 * @since 2025-03-04
 */
public class Q1780_M_CheckIfNumberIsASumOfPowersOfThree {
  private static final int LIMIT = 10_000_000;
  private static final TreeSet<Integer> THREE = new TreeSet<>();

  public static void main(String[] args) {
    Q1780_M_CheckIfNumberIsASumOfPowersOfThree q1780MCheckIfNumberIsASumOfPowersOfThree =
        new Q1780_M_CheckIfNumberIsASumOfPowersOfThree();
    System.out.println(q1780MCheckIfNumberIsASumOfPowersOfThree.checkPowersOfThree(6574365));
    System.out.println(q1780MCheckIfNumberIsASumOfPowersOfThree.checkPowersOfThree(3));
    System.out.println(q1780MCheckIfNumberIsASumOfPowersOfThree.checkPowersOfThree(1));
    System.out.println(q1780MCheckIfNumberIsASumOfPowersOfThree.checkPowersOfThree(2));
    System.out.println(q1780MCheckIfNumberIsASumOfPowersOfThree.checkPowersOfThree(12));
    System.out.println(q1780MCheckIfNumberIsASumOfPowersOfThree.checkPowersOfThree(91));
    System.out.println(q1780MCheckIfNumberIsASumOfPowersOfThree.checkPowersOfThree(21));
  }

  public boolean checkPowersOfThree(int n) { // 0 ms, beats 100%
    int last = 0;
    double log3 = Math.log10(3);
    while (n > 0) {
      // int base = (int) (Math.log(n) / log3); // gave weird precision error 243 => 4.99999999999
      // and not 5
      int base = (int) (Math.log10(n) / log3); // this worked for 243... wth?
      int v = (int) Math.pow(3, base);
      if (last == v) return false;
      last = v;
      n -= v;
      if (n == 0) return true;
    }
    return false;
  }

  public boolean checkPowersOfThree2(int n) { // 1ms, beats 15.70%
    if (THREE.isEmpty()) {
      int v = 3;
      THREE.add(1);
      do {
        THREE.add(v);
        v *= 3;
      } while (v >= 0 && v < LIMIT);
    }

    int last = 0;
    while (n > 0) {
      Integer v = THREE.floor(n);
      if (last == v) return false;
      last = v;
      n -= v;
      if (n == 0) return true;
    }
    return false;
  }
}
