package leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vivek
 * @since 2025-05-11
 */
public class Q2094_E_Finding3DigitEvenNumbers {

  public static void main(String[] args) {
    Q2094_E_Finding3DigitEvenNumbers q2094EFinding3DigitEvenNumbers =
        new Q2094_E_Finding3DigitEvenNumbers();
    System.out.println(
        Arrays.toString(q2094EFinding3DigitEvenNumbers.findEvenNumbers(new int[] {2, 1, 3, 0})));
    System.out.println(
        Arrays.toString(q2094EFinding3DigitEvenNumbers.findEvenNumbers(new int[] {2, 2, 8, 8, 2})));
    System.out.println(
        Arrays.toString(q2094EFinding3DigitEvenNumbers.findEvenNumbers(new int[] {3, 7, 5})));
  }

  public int[] findEvenNumbers(int[] digits) { // 5ms, beats 92.10%
    List<Integer> list = new ArrayList<>(900);
    int[] digitsCount = new int[10];
    for (int digit : digits) digitsCount[digit]++;

    int[] local = new int[10];
    for (int i = 100; i <= 998; i += 2) {
      Arrays.fill(local, 0);
      int j = i;
      while (j > 0) {
        local[j % 10]++;
        j = j / 10;
      }
      boolean present = true;
      for (int k = 0; k < 10; k++)
        if (local[k] > 0 && digitsCount[k] < local[k]) {
          present = false;
          break;
        }
      if (present) list.add(i);
    }
    int[] res = new int[list.size()];
    int k = 0;
    for (int v : list) res[k++] = v;
    return res;
  }
}
