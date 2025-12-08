package leetcode.practise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vivek
 * @since 2025-12-07
 */
public class Q1925_E_CountSquareSumTriples {

  public static void main(String[] args) {
    Q1925_E_CountSquareSumTriples q1925ECountSquareSumTriples = new Q1925_E_CountSquareSumTriples();
    System.out.println(q1925ECountSquareSumTriples.countTriples(18));
    System.out.println(q1925ECountSquareSumTriples.countTriples(5));
    System.out.println(q1925ECountSquareSumTriples.countTriples(10));
  }

  public int countTriples(int n) {
    int cnt = 0;
    Set<Integer> set = new HashSet<>();
    for (int i = 1; i <= n; i++) set.add(i * i);
    for (Integer a : set) for (Integer b : set) if (set.contains(a + b)) cnt++;
    return cnt;
  }
}
