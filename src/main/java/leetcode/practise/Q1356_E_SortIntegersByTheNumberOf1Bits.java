package leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Vivek
 * @since 2026-02-24
 */
public class Q1356_E_SortIntegersByTheNumberOf1Bits {
  public static void main(String[] args) {
    Q1356_E_SortIntegersByTheNumberOf1Bits q1356ESortIntegersByTheNumberOf1Bits =
        new Q1356_E_SortIntegersByTheNumberOf1Bits();
    System.out.println(
        Arrays.toString(
            q1356ESortIntegersByTheNumberOf1Bits.sortByBits(
                new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8})));
    System.out.println(
        Arrays.toString(
            q1356ESortIntegersByTheNumberOf1Bits.sortByBits(
                new int[] {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})));
  }

  public int[] sortByBits(int[] arr) { // 8ms, beats 61.40%
    List<Pair> pairs = new ArrayList<>();
    for (int v : arr) pairs.add(new Pair(v, getOnes(v)));
    Collections.sort(pairs);
    int[] res = new int[arr.length];
    for (int i = 0; i < arr.length; i++) res[i] = pairs.get(i).a;
    return res;
  }

  private int getOnes(int n) {
    int sum = 0;
    while (n > 0) {
      sum += n & 1;
      n = n >> 1;
    }
    return sum;
  }

  private record Pair(int a, int b) implements Comparable<Pair> {
    @Override
    public int compareTo(Pair o) {
      if (o.b == b) return a - o.a;
      return b - o.b;
    }
  }
}
